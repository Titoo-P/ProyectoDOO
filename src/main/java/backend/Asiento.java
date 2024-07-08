package backend;

public class Asiento {
    private int numero;
    private String categoria;
    private boolean reservado;

    public Asiento(int numero, String categoria) {
        this.numero = numero;
        this.categoria = categoria;
        this.reservado = false;
    }

    public int getNumero() {
        return numero;
    }

    public String getCategoria() {
        return categoria;
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

