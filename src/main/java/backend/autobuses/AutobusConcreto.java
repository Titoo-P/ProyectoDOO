package backend.autobuses;

import backend.Autobus;

public class AutobusConcreto extends Autobus {
    public AutobusConcreto(String id, String ruta, String horario, int asientosSemiCama, int asientosSalonCama, int precioSemiCama, int precioSalonCama, int numeroDePisos) {
        super(id, ruta, horario, asientosSemiCama, asientosSalonCama, precioSemiCama, precioSalonCama, numeroDePisos);
    }

}
