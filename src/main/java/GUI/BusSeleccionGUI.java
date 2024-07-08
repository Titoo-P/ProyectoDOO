package GUI;

import backend.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusSeleccionGUI extends JFrame {
    private SistemaDeReservas sistemaDeReservas;
    private JComboBox<String> autobusComboBox;

    public BusSeleccionGUI(SistemaDeReservas sistemaDeReservas) {
        this.sistemaDeReservas = sistemaDeReservas;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Selección de Autobús");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel selectionPanel = new JPanel();
        JLabel selectLabel = new JLabel("Seleccione Autobús:");
        autobusComboBox = new JComboBox<>();
        for (String id : sistemaDeReservas.getAutobuses().keySet()) {
            autobusComboBox.addItem(id);
        }

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
        
    }
}

