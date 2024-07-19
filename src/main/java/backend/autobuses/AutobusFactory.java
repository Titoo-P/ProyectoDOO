package backend.autobuses;

public class AutobusFactory {
    public static Autobus crearAutobus(String tipo, String id, String ruta, String horario, int numeroDeAsientosSemiCama, int numeroDeAsientosSalonCama, int precioSemiCama, int precioSalonCama, int numeroDePisos) {
        switch (tipo) {
            case "BIOPIO":
                return new BiopioAutobus(id, ruta, horario, numeroDeAsientosSemiCama, numeroDeAsientosSalonCama, precioSemiCama, precioSalonCama, numeroDePisos);
            case "PULLWOMAN":
                return new PullwomanAutobus(id, ruta, horario, numeroDeAsientosSemiCama, numeroDeAsientosSalonCama, precioSemiCama, precioSalonCama, numeroDePisos);
            default:
                throw new IllegalArgumentException("Tipo de autobús desconocido: " + tipo);
        }
    }
}
