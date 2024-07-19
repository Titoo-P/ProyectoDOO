
import backend.*;
import GUI.*;

import javax.swing.*;

/**
 * La clase {@code Main} es el punto de entrada para la aplicación de reserva de autobuses.
 *
 * <p>Esta clase configura el sistema de reservas creando una instancia única de {@code SistemaDeReservas},
 * agrega algunos autobuses de ejemplo para la demostración y establece un hook de cierre para generar un informe
 * de reservas cuando la aplicación se cierra.</p>
 *
 * <p>Además, inicia la interfaz gráfica de usuario (GUI) que permite a los usuarios seleccionar un autobús
 * para realizar reservas. La GUI se muestra utilizando el hilo de despacho de eventos de Swing.</p>
 */
public class Main {
    /**
     * Método principal que se ejecuta al iniciar la aplicación.
     *
     * <p>Este método configura el sistema de reservas, agrega autobuses de ejemplo y configura un hook
     * de cierre para generar un informe de reservas. Luego, inicia la interfaz gráfica de usuario para
     * que los usuarios puedan seleccionar un autobús y realizar reservas.</p>
     *
     * @param args los argumentos de línea de comandos (no utilizados en esta aplicación)
     */
    public static void main(String[] args) {
        SistemaDeReservas sistemaDeReservas = SistemaDeReservas.getInstance();

        // Agregar algunos autobuses para la demostración
        sistemaDeReservas.agregarAutobus(AutobusFactory.crearAutobus("BIOPIO", "BIOPIO #01", "Concepcion-Los Angeles", "10:00 AM", 16, 12, 1500, 4000, 2));
        sistemaDeReservas.agregarAutobus(AutobusFactory.crearAutobus("BIOPIO", "BIOPIO #02", "Concepcion-Los Angeles", "11:00 AM", 10, 10, 2500, 5000, 1));
        sistemaDeReservas.agregarAutobus(AutobusFactory.crearAutobus("PULLWOMAN", "PULLWOMAN #01", "Concepcion-Santiago", "12:00 PM", 20, 10, 2700, 5500, 2));
        sistemaDeReservas.agregarAutobus(AutobusFactory.crearAutobus("PULLWOMAN", "PULLWOMAN #02", "Concepcion-Santiago", "13:00 PM", 22, 8, 3700, 6500, 2));

        // Añadir un hook de cierre para generar el informe
        Runtime.getRuntime().addShutdownHook(new Thread(sistemaDeReservas::generarReporte));

        // Iniciar GUI de selección de autobús
        SwingUtilities.invokeLater(() -> new BusSeleccionGUI(sistemaDeReservas).setVisible(true));
    }
}
