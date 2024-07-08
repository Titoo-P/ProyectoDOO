package backend;


public class Reserva {
    private Pasajero pasajero;
    private Asiento asiento;
    private double precio;

    public Reserva(Pasajero pasajero, Asiento asiento, double precio) {
        this.pasajero = pasajero;
        this.asiento = asiento;
        this.precio = precio;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public double getPrecio() {
        return precio;
    }
}

