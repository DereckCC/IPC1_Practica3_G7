package com.grupo_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class GraficaNotas extends JFrame implements ActionListener {



    Alumnos[] alumnos = Main.alumnos;
    int ctAlumnos = Main.contadorA;

    Cursos[] cursos = Main.cursos;
    int ctCursos = Main.contadorC;

    Asignaciones[] asignaciones = Main.asignaciones;
    int ctAsignaciones = Main.contadorAsignaciones;


    JFrame Displaygraficas;
    JTextField t1;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    JFreeChart grafico;
    ChartPanel cPanel;
    JButton b1,b2,b3;

    String nombreCurso;

    double[] valores = new double[ctAsignaciones];

    public GraficaNotas() {

        Displaygraficas = new JFrame("Graficas");
        Displaygraficas.setBounds(100, 100, 700, 750);
        Displaygraficas.setLayout(null);
        Displaygraficas.getContentPane().setBackground(new java.awt.Color(25, 42, 86));
        Displaygraficas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Displaygraficas.setResizable(false);
        Displaygraficas.setVisible(true);


        int valorcontador=0;
        for (int j=0;j<ctCursos;j++) {
            if (MenuGraficas.CodigoId == cursos[j].getCodigo()) {
                for (int k=0;k<ctAsignaciones;k++){
                    if (cursos[j].getId() == asignaciones[k].getIdCurso()) {
                        nombreCurso=cursos[j].getNombre();
                        for (int z = 0; z < ctAlumnos; z++) {
                            // only changes num, not the array element
                            if (alumnos[z].getId() == asignaciones[k].getIdAlumno()) {


                                valores[valorcontador]=asignaciones[k].getNota();
                                valorcontador++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < valorcontador;i++){
            datos.setValue(valores[i], "Curso: "+nombreCurso, ""+valores[i]);

        }

        grafico = ChartFactory.createBarChart("Gráfica del curso: "+ nombreCurso,"Valores obtenidos","Puntajes",datos,PlotOrientation.VERTICAL,true,true,false);



        cPanel = new ChartPanel(grafico);
        cPanel.setBounds(25, 105, 650, 500);
        Displaygraficas.add(cPanel);



        b1 = new JButton("Regresar");
        b1.setBounds(25, 650, 630, 30);
        b1.setVisible(true);
        b1.addActionListener(this);
        Displaygraficas.add(b1);

        b2 = new JButton("Bubble Sort");
        b2.setBounds(540, 15, 100, 30);
        b2.setVisible(true);
        b2.addActionListener(this);
        Displaygraficas.add(b2);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            Displaygraficas.dispose();
            MenuGraficas nueva = new MenuGraficas();
        }

        if (e.getSource() == b2) {
            Displaygraficas.dispose();
            GraficaNotasBubble gNB = new GraficaNotasBubble();
        }
    }
}

