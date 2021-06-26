package com.grupo_7;

import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuCarga extends JFrame implements ActionListener {
    public String arc1, arc2, acr3;
    JFrame cargaArchivos;
    JButton b1,b2,b3,b4,b5;
    JLabel titulo, titulo2,titulo3;
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
public MenuCarga() {

    cargaArchivos = new JFrame("Carga de archivos.");
    cargaArchivos.setBounds(100, 100, 650, 250);
    cargaArchivos.setLayout(null);
    cargaArchivos.getContentPane().setBackground(new java.awt.Color(25, 42, 86));
    cargaArchivos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cargaArchivos.setResizable(false);
    cargaArchivos.setVisible(true);

    titulo = new JLabel("Bienvenido a la carga de archivos.");
    titulo.setFont(new Font("arial", Font.ITALIC, 25));
    titulo.setBounds(125, 10, 400, 50);
    titulo.setForeground(new Color(255,255,255));
    titulo.setVisible(true);
    cargaArchivos.add(titulo);


    l1 = new JLabel("Ruta:");
    l1.setFont(new Font("arial", Font.ITALIC, 20));
    l1.setBounds(40, 50, 300, 50);
    l1.setForeground(new Color(255,255,255));
    l1.setVisible(true);
    cargaArchivos.add(l1);


    t1 = new JTextField();
    t1.setBounds(90, 60, 470, 30);
    t1.setFont(new Font("arial", Font.ITALIC, 14));
    t1.setVisible(true);
    cargaArchivos.add(t1);


    b1 = new JButton("Cargar archivos.");
    b1.setBounds(90, 100, 470, 30);
    b1.setVisible(true);
    b1.addActionListener(this);
    cargaArchivos.add(b1);


    b4 = new JButton("Cerrar programa.");
    b4.setBounds(90, 140, 220, 30);
    b4.setVisible(true);
    b4.addActionListener(this);
    cargaArchivos.add(b4);

    b5 = new JButton("Generar graficas.");
    b5.setBounds(340, 140, 220, 30);
    b5.setVisible(true);
    b5.addActionListener(this);
    cargaArchivos.add(b5);

}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            arc1 = t1.getText();
            try {
                Main.leerAlumnos(arc1);
                Main.leerCursos(arc1);
                Main.leerAsignaciones(arc1);
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Algo salio mal, intente de nuevo.");
            }
        }
        if (e.getSource() == b4){
            cargaArchivos.dispose();
        }
        if (e.getSource() == b5){
            //SOLO ABRE LA GRAFICA DE EDAD, NO SE COMO PODRIA METERLO DENTRO DEL FRAME
            MenuGraficas nueva = new MenuGraficas();
            cargaArchivos.dispose();


            //MenuGraficas nueva = new MenuGraficas();
           //cargaArchivos.dispose();
        }
    }
}

