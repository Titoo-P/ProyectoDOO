
import Excepciones.*;
import backend.*;

import backend.autobuses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas para {@link SistemaDeReservas}.
 *
 * <p>Esta clase contiene pruebas unitarias que verifican el comportamiento correcto
 * del sistema de reservas, incluyendo la adición de autobuses, la reserva y cancelación
 * de asientos, y la gestión de reservas para autobuses.</p>
 */
public class SistemaDeReservasTest {

    private SistemaDeReservas sistemaDeReservas;
    private AutobusConcreto autobus;

    /**
     * Configuración previa a cada prueba.
     *
     * <p>Inicializa una instancia del sistema de reservas y agrega un autobús de prueba.
     * También limpia cualquier autobús existente en el sistema para asegurar pruebas independientes.</p>
     */
    @BeforeEach
    public void setUp() {
        sistemaDeReservas = SistemaDeReservas.getInstance(); // Utilizar el singleton
        sistemaDeReservas.getAutobuses().clear(); // Limpiar autobuses antes de cada prueba
        autobus = new AutobusConcreto("1", "Ruta A", "10:00 AM", 4, 4, 100, 200, 1);
        sistemaDeReservas.agregarAutobus(autobus);
    }

    /**
     * Prueba la adición de un autobús al sistema.
     *
     * <p>Verifica que el autobús se haya agregado correctamente al sistema de reservas.</p>
     */
    @Test
    public void testAgregarAutobus() {
        assertEquals(1, sistemaDeReservas.getAutobuses().size(), "El número de autobuses debería ser 1.");
    }

    /**
     * Prueba la selección de un autobús por su ID.
     *
     * <p>Verifica que el autobús seleccionado por ID exista en el sistema y que
     * la selección de un ID no existente devuelva null.</p>
     */
    @Test
    public void testSeleccionarAutobus() {
        assertNotNull(sistemaDeReservas.seleccionarAutobus("1"), "El autobús con ID '1' debería existir.");
        assertNull(sistemaDeReservas.seleccionarAutobus("999"), "El autobús con ID '999' no debería existir.");
    }

    /**
     * Prueba la reserva de un asiento.
     *
     * <p>Verifica que un asiento pueda ser reservado correctamente y que el estado
     * del asiento cambie a reservado. También se asegura que no se pueda reservar
     * el mismo asiento más de una vez.</p>
     */
    @Test
    public void testReservarAsiento() {
        Pasajero pasajero = new Pasajero("Juan");
        boolean reservado = sistemaDeReservas.reservarAsiento("1", 1, pasajero, 100.0);
        assertTrue(reservado, "El asiento debería ser reservado correctamente.");

        // Verificar que el asiento está reservado
        Asiento asiento = autobus.getAsiento(1);
        assertTrue(asiento.isReservado(), "El asiento debería estar reservado.");

        // Intentar reservar el mismo asiento nuevamente
        boolean reservadoOtraVez = sistemaDeReservas.reservarAsiento("1", 1, new Pasajero("Pedro"), 100.0);
        assertFalse(reservadoOtraVez, "No debería ser posible reservar el mismo asiento más de una vez.");
    }

    /**
     * Prueba la cancelación de una reserva.
     *
     * <p>Verifica que una reserva existente pueda ser cancelada y que el asiento
     * vuelva a estar disponible.</p>
     */
    @Test
    public void testCancelarReserva() {
        Pasajero pasajero = new Pasajero("Juan");
        sistemaDeReservas.reservarAsiento("1", 1, pasajero, 100.0);
        sistemaDeReservas.cancelarReserva("1", 1);

        // Verificar que el asiento está disponible de nuevo
        Asiento asiento = autobus.getAsiento(1);
        assertFalse(asiento.isReservado(), "El asiento debería estar disponible después de cancelar la reserva.");
    }

    /**
     * Prueba la obtención de una reserva.
     *
     * <p>Verifica que se pueda obtener una reserva existente y que la información
     * del pasajero sea la correcta.</p>
     */
    @Test
    public void testGetReserva() {
        Pasajero pasajero = new Pasajero("Juan");
        sistemaDeReservas.reservarAsiento("1", 1, pasajero, 100.0);
        Reserva reserva = sistemaDeReservas.getReserva("1", 1);

        assertNotNull(reserva, "La reserva debería existir.");
        assertEquals("Juan", reserva.getPasajero().getNombre(), "El nombre del pasajero debería ser 'Juan'.");
    }

    /**
     * Prueba la reserva de un asiento en un autobús que no existe.
     *
     * <p>Verifica que la reserva de un asiento en un autobús no existente devuelva
     * false, indicando que la reserva no pudo ser realizada.</p>
     */
    @Test
    public void testReservaAutobusNoExistente() {
        Pasajero pasajero = new Pasajero("Juan");
        boolean reservado = sistemaDeReservas.reservarAsiento("999", 1, pasajero, 100.0);
        assertFalse(reservado, "No debería ser posible reservar un asiento en un autobús que no existe.");
    }

    /**
     * Prueba la reserva de un asiento en un autobús de múltiples pisos.
     *
     * <p>Verifica que se pueda reservar un asiento en un autobús de varios pisos y
     * que el estado del asiento cambie a reservado.</p>
     */
    @Test
    public void testReservarAsientoAutobusMultipiso() {
        AutobusConcreto autobusMultipiso = new AutobusConcreto("2", "Ruta B", "02:00 PM", 6, 6, 150, 300, 2);
        sistemaDeReservas.agregarAutobus(autobusMultipiso);

        Pasajero pasajero = new Pasajero("María");
        boolean reservado = sistemaDeReservas.reservarAsiento("2", 8, pasajero, 300.0);
        assertTrue(reservado, "El asiento debería ser reservado correctamente en un autobús de múltiples pisos.");

        // Verificar que el asiento está reservado
        Asiento asiento = autobusMultipiso.getAsiento(8);
        assertTrue(asiento.isReservado(), "El asiento debería estar reservado.");
    }
}

