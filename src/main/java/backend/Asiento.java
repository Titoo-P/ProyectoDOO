package backend;

/**
 * La clase Asiento representa un asiento en un autobús.
 * Cada asiento tiene un número, una categoría, un estado de reserva y un precio.
 */
public class Asiento {
    private int numero;
    private String categoria;
    private boolean reservado;
    private int precio;

    /**
     * Constructor para crear un asiento con el número, categoría y precio especificados.
     * El estado de reserva se inicializa como false.
     *
     * @param numero el número del asiento
     * @param categoria la categoría del asiento (por ejemplo, "Semi Cama", "Salón Cama")
     * @param precio el precio del asiento
     */
    public Asiento(int numero, String categoria, int precio) {
        this.numero = numero;
        this.categoria = categoria;
        this.reservado = false;
        this.precio = precio;
    }

    /**
     * Obtiene el número del asiento.
     *
     * @return el número del asiento
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Obtiene la categoría del asiento.
     *
     * @return la categoría del asiento
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Obtiene el precio del asiento.
     *
     * @return el precio del asiento
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Verifica si el asiento está reservado.
     *
     * @return true si el asiento está reservado, false en caso contrario
     */
    public boolean isReservado() {
        return reservado;
    }

    /**
     * Reserva el asiento estableciendo el estado de reserva a true.
     */
    public void reservar() {
        this.reservado = true;
    }

    /**
     * Cancela la reserva del asiento estableciendo el estado de reserva a false.
     */
    public void cancelar() {
        this.reservado = false;
    }

    /**
     * Establece el estado de reserva del asiento.
     *
     * @param reservado el nuevo estado de reserva del asiento
     */
    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
}


