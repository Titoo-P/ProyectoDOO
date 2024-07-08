package backend;

import java.util.List;
import java.util.ArrayList;

public class Autobus {
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
        if (numeroDeAsientosSemiCama % 2 != 0) {
            throw new IllegalArgumentException("El número de asientos semi-cama debe ser par.");
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
        for (int i = 1; i <= numeroDeAsientosSemiCama; i++) {
            asientos.add(new Asiento(i, "Semi Cama", precioSemiCama));
        }
        for (int i = numeroDeAsientosSemiCama + 1; i <= numeroDeAsientosSemiCama + numeroDeAsientosSalonCama; i++) {
            asientos.add(new Asiento(i, "Salón Cama", precioSalonCama));
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
        return asientos.get(numero - 1);
    }
}

