package backend;

import Excepciones.*;
import backend.autobuses.Autobus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;

public class SistemaDeReservas {
    private static SistemaDeReservas instance;
    private Map<String, Autobus> autobuses;
    private Map<String, Map<Integer, Reserva>> reservas;

    private SistemaDeReservas() {
        this.autobuses = new HashMap<>();
        this.reservas = new HashMap<>();
    }

    public static synchronized SistemaDeReservas getInstance() {
        if (instance == null) {
            instance = new SistemaDeReservas();
        }
        return instance;
    }

    public void agregarAutobus(Autobus autobus) {
        autobuses.put(autobus.getId(), autobus);
        reservas.put(autobus.getId(), new HashMap<>());
    }

    public Autobus seleccionarAutobus(String id) {
        return autobuses.get(id);
    }

    public boolean reservarAsiento(String idAutobus, int numeroAsiento, Pasajero pasajero, double precio) {
        Autobus autobus = seleccionarAutobus(idAutobus);
        if (autobus != null) {
            try {
                Asiento asiento = autobus.getAsiento(numeroAsiento);
                if (!asiento.isReservado()) {
                    asiento.setReservado(true);
                    Reserva reserva = new Reserva(idAutobus, pasajero, asiento, precio);
                    reservas.get(idAutobus).put(numeroAsiento, reserva);
                    return true;
                }
            } catch (InvalidSeatNumberException e) {
                System.err.println(e.getMessage());
            }
        }
        return false;
    }


    public void cancelarReserva(String idAutobus, int numeroAsiento) {
        Autobus autobus = seleccionarAutobus(idAutobus);
        if (autobus != null) {
            try {
                Asiento asiento = autobus.getAsiento(numeroAsiento);
                if (asiento.isReservado()) {
                    asiento.setReservado(false);
                    reservas.get(idAutobus).remove(numeroAsiento);
                }
            } catch (InvalidSeatNumberException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public Reserva getReserva(String idAutobus, int numeroDeAsiento) {
        return reservas.get(idAutobus).get(numeroDeAsiento);
    }

    public Map<String, Autobus> getAutobuses() {
        return autobuses;
    }

    public void generarReporte() {
        try (FileWriter writer = new FileWriter("reporte_reservas.txt")) {
            for (Map<Integer, Reserva> reservaPorAutobus : reservas.values()) {
                for (Reserva reserva : reservaPorAutobus.values()) {
                    writer.write("Autobús ID: " + reserva.getIdAutobus() + "\n");
                    writer.write("Pasajero: " + reserva.getPasajero().getNombre() + "\n");
                    writer.write("Asiento: " + reserva.getAsiento().getNumero() + "\n");
                    writer.write("Categoría: " + reserva.getAsiento().getCategoria() + "\n");
                    writer.write("Precio: $" + reserva.getPrecio() + "\n\n");
                }
            }
            System.out.println("Informe de reservas generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al generar el informe de reservas: " + e.getMessage());
        }
    }
}

