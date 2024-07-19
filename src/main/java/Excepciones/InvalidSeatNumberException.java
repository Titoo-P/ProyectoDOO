package Excepciones;

/**
 * Excepción lanzada cuando se intenta acceder a un asiento con un número inválido.
 *
 * <p>Esta excepción se utiliza para indicar que el número de asiento proporcionado no
 * es válido o no está dentro del rango permitido para el autobús.</p>
 *
 * <p>Extiende {@link RuntimeException} para señalar que es una excepción no comprobada,
 * lo que significa que no es necesario capturarla o declararla en el método que la puede lanzar.</p>
 */
public class InvalidSeatNumberException extends RuntimeException {

    /**
     * Crea una nueva instancia de {@code InvalidSeatNumberException} con el mensaje especificado.
     *
     * @param message el mensaje que describe el error
     */
    public InvalidSeatNumberException(String message) {
        super(message);
    }
}
