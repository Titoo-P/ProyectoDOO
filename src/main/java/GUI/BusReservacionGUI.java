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
                    manejarReserva(numero);
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

    private void manejarReserva(int numero) {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));
        if (nombre != null && !nombre.trim().isEmpty()) {
            Pasajero pasajero = new Pasajero(nombre);
            if (sistemaDeReservas.reservarAsiento(autobus.getId(), numero, pasajero, precio)) {
                botonesAsiento[numero - 1].setBackground(Color.RED);
                estadoLabel.setText("Asiento " + numero + " reservado para " + nombre);
            } else {
                estadoLabel.setText("El asiento " + numero + " ya está reservado.");
            }
        } else {
            estadoLabel.setText("Nombre no puede estar vacío.");
        }
    }
}

