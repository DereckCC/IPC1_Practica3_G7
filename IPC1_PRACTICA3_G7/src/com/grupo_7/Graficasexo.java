package com.grupo_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

public class Graficasexo extends JFrame implements ActionListener {
    public static int contador_1, contador_2;
    JFrame Displaygraficas;
   JLabel titulo, codigo;
   JTextField t1;
   DefaultPieDataset pieGenero;
   JFreeChart chart;
   ChartPanel frame;
   JButton b1;
   public Graficasexo(){
       Displaygraficas = new JFrame("Graficas");
       Displaygraficas.setBounds(100, 100, 500, 450);
       Displaygraficas.setLayout(null);
       Displaygraficas.getContentPane().setBackground(new java.awt.Color(25, 42, 86));
       Displaygraficas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Displaygraficas.setResizable(false);
       Displaygraficas.setVisible(true);

       pieGenero = new DefaultPieDataset();
       pieGenero.setValue("Masculino", new Integer(0));
       pieGenero.setValue("Femenino", new Integer(0));
       chart = ChartFactory.createPieChart("Genero Alumnos", pieGenero, true,true,false);

       frame = new ChartPanel(chart);
       frame.setBounds(25,25,435,300);
       Displaygraficas.add(frame);
       frame.setVisible(true);
       Displaygraficas.repaint();

       Alumnos[] misalumnos = Main.alumnos;
       Asignaciones[] asig = Main.asignaciones;
       Cursos[] curs = Main.cursos;
       int ctAlumnos = Main.contadorA;
       int ctAsignaciones= Main.contadorAsignaciones;
       int ctCursos= Main.contadorC;
       int valorPosicion=0;
       contador_1 = 0;
       contador_2 = 0;
       int valor= asig.length;

       for (int j=0;j<ctCursos;j++) {
           //Recorremos los cursos para encontrar la similitud.
           if (MenuGraficas.CodigoId == curs[j].getCodigo()) {
               for (int k=0;k<ctAsignaciones;k++){
                   if (curs[j].getId() == asig[k].getIdCurso()) {
                       for (int z = 0; z < ctAlumnos; z++) {
                           // only changes num, not the array element
                           if (misalumnos[z].getId() == asig[k].getIdAlumno()) {
                               try {
                               if (misalumnos[z].getGenero().equals("M")){
                                   contador_1++;
                               }else if (misalumnos[z].getGenero().equals("F")){
                                   contador_2++;
                               }
                           }catch (Exception e){
                               //no fallaria aca pero igual por si acaso
                                   JOptionPane.showMessageDialog(null, "Algo salio malr");
                               continue;
                           }
                               break;

                           }
                       }
                   }
               }
           }
       }
       pieGenero.setValue("Masculino", new Integer(contador_1));
       pieGenero.setValue("Femenino", new Integer(contador_2));
       chart = ChartFactory.createPieChart("Genero Alumnos", pieGenero, true,true,false);

       frame = new ChartPanel(chart);
       frame.setBounds(25,25,435,300);
       frame.setVisible(true);
       Displaygraficas.add(frame);


       b1 = new JButton("Regresar");
       b1.setBounds(25, 350, 435, 30);
       b1.setVisible(true);
       b1.addActionListener(this);
       Displaygraficas.add(b1);

   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            Displaygraficas.dispose();
            MenuGraficas nueva = new MenuGraficas();
        }
    }
}
