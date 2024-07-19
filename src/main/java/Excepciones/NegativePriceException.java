package Excepciones;

/**
 * Excepción lanzada cuando se encuentra un precio negativo en una operación relacionada con los asientos.
 *
 * <p>Esta excepción se utiliza para indicar que el precio proporcionado para un asiento o una reserva es negativo,
 * lo cual no es permitido en el sistema de reservas.</p>
 *
 * <p>Extiende {@link RuntimeException} para señalar que es una excepción no comprobada,
 * lo que significa que no es necesario capturarla o declararla en el método que la puede lanzar.</p>
 */
public class NegativePriceException extends RuntimeException {

    /**
     * Crea una nueva instancia de {@code NegativePriceException} con el mensaje especificado.
     *
     * @param message el mensaje que describe el error
     */
    public NegativePriceException(String message) {
        super(message);
    }
}
