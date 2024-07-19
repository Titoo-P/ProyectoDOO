package backend;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;

public enum ImagenesEnum {
    ICONO("/bus.jpg");

    private final String ruta;

    ImagenesEnum(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public ImageIcon getImageIcon() {
        URL resource = getClass().getResource(ruta);
        if (resource == null) {
            System.err.println("Resource not found: " + ruta);
            throw new IllegalArgumentException("Resource not found: " + ruta);
        }
        return new ImageIcon(resource);
    }

    public Image getImage() {
        return getImageIcon().getImage();
    }
}