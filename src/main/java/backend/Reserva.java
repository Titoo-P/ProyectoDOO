package backend;


public class Reserva {
    private Pasajero pasajero;
    private String idAutobus;
    private Asiento asiento;
    private double precio;

    public Reserva(String idAutobus, Pasajero pasajero, Asiento asiento, double precio) {
        this.idAutobus = idAutobus;
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.precio = precio;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }
    public String getIdAutobus(){
        return idAutobus;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public double getPrecio() {
        return precio;
    }
}

