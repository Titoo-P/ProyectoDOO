package backend;


/**
 * La clase Reserva representa una reserva de asiento en un autobús.
 * Cada reserva tiene un pasajero, un ID de autobús, un asiento y un precio.
 */
public class Reserva {
    private Pasajero pasajero;
    private String idAutobus;
    private Asiento asiento;
    private double precio;

    /**
     * Constructor para crear una reserva con los detalles especificados.
     *
     * @param idAutobus el ID del autobús en el que se realiza la reserva
     * @param pasajero el pasajero que realiza la reserva
     * @param asiento el asiento reservado
     * @param precio el precio de la reserva
     */
    public Reserva(String idAutobus, Pasajero pasajero, Asiento asiento, double precio) {
        this.idAutobus = idAutobus;
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.precio = precio;
    }

    /**
     * Obtiene el pasajero que realizó la reserva.
     *
     * @return el pasajero de la reserva
     */
    public Pasajero getPasajero() {
        return pasajero;
    }

    /**
     * Obtiene el ID del autobús en el que se realizó la reserva.
     *
     * @return el ID del autobús de la reserva
     */
    public String getIdAutobus() {
        return idAutobus;
    }

    /**
     * Obtiene el asiento reservado.
     *
     * @return el asiento de la reserva
     */
    public Asiento getAsiento() {
        return asiento;
    }

    /**
     * Obtiene el precio de la reserva.
     *
     * @return el precio de la reserva
     */
    public double getPrecio() {
        return precio;
    }
}


