
import backend.*;
import GUI.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SistemaDeReservas sistemaDeReservas = new SistemaDeReservas();

        // Agregar algunos autobuses para la demostración
        sistemaDeReservas.agregarAutobus(new Autobus("BIOPIO #01", "Concepcion-Los Angeles", "10:00 AM", 10, 10, 2500, 5000, 1));
        sistemaDeReservas.agregarAutobus(new Autobus("BIOPIO #02", "Concepcion-Los Angeles", "11:00 AM", 16, 6, 2500, 5000, 1));


        sistemaDeReservas.agregarAutobus(new Autobus("PULLWOMAN #01", "Concepcion-Santiago", "12:00 PM", 20, 10, 2700, 5500,2));
        sistemaDeReservas.agregarAutobus(new Autobus("PULLWOMAN #02", "Concepcion-Santiago", "14:00 PM", 12, 3, 3100, 5200,2));
        sistemaDeReservas.agregarAutobus(new Autobus("PULLWOMAN #03", "Concepcion-Santiago", "15:00 PM", 14, 1, 3100, 5200,2));
        sistemaDeReservas.agregarAutobus(new Autobus("PULLWOMAN #04", "Concepcion-Santiago", "16:30 PM", 12, 6, 3100, 5200,2));
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
