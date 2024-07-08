
import backend.*;
import GUI.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SistemaDeReservas sistemaDeReservas = new SistemaDeReservas();

        // Agregar algunos autobuses para la demostración
        sistemaDeReservas.agregarAutobus(new Autobus("001", "Ruta 1", "10:00 AM", 30, 10, 2500, 5000, 1));
        sistemaDeReservas.agregarAutobus(new Autobus("002", "Ruta 2", "12:00 PM", 20, 10, 2700, 5500,2));

        // Añadir un hook de cierre para generar el informe
        Runtime.getRuntime().addShutdownHook(new Thread(sistemaDeReservas::generarReporte));

        // Iniciar GUI de selección de autobús
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BusSeleccionGUI(sistemaDeReservas).setVisible(true);
            }
        });
    }
}
