package backend;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;

/**
 * La enumeración {@code ImagenesEnum} proporciona una manera de manejar las imágenes de la aplicación.
 * Incluye la ruta de la imagen y métodos para obtener un {@code ImageIcon} y una {@code Image} desde los recursos.
 */
public enum ImagenesEnum {
    /**
     * Icono de la aplicación.
     */
    ICONO("/bus.jpg");

    private final String ruta;

    /**
     * Constructor de la enumeración {@code ImagenesEnum}.
     *
     * @param ruta la ruta del recurso de la imagen
     */
    ImagenesEnum(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Obtiene la ruta del recurso de la imagen.
     *
     * @return la ruta del recurso de la imagen
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Obtiene un {@code ImageIcon} correspondiente a la imagen definida por la ruta de este enum.
     *
     * @return un {@code ImageIcon} que representa la imagen
     * @throws IllegalArgumentException si no se encuentra el recurso
     */
    public ImageIcon getImageIcon() {
        URL resource = getClass().getResource(ruta);
        if (resource == null) {
            System.err.println("Resource not found: " + ruta);
            throw new IllegalArgumentException("Resource not found: " + ruta);
        }
        return new ImageIcon(resource);
    }

    /**
     * Obtiene una {@code Image} correspondiente a la imagen definida por la ruta de este enum.
     *
     * @return una {@code Image} que representa la imagen
     * @throws IllegalArgumentException si no se encuentra el recurso
     */
    public Image getImage() {
        return getImageIcon().getImage();
    }
}
