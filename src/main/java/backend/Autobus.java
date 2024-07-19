package backend;

import Excepciones.*;

import java.util.List;
import java.util.ArrayList;
/**
 * La clase Autobus representa un autobús con sus asientos y detalles.
 * Cada autobús tiene un ID, una ruta, un horario, asientos de diferentes categorías y un número de pisos.
 */
public abstract class Autobus {
    private String id;
    private String ruta;
    private String horario;
    private int numeroDeAsientosSemiCama;
    private int numeroDeAsientosSalonCama;
    private int precioSemiCama;
    private int precioSalonCama;
    private List<Asiento> asientos;
    private int numeroDePisos;

    /**
     * Constructor para crear un autobús con los detalles especificados.
     *
     * @param id el ID del autobús
     * @param ruta la ruta del autobús
     * @param horario el horario del autobús
     * @param numeroDeAsientosSemiCama el número de asientos semi cama
     * @param numeroDeAsientosSalonCama el número de asientos salón cama
     * @param precioSemiCama el precio de los asientos semi cama
     * @param precioSalonCama el precio de los asientos salón cama
     * @param numeroDePisos el número de pisos del autobús
     * @throws InvalidSeatNumberException si el número de asientos es negativo
     * @throws NegativePriceException si el precio es negativo
     * @throws InvalidFloorNumberException si el número de pisos no es 1 o 2
     */
    public Autobus(String id, String ruta, String horario, int numeroDeAsientosSemiCama, int numeroDeAsientosSalonCama, int precioSemiCama, int precioSalonCama, int numeroDePisos) {
        if (numeroDeAsientosSemiCama < 0 || numeroDeAsientosSalonCama < 0) {
            throw new InvalidSeatNumberException("El número de asientos no puede ser negativo.");
        }
        if (precioSemiCama < 0 || precioSalonCama < 0) {
            throw new NegativePriceException("El precio no puede ser negativo.");
        }
        if (numeroDePisos != 1 && numeroDePisos != 2) {
            throw new InvalidFloorNumberException("El número de pisos debe ser 1 o 2.");
        }

        this.id = id;
        this.ruta = ruta;
        this.horario = horario;
        this.numeroDeAsientosSemiCama = numeroDeAsientosSemiCama;
        this.numeroDeAsientosSalonCama = numeroDeAsientosSalonCama;
        this.precioSemiCama = precioSemiCama;
        this.precioSalonCama = precioSalonCama;
        this.numeroDePisos = numeroDePisos;
        this.asientos = new ArrayList<>();
        crearAsientos();
    }

    /**
     * Crea los asientos del autobús de acuerdo a la configuración especificada.
     */
    private void crearAsientos() {
        if (numeroDePisos == 1) {
            // Autobús de un solo piso: semi cama primero, luego salón cama
            for (int i = 1; i <= numeroDeAsientosSemiCama; i++) {
                asientos.add(new Asiento(i, "Semi Cama", precioSemiCama));
            }
            for (int i = numeroDeAsientosSemiCama + 1; i <= numeroDeAsientosSemiCama + numeroDeAsientosSalonCama; i++) {
                asientos.add(new Asiento(i, "Salón Cama", precioSalonCama));
            }
        } else if (numeroDePisos == 2) {
            // Autobús de dos pisos: primer piso semi cama, segundo piso salón cama
            for (int i = 1; i <= numeroDeAsientosSemiCama; i++) {
                asientos.add(new Asiento(i, "Semi Cama", precioSemiCama));
            }
            for (int i = numeroDeAsientosSemiCama + 1; i <= numeroDeAsientosSemiCama + numeroDeAsientosSalonCama; i++) {
                asientos.add(new Asiento(i, "Salón Cama", precioSalonCama));
            }
        }
    }

    /**
     * Obtiene el número de pisos del autobús.
     *
     * @return el número de pisos del autobús
     */
    public int getNumeroDePisos() {
        return numeroDePisos;
    }

    /**
     * Obtiene el ID del autobús.
     *
     * @return el ID del autobús
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene la ruta del autobús.
     *
     * @return la ruta del autobús
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Obtiene el horario del autobús.
     *
     * @return el horario del autobús
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Obtiene la lista de asientos del autobús.
     *
     * @return la lista de asientos del autobús
     */
    public List<Asiento> getAsientos() {
        return asientos;
    }

    /**
     * Obtiene un asiento específico por su número.
     *
     * @param numero el número del asiento
     * @return el asiento correspondiente al número especificado
     * @throws InvalidSeatNumberException si el número de asiento está fuera de los límites
     */
    public Asiento getAsiento(int numero) {
        if (numero < 1 || numero > asientos.size()) {
            throw new InvalidSeatNumberException("Número de asiento fuera de los límites.");
        }
        return asientos.get(numero - 1);
    }

    /**
     * Obtiene el número de asientos semi cama del autobús.
     *
     * @return el número de asientos semi cama
     */
    public int getNumeroDeAsientosSemiCama() {
        return numeroDeAsientosSemiCama;
    }

    /**
     * Obtiene el precio de los asientos salón cama.
     *
     * @return el precio de los asientos salón cama
     */
    public int getPrecioSalonCama() {
        return precioSalonCama;
    }

    /**
     * Obtiene el precio de los asientos semi cama.
     *
     * @return el precio de los asientos semi cama
     */
    public int getPrecioSemiCama() {
        return precioSemiCama;
    }
}

