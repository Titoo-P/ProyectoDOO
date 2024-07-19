package Excepciones;

/**
 * Excepción lanzada cuando se intenta acceder a un piso con un número inválido.
 *
 * <p>Esta excepción se utiliza para indicar que el número de piso proporcionado no
 * es válido o no está dentro del rango permitido para el autobús.</p>
 *
 * <p>Extiende {@link RuntimeException} para señalar que es una excepción no comprobada,
 * lo que significa que no es necesario capturarla o declararla en el método que la puede lanzar.</p>
 */
public class InvalidFloorNumberException extends RuntimeException {

    /**
     * Crea una nueva instancia de {@code InvalidFloorNumberException} con el mensaje especificado.
     *
     * @param message el mensaje que describe el error
     */
    public InvalidFloorNumberException(String message) {
        super(message);
    }
}
