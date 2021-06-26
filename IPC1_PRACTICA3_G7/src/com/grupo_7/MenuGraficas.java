package com.grupo_7;

import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuGraficas extends JFrame implements ActionListener {
    public static int CodigoId;
    public static String Codigo;
    JFrame MenuGraficas;
    JLabel codigo;
    JTextField t1;
    JButton b1, b2, b3, b4;

    public MenuGraficas() {
        MenuGraficas = new JFrame("Menu graficas");
        MenuGraficas.setBounds(100, 100, 400, 350);
        MenuGraficas.setLayout(null);
        MenuGraficas.getContentPane().setBackground(new java.awt.Color(25, 42, 86));
        MenuGraficas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuGraficas.setResizable(false);
        MenuGraficas.setVisible(true);

        codigo = new JLabel("Codigo del curso:");
        codigo.setFont(new Font("arial", Font.BOLD, 20));
        codigo.setBounds(115, 10, 250, 50);
        codigo.setForeground(new Color(255,255,255));
        codigo.setVisible(true);
        MenuGraficas.add(codigo);

        t1 = new JTextField();
        t1.setBounds(115, 50, 165, 30);
        t1.setFont(new Font("arial", Font.BOLD, 16));
        t1.setVisible(true);
        MenuGraficas.add(t1);

        b1 = new JButton("Gráfica por sexo.");
        b1.setBounds(115, 100, 165, 30);
        b1.setVisible(true);
        b1.addActionListener(this);
        MenuGraficas.add(b1);

        b2 = new JButton("Gráfica por edad.");
        b2.setBounds(115, 150, 165, 30);
        b2.setVisible(true);
        b2.addActionListener(this);
        MenuGraficas.add(b2);


        b3 = new JButton("Gráfica por notas");
        b3.setBounds(115, 200, 165, 30);
        b3.setVisible(true);
        b3.addActionListener(this);
        MenuGraficas.add(b3);

        b4 = new JButton("Regresar");
        b4.setBounds(115, 250, 165, 30);
        b4.setVisible(true);
        b4.addActionListener(this);
        MenuGraficas.add(b4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                Codigo = t1.getText();
                CodigoId = Integer.parseInt(Codigo);
                Graficasexo nueva = new Graficasexo();
                MenuGraficas.dispose();
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "El campo de texto esta vacio, por favor ingrese algun valor");
            }
        }
        if (e.getSource() == b2) {
            try {
                Codigo = t1.getText();
                CodigoId = Integer.parseInt(Codigo);
                GraficaEdad grafiEdad = new GraficaEdad();
               /* grafiEdad.pack();
                RefineryUtilities.centerFrameOnScreen(grafiEdad);
                grafiEdad.setVisible(true);*/
                MenuGraficas.dispose();
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "El campo de texto esta vacio, por favor ingrese algun valor");
            }
        }
        if (e.getSource() == b3) {
            try {
                Codigo = t1.getText();
                CodigoId = Integer.parseInt(Codigo);
                GraficaNotas nueva2 = new GraficaNotas();
                MenuGraficas.dispose();
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "El campo de texto esta vacio, por favor ingrese algun valor");
            }
        }
        if (e.getSource() == b4) {
           MenuCarga menuCarga = new MenuCarga();
           MenuGraficas.dispose();
        }
    }
}













