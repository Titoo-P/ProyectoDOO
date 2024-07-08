package GUI;

import backend.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusSeleccionGUI extends JFrame {
    private SistemaDeReservas sistemaDeReservas;
    private JComboBox<String> autobusComboBox;
    private JTextArea detallesTextArea;

    public BusSeleccionGUI(SistemaDeReservas sistemaDeReservas) {
        this.sistemaDeReservas = sistemaDeReservas;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Selección de Autobús");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel selectionPanel = new JPanel();
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

    private void mostrarDetallesAutobus(String id) {
        Autobus autobus = sistemaDeReservas.seleccionarAutobus(id);
        StringBuilder detalles = new StringBuilder();
        detalles.append("Ruta: ").append(autobus.getRuta()).append("\n");
        detalles.append("Horario: ").append(autobus.getHorario()).append("\n");
        detalles.append("Asientos Semi Cama:\n");

        for (Asiento asiento : autobus.getAsientos()) {
            if (asiento.getCategoria().equals("Semi Cama")) {
                detalles.append("  Asiento ").append(asiento.getNumero()).append(" - Precio: $").append(asiento.getPrecio()).append("\n");
            }
        }

        detalles.append("Asientos Salón Cama:\n");
        for (Asiento asiento : autobus.getAsientos()) {
            if (asiento.getCategoria().equals("Salón Cama")) {
                detalles.append("  Asiento ").append(asiento.getNumero()).append(" - Precio: $").append(asiento.getPrecio()).append("\n");
            }
        }

        detallesTextArea.setText(detalles.toString());
    }

}

