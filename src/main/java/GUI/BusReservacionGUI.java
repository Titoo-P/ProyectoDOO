package GUI;


import Excepciones.*;
import backend.*;
import backend.autobuses.Autobus;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusReservacionGUI extends JFrame {
    private JButton[] botonesAsiento;
    private SistemaDeReservas sistemaDeReservas;
    private Autobus autobus;
    private JLabel estadoLabel;

    public BusReservacionGUI(SistemaDeReservas sistemaDeReservas, Autobus autobus) {
        this.sistemaDeReservas = sistemaDeReservas;
        this.autobus = autobus;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Sistema de Reserva de Asientos");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Panel para el primer piso
        JPanel piso1Panel = new JPanel(new GridLayout(0, 5, 10, 10));
        piso1Panel.setBorder(BorderFactory.createTitledBorder("Piso 1"));

        // Panel para el segundo piso
        JPanel piso2Panel = new JPanel(new GridLayout(0, 5, 10, 10));
        piso2Panel.setBorder(BorderFactory.createTitledBorder("Piso 2"));

        botonesAsiento = new JButton[autobus.getAsientos().size()];

        int midpoint = autobus.getNumeroDePisos() == 2 ? autobus.getNumeroDeAsientosSemiCama() : autobus.getAsientos().size() / autobus.getNumeroDePisos();

        for (int i = 0; i < botonesAsiento.length; i++) {
            final int numero = i + 1;
            Asiento asiento = autobus.getAsiento(numero);
            botonesAsiento[i] = new JButton("Asiento " + numero);
            botonesAsiento[i].setPreferredSize(new Dimension(50, 30));
            botonesAsiento[i].setBackground(asiento.getCategoria().equals("Salón Cama") ? Color.CYAN : Color.GREEN);
            botonesAsiento[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    manejarReserva(numero);
                }
            });
            if (asiento.isReservado()) {
                botonesAsiento[i].setBackground(Color.RED);
            }

            // Añadir los botones a los paneles de acuerdo al piso
            if (i < midpoint) {
                if (i % 4 == 2) {
                    piso1Panel.add(new JLabel());
                }
                piso1Panel.add(botonesAsiento[i]);
            } else {
                if ((i - midpoint) % 4 == 2) {
                    piso2Panel.add(new JLabel());
                }
                piso2Panel.add(botonesAsiento[i]);
            }

        }

        estadoLabel = new JLabel("Seleccione un asiento para reservar.");
        estadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        estadoLabel.setFont(new Font("Serif", Font.BOLD, 14));

        mainPanel.add(piso1Panel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre pisos
        mainPanel.add(piso2Panel);

        add(mainPanel, BorderLayout.CENTER);
        add(estadoLabel, BorderLayout.SOUTH);
    }

    private void manejarReserva(int numero) {
        Asiento asiento = autobus.getAsiento(numero);
        try {
            if (asiento.isReservado()) {
                JOptionPane.showMessageDialog(this, "El asiento " + numero + " ya está reservado. Por favor, seleccione otro asiento.", "Asiento Ocupado", JOptionPane.ERROR_MESSAGE);
                estadoLabel.setText("El asiento " + numero + " ya está reservado.");
            } else {
                String nombre = JOptionPane.showInputDialog(this, "Asiento: " + numero + "\nCategoría: " + asiento.getCategoria() + "\nPrecio: $" + asiento.getPrecio() + "\nPiso: " + (numero <= autobus.getAsientos().size() / autobus.getNumeroDePisos() ? "1" : "2") + "\n\nIngrese su nombre:");
                if (nombre != null && !nombre.trim().isEmpty()) {
                    Pasajero pasajero = new Pasajero(nombre);
                    double precio = asiento.getCategoria().equals("Salón Cama") ? autobus.getPrecioSalonCama() : autobus.getPrecioSemiCama();
                    sistemaDeReservas.reservarAsiento(autobus.getId(), numero, pasajero, precio);
                    botonesAsiento[numero - 1].setBackground(Color.RED);
                    estadoLabel.setText("Asiento " + numero + " reservado para " + nombre + ". Precio: $" + precio);

                    // Mostrar mensaje emergente de confirmación
                    JOptionPane.showMessageDialog(this, "Compra confirmada para el asiento " + numero + ".\n¡Gracias por su reserva!", "Compra Confirmada", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Nombre no puede estar vacío","Error en la Reserva", JOptionPane.ERROR_MESSAGE);
                    estadoLabel.setText("Nombre no puede estar vacío.");
                }
            }
        } catch (InvalidSeatNumberException | NegativePriceException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error en la Reserva", JOptionPane.ERROR_MESSAGE);
            estadoLabel.setText("Error al reservar el asiento " + numero + ".");
        }
    }
}

