package backend;

import Excepciones.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;

public class SistemaDeReservas {
    private Map<String, Autobus> autobuses;
    private Map<Integer, Reserva> reservas;

    public SistemaDeReservas() {
        this.autobuses = new HashMap<>();
        this.reservas = new HashMap<>();
    }

    public void agregarAutobus(Autobus autobus) {
        autobuses.put(autobus.getId(), autobus);
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
                    Reserva reserva = new Reserva(idAutobus,pasajero, asiento, precio);
                    reservas.put(numeroAsiento, reserva);
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
                    reservas.remove(numeroAsiento);
                }
            } catch (InvalidSeatNumberException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public Reserva getReserva(String autobusId, int numeroDeAsiento) {
        return reservas.get(numeroDeAsiento);
    }

    public Map<String, Autobus> getAutobuses() {
        return autobuses;
    }

    public void generarReporte() {
        try (FileWriter writer = new FileWriter("reporte_reservas.txt")) {
            for (Reserva reserva : reservas.values()) {
                writer.write("Autobús ID: " + reserva.getIdAutobus().toString() + "\n");
                writer.write("Pasajero: " + reserva.getPasajero().getNombre() + "\n");
                writer.write("Asiento: " + reserva.getAsiento().getNumero() + "\n");
                writer.write("Categoría: " + reserva.getAsiento().getCategoria() + "\n");
                writer.write("Precio: $" + reserva.getPrecio() + "\n\n");
            }
            System.out.println("Informe de reservas generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al generar el informe de reservas: " + e.getMessage());
        }
    }
}

