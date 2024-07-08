package backend;

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

    public boolean reservarAsiento(String autobusId, int numeroDeAsiento, Pasajero pasajero, double precio) {
        Autobus autobus = autobuses.get(autobusId);
        if (autobus != null) {
            Asiento asiento = autobus.getAsiento(numeroDeAsiento);
            if (!asiento.isReservado()) {
                asiento.reservar();
                reservas.put(numeroDeAsiento, new Reserva(pasajero, asiento, precio));
                return true;
            }
        }
        return false;
    }

    public void cancelarReserva(String autobusId, int numeroDeAsiento) {
        Autobus autobus = autobuses.get(autobusId);
        if (autobus != null) {
            Asiento asiento = autobus.getAsiento(numeroDeAsiento);
            if (asiento.isReservado()) {
                asiento.cancelar();
                reservas.remove(numeroDeAsiento);
            }
        }
    }

    public void generarReporte() {
        try (FileWriter writer = new FileWriter("reporte_reservas.txt")) {
            for (Reserva reserva : reservas.values()) {
                writer.write("Autobús ID: " + reserva.getAsiento().getNumero() + "\n");
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

    public Reserva getReserva(String autobusId, int numeroDeAsiento) {
        return reservas.get(numeroDeAsiento);
    }

    public Map<String, Autobus> getAutobuses() {
        return autobuses;
    }
}

