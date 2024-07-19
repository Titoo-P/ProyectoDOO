package backend.autobuses;

import backend.Autobus;

/**
 * La clase {@code BiopioAutobus} representa un autobús de tipo Biopio.
 * Esta clase extiende {@code Autobus} y proporciona una implementación específica
 * para el tipo Biopio de autobús, pero no añade funcionalidad adicional a la clase base.
 *
 * <p>Se utiliza para crear instancias de autobuses que pertenecen a la categoría Biopio,
 * con los detalles como el identificador, la ruta, el horario, el número de asientos y los precios
 * definidos al instanciar el objeto.</p>
 */
public class BiopioAutobus extends Autobus {

    /**
     * Crea una nueva instancia de {@code BiopioAutobus}.
     *
     * @param id el identificador del autobús
     * @param ruta la ruta que sigue el autobús
     * @param horario el horario de salida del autobús
     * @param numeroDeAsientosSemiCama el número de asientos semi cama en el autobús
     * @param numeroDeAsientosSalonCama el número de asientos salón cama en el autobús
     * @param precioSemiCama el precio de un asiento semi cama
     * @param precioSalonCama el precio de un asiento salón cama
     * @param numeroDePisos el número de pisos del autobús
     */
    public BiopioAutobus(String id, String ruta, String horario, int numeroDeAsientosSemiCama, int numeroDeAsientosSalonCama, int precioSemiCama, int precioSalonCama, int numeroDePisos) {
        super(id, ruta, horario, numeroDeAsientosSemiCama, numeroDeAsientosSalonCama, precioSemiCama, precioSalonCama, numeroDePisos);
    }
}

