package backend;

import backend.autobuses.BiopioAutobus;
import backend.autobuses.PullwomanAutobus;

/**
 * La clase {@code AutobusFactory} es una fábrica para crear instancias de {@code Autobus}.
 * Dependiendo del tipo de autobús especificado, se instancia una subclase específica de {@code Autobus}.
 */
public class AutobusFactory {

    /**
     * Crea una instancia de {@code Autobus} basada en el tipo especificado.
     *
     * @param tipo el tipo de autobús a crear, que puede ser "BIOPIO" o "PULLWOMAN"
     * @param id el identificador del autobús
     * @param ruta la ruta que sigue el autobús
     * @param horario el horario de salida del autobús
     * @param numeroDeAsientosSemiCama el número de asientos semi cama en el autobús
     * @param numeroDeAsientosSalonCama el número de asientos salón cama en el autobús
     * @param precioSemiCama el precio de un asiento semi cama
     * @param precioSalonCama el precio de un asiento salón cama
     * @param numeroDePisos el número de pisos del autobús
     * @return una instancia de {@code Autobus} del tipo especificado
     * @throws IllegalArgumentException si el tipo de autobús no es reconocido
     */
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

