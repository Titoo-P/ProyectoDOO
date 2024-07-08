package GUI;

import backend.*;


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
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel asientosPanel = new JPanel(new GridLayout(5, 5, 10, 10));
        botonesAsiento = new JButton[autobus.getAsientos().size()];

        for (int i = 0; i < botonesAsiento.length; i++) {
            final int numero = i + 1;
            botonesAsiento[i] = new JButton("Asiento " + numero);
            botonesAsiento[i].setBackground(Color.GREEN);
            botonesAsiento[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
            asientosPanel.add(botonesAsiento[i]);
        }

        estadoLabel = new JLabel("Seleccione un asiento para reservar.");
        estadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        estadoLabel.setFont(new Font("Serif", Font.BOLD, 14));

        add(asientosPanel, BorderLayout.CENTER);
        add(estadoLabel, BorderLayout.SOUTH);
    }

}

