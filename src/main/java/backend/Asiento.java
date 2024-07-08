package backend;

public class Asiento {
    private int numero;
    private String categoria;
    private boolean reservado;
    private float precio;

    public Asiento(int numero, String categoria, float precio) {
        this.numero = numero;
        this.categoria = categoria;
        this.reservado = false;
        this.precio = precio;
    }

    public int getNumero() {
        return numero;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void reservar() {
        this.reservado = true;
    }

    public void cancelar() {
        this.reservado = false;
    }
}

