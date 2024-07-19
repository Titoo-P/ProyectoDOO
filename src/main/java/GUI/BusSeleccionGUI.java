package GUI;

import backend.*;
import backend.Autobus;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase BusSeleccionGUI proporciona una interfaz gráfica de usuario
 * para seleccionar un autobús y ver sus detalles antes de proceder a la reserva de asientos.
 */
public class BusSeleccionGUI extends JFrame {
    private SistemaDeReservas sistemaDeReservas;
    private JComboBox<String> autobusComboBox;
    private JTextArea detallesTextArea;

    /**
     * Constructor de la clase BusSeleccionGUI.
     *
     * @param sistemaDeReservas la instancia del sistema de reservas
     */
    public BusSeleccionGUI(SistemaDeReservas sistemaDeReservas) {
        this.sistemaDeReservas = sistemaDeReservas;
        initializeUI();

        setIconImage(ImagenesEnum.ICONO.getImage());
    }
    /**
     * Inicializa la interfaz gráfica de usuario.
     */

    private void initializeUI() {
        setTitle("Selección de Autobús");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel selectionPanel = new JPanel();
        selectionPanel.setOpaque(false); // Hacer transparente el panel
        JLabel selectLabel = new JLabel("Seleccione Autobús:");
        autobusComboBox = new JComboBox<>();
        for (String id : sistemaDeReservas.getAutobuses().keySet()) {
            autobusComboBox.addItem(id);
        }
        autobusComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDetallesAutobus((String) autobusComboBox.getSelectedItem());
            }
        });

        JButton selectButton = new JButton("Seleccionar");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedId = (String) autobusComboBox.getSelectedItem();
                Autobus autobus = sistemaDeReservas.seleccionarAutobus(selectedId);
                new BusReservacionGUI(sistemaDeReservas, autobus).setVisible(true);
                dispose();
            }
        });

        detallesTextArea = new JTextArea();
        detallesTextArea.setEditable(false);
        detallesTextArea.setPreferredSize(new Dimension(400, 200));

        selectionPanel.add(selectLabel);
        selectionPanel.add(autobusComboBox);
        selectionPanel.add(selectButton);
        add(selectionPanel, BorderLayout.NORTH);
        add(new JScrollPane(detallesTextArea), BorderLayout.CENTER);
    }

    /**
     * Muestra los detalles del autobús seleccionado en el área de texto.
     *
     * @param id el ID del autobús seleccionado
     */
    private void mostrarDetallesAutobus(String id) {
        Autobus autobus = sistemaDeReservas.seleccionarAutobus(id);
        StringBuilder detalles = new StringBuilder();
        detalles.append(" Ruta: ").append(autobus.getRuta()).append("\n");
        detalles.append(" Horario: ").append(autobus.getHorario()).append("\n");
        detalles.append(" Pisos: ").append(autobus.getNumeroDePisos()).append("\n\n");

        detalles.append(" Asientos Semi Cama:\n");

        for (Asiento asiento : autobus.getAsientos()) {
            if (asiento.getCategoria().equals("Semi Cama")) {
                detalles.append("   Asiento ").append(asiento.getNumero()).append(" - Precio: $").append(asiento.getPrecio()).append("\n");
            }
        }

        detalles.append("\n Asientos Salón Cama:\n");
        for (Asiento asiento : autobus.getAsientos()) {
            if (asiento.getCategoria().equals("Salón Cama")) {
                detalles.append("   Asiento ").append(asiento.getNumero()).append(" - Precio: $").append(asiento.getPrecio()).append("\n");
            }
        }

        detallesTextArea.setText(detalles.toString());
    }

}

