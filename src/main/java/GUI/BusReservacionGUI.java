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
            if (autobus.getAsiento(numero).isReservado()) {
                botonesAsiento[i].setBackground(Color.RED);
            }
            asientosPanel.add(botonesAsiento[i]);
        }

        estadoLabel = new JLabel("Seleccione un asiento para reservar.");
        estadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        estadoLabel.setFont(new Font("Serif", Font.BOLD, 14));

        add(asientosPanel, BorderLayout.CENTER);
        add(estadoLabel, BorderLayout.SOUTH);
    }

    private void manejarReserva(int numero) {
        Asiento asiento = autobus.getAsiento(numero);
        if (asiento.isReservado()) {
            JOptionPane.showMessageDialog(this, "El asiento " + numero + " ya está reservado. Por favor, seleccione otro asiento.", "Asiento Ocupado", JOptionPane.ERROR_MESSAGE);
            estadoLabel.setText("El asiento " + numero + " ya está reservado.");
        } else {
            String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                Pasajero pasajero = new Pasajero(nombre);
                if (sistemaDeReservas.reservarAsiento(autobus.getId(), numero, pasajero, asiento.getPrecio())) {
                    botonesAsiento[numero - 1].setBackground(Color.RED);
                    estadoLabel.setText("Asiento " + numero + " reservado para " + nombre + ". Precio: $" + asiento.getPrecio());
                } else {
                    estadoLabel.setText("Error al reservar el asiento " + numero + ".");
                }
            } else {
                estadoLabel.setText("Nombre no puede estar vacío.");
            }
        }
    }
}

