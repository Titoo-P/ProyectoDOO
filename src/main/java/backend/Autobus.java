package backend;

import java.util.List;
import java.util.ArrayList;

public class Autobus {
    private String id;
    private String ruta;
    private String horario;
    private List<Asiento> asientos;

    public Autobus(String id, String ruta, String horario, int numeroDeAsientos, String categoriaAsiento) {
        this.id = id;
        this.ruta = ruta;
        this.horario = horario;
        this.asientos = new ArrayList<>(numeroDeAsientos);
        for (int i = 1; i <= numeroDeAsientos; i++) {
            asientos.add(new Asiento(i, categoriaAsiento));
        }
    }

    public String getId() {
        return id;
    }

    public String getRuta() {
        return ruta;
    }

    public String getHorario() {
        return horario;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public Asiento getAsiento(int numero) {
        return asientos.get(numero - 1);
    }
}

