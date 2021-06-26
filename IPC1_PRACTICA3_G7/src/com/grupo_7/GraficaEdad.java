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

public class GraficaEdad extends JFrame implements ActionListener {



    Alumnos[] alumnos = Main.alumnos;
    int ctAlumnos = Main.contadorA;

    Cursos[] cursos = Main.cursos;
    int ctCursos = Main.contadorC;

    Asignaciones[] asignaciones = Main.asignaciones;
    int ctAsignaciones = Main.contadorAsignaciones;

    int series1;
    int series2;
    int series3;
    int series4;
    int series5;
    int series6;
    int series7;
    int series8;
    int series9;
    int series10;


    JFrame Displaygraficas;
    public JLabel tiempo,tiempo2;
    JTextField t1;

    JFreeChart chart;
    ChartPanel frame;
    JButton b1;

    String nombreCurso;

    double[] valores = new double[ctAsignaciones];

    public GraficaEdad() {

        Displaygraficas = new JFrame("Graficas");
        Displaygraficas.setBounds(100, 100, 700, 750);
        Displaygraficas.setLayout(null);
        Displaygraficas.getContentPane().setBackground(new java.awt.Color(25, 42, 86));
        Displaygraficas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Displaygraficas.setResizable(false);
        Displaygraficas.setVisible(true);

        int contSeries1 = 0;
        int contSeries2 = 0;
        int contSeries3 = 0;
        int contSeries4 = 0;
        int contSeries5 = 0;
        int contSeries6 = 0;
        int contSeries7 = 0;
        int contSeries8 = 0;
        int contSeries9 = 0;
        int contSeries10 = 0;


        for (int j = 0; j < ctCursos; j++) {
            if (MenuGraficas.CodigoId == cursos[j].getCodigo()) {
                for (int k = 0; k < ctAsignaciones; k++) {
                    if (cursos[j].getId() == asignaciones[k].getIdCurso()) {
                        nombreCurso = cursos[j].getNombre();
                        for (int z = 0; z < ctAlumnos; z++) {
                            // only changes num, not the array element
                            if (alumnos[z].getId() == asignaciones[k].getIdAlumno()) {
                                int edad;
                                int anioActual = 2021;
                                String[] fechaNac = Main.alumnos[z].getFechaNacimiento().split("/");
                                String anio = fechaNac[2];
                                int anioA = Integer.parseInt(anio);
                                edad = anioActual - anioA;

                                if (edad >= 0 && edad <= 10) {
                                    contSeries1++;

                                } else if (edad >= 11 && edad <= 20) {
                                    contSeries2++;
                                } else if (edad >= 21 && edad <= 30) {
                                    contSeries3++;
                                } else if (edad >= 31 && edad <= 40) {
                                    contSeries4++;
                                } else if (edad >= 41 && edad <= 50) {
                                    contSeries5++;
                                } else if (edad >= 51 && edad <= 60) {
                                    contSeries6++;
                                } else if (edad >= 61 && edad <= 70) {
                                    contSeries7++;
                                } else if (edad >= 71 && edad <= 80) {
                                    contSeries8++;
                                } else if (edad >= 81 && edad <= 90) {
                                    contSeries9++;
                                } else if (edad >= 91 && edad <= 100) {
                                    contSeries10++;
                                }


                            }
                        }
                    }
                }
            }
        }

        this.series1 = contSeries1;
        this.series2 = contSeries2;
        this.series3 = contSeries3;
        this.series4 = contSeries4;
        this.series5 = contSeries5;
        this.series6 = contSeries6;
        this.series7 = contSeries7;
        this.series8 = contSeries8;
        this.series9 = contSeries9;
        this.series10 = contSeries10;


        chart = ChartFactory.createBarChart("Gráfica por Edad" + ": " +  nombreCurso,
                "Rango de Edades",
                "Cantidad de Alumnos",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );


        frame = new ChartPanel(chart);
        frame.setBounds(25, 105, 650, 500);
        Displaygraficas.add(frame);
        //Displaygraficas.repaint();
        //frame.setVisible(true);

       /* titulo = new JLabel();
        titulo.setText("NOMBRE DE CURSO: ");
        titulo.setBounds(10,10, 80,50);
        Displaygraficas.add(titulo);

        tituloC = new JLabel();
        tituloC.setText("NOMBRE DE CURSO: ");
        tituloC.setBounds(90,10, 80,50);
        Displaygraficas.add(tituloC);


        tiempo = new JLabel("Tiempo de Ejecucion: ");
        tiempo.setBounds(10,10,180,20);
        tiempo.setForeground(new Color(255,255,255));
        Displaygraficas.add(tiempo);

        tiempo2 = new JLabel("Tiempo de Ejecucion: ");
        tiempo2.setBounds(150,10,180,20);
        tiempo2.setForeground(new Color(255,255,255));
        Displaygraficas.add(tiempo2);*/

        b1 = new JButton("Regresar");
        b1.setBounds(25, 650, 630, 30);
        b1.setVisible(true);
        b1.addActionListener(this);
        Displaygraficas.add(b1);

    }



    private CategoryDataset createDataset() {

        // row keys...
        final String series1 = "0-10";
        final String series2 = "11-20";
        final String series3 = "21-30";
        final String series4 = "31-40";
        final String series5 = "41-50";
        final String series6 = "51-60";
        final String series7 = "61-70";
        final String series8 = "71-80";
        final String series9 = "81-90";
        final String series10 = "91-100";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(this.series1, "01-10", series1);
        dataset.addValue(this.series2, "11-20", series2);
        dataset.addValue(this.series3, "21-30", series3);
        dataset.addValue(this.series4, "31-40", series4);
        dataset.addValue(this.series5, "41-50", series5);
        dataset.addValue(this.series6, "51-60", series6);
        dataset.addValue(this.series7, "61-70", series7);
        dataset.addValue(this.series8, "71-80", series8);
        dataset.addValue(this.series9, "81-90", series9);
        dataset.addValue(this.series10, "91-100", series10);

        return dataset;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            Displaygraficas.dispose();
            MenuGraficas nueva = new MenuGraficas();
        }
    }
}

