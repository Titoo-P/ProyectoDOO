package backend.autobuses;

import backend.Autobus;

public class PullwomanAutobus extends Autobus {
    public PullwomanAutobus(String id, String ruta, String horario, int numeroDeAsientosSemiCama, int numeroDeAsientosSalonCama, int precioSemiCama, int precioSalonCama, int numeroDePisos) {
        super(id, ruta, horario, numeroDeAsientosSemiCama, numeroDeAsientosSalonCama, precioSemiCama, precioSalonCama, numeroDePisos);
    }
}
