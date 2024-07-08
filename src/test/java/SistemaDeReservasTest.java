


import backend.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaDeReservasTest {
    @Test
    public void testReservarAsiento() {
        SistemaDeReservas sistema = new SistemaDeReservas();
        Autobus autobus = new Autobus("001", "Ruta 1", "10:00 AM", 4, 2, 2500, 5000, 1);
        sistema.agregarAutobus(autobus);

        Pasajero pasajero = new Pasajero("Juan Perez");
        assertTrue(sistema.reservarAsiento("001", 1, pasajero, 2500));
    }

    @Test
    public void testReservarAsientoInvalido() {
        SistemaDeReservas sistema = new SistemaDeReservas();
        Autobus autobus = new Autobus("001", "Ruta 1", "10:00 AM", 4, 2, 2500, 5000, 1);
        sistema.agregarAutobus(autobus);

        Pasajero pasajero = new Pasajero("Juan Perez");
        assertFalse(sistema.reservarAsiento("001", 100, pasajero, 2500)); // Asiento inválido
    }

    @Test
    public void testInvalidSeatCountException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Autobus("001", "Ruta 1", "10:00 AM", 5, 2, 2500, 5000, 1); // Número impar de asientos semi-cama
        });

        String expectedMessage = "El número de asientos semi-cama debe ser par.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}

