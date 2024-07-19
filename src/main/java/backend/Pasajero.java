package backend;

/**
 * La clase Pasajero representa a un pasajero que realiza una reserva en el sistema.
 */
public class Pasajero {
    private String nombre;

    /**
     * Constructor de la clase Pasajero.
     *
     * @param nombre el nombre del pasajero
     */
    public Pasajero(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del pasajero.
     *
     * @return el nombre del pasajero
     */
    public String getNombre() {
        return nombre;
    }
}


