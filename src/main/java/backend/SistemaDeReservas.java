package backend;

import java.util.HashMap;
import java.util.Map;

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

    public Reserva getReserva(String autobusId, int numeroDeAsiento) {
        return reservas.get(numeroDeAsiento);
    }
}

