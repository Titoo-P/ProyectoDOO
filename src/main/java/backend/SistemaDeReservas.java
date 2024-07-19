package backend;

import Excepciones.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;

/**
 * La clase SistemaDeReservas gestiona la reserva de asientos en autobuses.
 * Implementa el patrón Singleton para asegurar una única instancia.
 */
public class SistemaDeReservas {
    private static SistemaDeReservas instance;
    private Map<String, Autobus> autobuses;
    private Map<String, Map<Integer, Reserva>> reservas;

    /**
     * Constructor privado para el patrón Singleton.
     * Inicializa los mapas de autobuses y reservas.
     */
    private SistemaDeReservas() {
        this.autobuses = new HashMap<>();
        this.reservas = new HashMap<>();
    }

    /**
     * Devuelve la única instancia de SistemaDeReservas.
     *
     * @return la instancia única de SistemaDeReservas
     */
    public static synchronized SistemaDeReservas getInstance() {
        if (instance == null) {
            instance = new SistemaDeReservas();
        }
        return instance;
    }

    /**
     * Agrega un autobús al sistema de reservas.
     *
     * @param autobus el autobús a agregar
     */
    public void agregarAutobus(Autobus autobus) {
        autobuses.put(autobus.getId(), autobus);
        reservas.put(autobus.getId(), new HashMap<>());
    }

    /**
     * Selecciona un autobús por su ID.
     *
     * @param id el ID del autobús
     * @return el autobús seleccionado, o null si no se encuentra
     */
    public Autobus seleccionarAutobus(String id) {
        return autobuses.get(id);
    }

    /**
     * Reserva un asiento en un autobús para un pasajero.
     *
     * @param idAutobus    el ID del autobús
     * @param numeroAsiento el número del asiento
     * @param pasajero     el pasajero que realiza la reserva
     * @param precio       el precio de la reserva
     * @return true si la reserva se realizó con éxito, false en caso contrario
     */
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

    /**
     * Cancela una reserva en un autobús.
     *
     * @param idAutobus    el ID del autobús
     * @param numeroAsiento el número del asiento reservado
     */
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

    /**
     * Obtiene una reserva específica en un autobús.
     *
     * @param idAutobus    el ID del autobús
     * @param numeroDeAsiento el número del asiento reservado
     * @return la reserva encontrada, o null si no se encuentra
     */
    public Reserva getReserva(String idAutobus, int numeroDeAsiento) {
        return reservas.get(idAutobus).get(numeroDeAsiento);
    }

    /**
     * Obtiene todos los autobuses del sistema de reservas.
     *
     * @return un mapa de autobuses
     */
    public Map<String, Autobus> getAutobuses() {
        return autobuses;
    }

    /**
     * Genera un informe de todas las reservas y lo guarda en un archivo de texto.
     */
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

