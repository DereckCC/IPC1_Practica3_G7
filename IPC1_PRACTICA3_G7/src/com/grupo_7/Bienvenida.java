package com.grupo_7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Bienvenida extends JFrame implements ActionListener {
    JLabel Titulo, Titulo2;
    JButton b1;
    public Bienvenida(){
        //Inicio Pantalla inicio
        this.setTitle("Inicio de sesión");
        this.setBounds(100, 100, 500, 200);
        this.setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(25, 42, 86));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        //Fin Pantalla inicio
        //Mostrando texto
        Titulo = new JLabel("BIENVENIDO ADMINISTRADOR");
        Titulo.setFont(new Font("arial", Font.ITALIC, 20));
        Titulo.setBounds(100, 10, 300, 50);
        Titulo.setForeground(new Color(255,255,255));
        Titulo.setVisible(true);
        this.add(Titulo);
        //Cerrando texto
        //Mostrando botones
        b1 = new JButton("SIGUIENTE");
        b1.setBounds(170, 75, 150, 30);
        b1.setVisible(true);
        b1.addActionListener(this);
        this.add(b1);
        //Cerrando botones
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MenuCarga moduloAdministracion = new MenuCarga();
        this.dispose();
    }
}
