package backend;

import Excepciones.*;

import java.util.List;
import java.util.ArrayList;

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

    public Autobus(String id, String ruta, String horario, int numeroDeAsientosSemiCama, int numeroDeAsientosSalonCama, int precioSemiCama, int precioSalonCama,int numeroDePisos) {
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

    public int getNumeroDePisos() {
        return numeroDePisos;
    }

    public String getId() {
        return id;
    }

    public String getRuta() {
        return ruta;
    }

    public String getHorario() {
        return horario;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public Asiento getAsiento(int numero) {
        if (numero < 1 || numero > asientos.size()) {
            throw new InvalidSeatNumberException("Número de asiento fuera de los límites.");
        }
        return asientos.get(numero - 1);
    }

    public int getNumeroDeAsientosSemiCama() {
        return  numeroDeAsientosSemiCama;
    }

    public int getPrecioSalonCama() {
        return precioSalonCama;
    }

    public int getPrecioSemiCama() {
        return precioSemiCama;
    }
}

