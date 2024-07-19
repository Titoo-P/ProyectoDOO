package backend.autobuses;

import backend.Autobus;
/**
 * La clase {@code AutobusConcreto} es una implementación concreta de {@code Autobus}.
 * Esta clase se utiliza exclusivamente para pruebas en tests unitarios.
 *
 * <p>Extiende la clase {@code Autobus} y proporciona una implementación concreta
 * para la creación de autobuses con datos específicos para realizar pruebas.
 */
public class AutobusConcreto extends Autobus {

    /**
     * Crea una nueva instancia de {@code AutobusConcreto}.
     *
     * @param id el identificador del autobús
     * @param ruta la ruta que sigue el autobús
     * @param horario el horario de salida del autobús
     * @param asientosSemiCama el número de asientos semi cama en el autobús
     * @param asientosSalonCama el número de asientos salón cama en el autobús
     * @param precioSemiCama el precio de un asiento semi cama
     * @param precioSalonCama el precio de un asiento salón cama
     * @param numeroDePisos el número de pisos del autobús
     */
    public AutobusConcreto(String id, String ruta, String horario, int asientosSemiCama, int asientosSalonCama, int precioSemiCama, int precioSalonCama, int numeroDePisos) {
        super(id, ruta, horario, asientosSemiCama, asientosSalonCama, precioSemiCama, precioSalonCama, numeroDePisos);
    }
}

