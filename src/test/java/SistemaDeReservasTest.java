
import Excepciones.*;
import backend.*;

import backend.autobuses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaDeReservasTest {
    private SistemaDeReservas sistemaDeReservas;
    private AutobusConcreto autobus;

    @BeforeEach
    public void setUp() {
        sistemaDeReservas = SistemaDeReservas.getInstance(); // Utilizar el singleton
        sistemaDeReservas.getAutobuses().clear(); // Limpiar autobuses antes de cada prueba
        autobus = new AutobusConcreto("1", "Ruta A", "10:00 AM", 4, 4, 100, 200, 1);
        sistemaDeReservas.agregarAutobus(autobus);
    }

    @Test
    public void testAgregarAutobus() {
        assertEquals(1, sistemaDeReservas.getAutobuses().size());
    }

    @Test
    public void testSeleccionarAutobus() {
        assertNotNull(sistemaDeReservas.seleccionarAutobus("1"));
        assertNull(sistemaDeReservas.seleccionarAutobus("999")); // Autobús no existente
    }

    @Test
    public void testReservarAsiento() {
        Pasajero pasajero = new Pasajero("Juan");
        boolean reservado = sistemaDeReservas.reservarAsiento("1", 1, pasajero, 100.0);
        assertTrue(reservado);

        // Verificar que el asiento está reservado
        Asiento asiento = autobus.getAsiento(1);
        assertTrue(asiento.isReservado());

        // Intentar reservar el mismo asiento nuevamente
        boolean reservadoOtraVez = sistemaDeReservas.reservarAsiento("1", 1, new Pasajero("Pedro"), 100.0);
        assertFalse(reservadoOtraVez);
    }

    @Test
    public void testCancelarReserva() {
        Pasajero pasajero = new Pasajero("Juan");
        sistemaDeReservas.reservarAsiento("1", 1, pasajero, 100.0);
        sistemaDeReservas.cancelarReserva("1", 1);

        // Verificar que el asiento está disponible de nuevo
        Asiento asiento = autobus.getAsiento(1);
        assertFalse(asiento.isReservado());
    }

    @Test
    public void testGetReserva() {
        Pasajero pasajero = new Pasajero("Juan");
        sistemaDeReservas.reservarAsiento("1", 1, pasajero, 100.0);
        Reserva reserva = sistemaDeReservas.getReserva("1", 1);

        assertNotNull(reserva);
        assertEquals("Juan", reserva.getPasajero().getNombre());
    }

    @Test
    public void testReservaAutobusNoExistente() {
        Pasajero pasajero = new Pasajero("Juan");
        boolean reservado = sistemaDeReservas.reservarAsiento("999", 1, pasajero, 100.0);
        assertFalse(reservado);
    }

    @Test
    public void testReservarAsientoAutobusMultipiso() {
        AutobusConcreto autobusMultipiso = new AutobusConcreto("2", "Ruta B", "02:00 PM", 6, 6, 150, 300, 2);
        sistemaDeReservas.agregarAutobus(autobusMultipiso);

        Pasajero pasajero = new Pasajero("María");
        boolean reservado = sistemaDeReservas.reservarAsiento("2", 8, pasajero, 300.0);
        assertTrue(reservado);

        // Verificar que el asiento está reservado
        Asiento asiento = autobusMultipiso.getAsiento(8);
        assertTrue(asiento.isReservado());
    }
}

