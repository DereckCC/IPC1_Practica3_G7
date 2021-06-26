package com.grupo_7;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import javax.swing.UIManager;

public class Main {
    public static Scanner consola = new Scanner(System.in);
    public static Alumnos[] alumnos ;
    public static int contadorA=0;
    public static Cursos[] cursos ;
    public static int contadorC=0;
    public static Asignaciones[] asignaciones ;
    public static int contadorAsignaciones=0;
    static Bienvenida welcome;
    static MenuCarga MC;
    static Graficasexo gg;
    static MenuGraficas mg;

    public static void main(String[] args) throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel(new AcrylLookAndFeel());
            welcome = new Bienvenida();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public static void leerAlumnos(String arc1) throws IOException {
        //Declaramos el buffer donde se almacenará el contenido del archivo
        BufferedReader br = null;

        String nombre = "\\alumnos.csv";
        String rutaArchivo;
        rutaArchivo = arc1 + nombre;
        alumnos= new Alumnos[300];

        try {

            //Inicializamos el buffer colocando la ruta del archivo
            br = new BufferedReader(new FileReader(rutaArchivo));
            //Leemos el archivo línea por línea
            String linea = br.readLine();
            linea = br.readLine();


            //Mientras queden líneas en el buffer seguiremos leyendolas.
            while (linea != null) {
                String[] parametros = linea.split(",");
                boolean flag = false;

                //VERIFICACIONES

                //ID----------------------------
                if(((parametros[0].trim()).isEmpty()) ){
                    System.out.println("Lo sentimos, falta el id");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }else{
                    try{
                        Integer.parseInt(parametros[0].trim());
                        flag=false;
                    }catch (Exception e){
                        flag=true;
                    }
                }
                if (flag) {
                    System.out.println("Campo de ID mal ingresado");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                //ID REPETIDO
                for (int z = 0; z < contadorA; z++) {
                    // only changes num, not the array element

                    if (alumnos[z].getId() == Integer.parseInt(parametros[0].trim())) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    //Log.addToEndFile("Logs.txt", " " + new Date().toString() + " El alumno con el id: " + Integer.parseInt(parametros[0].trim()) +" Ya fue agregado"+ "\n");
                    System.out.println("El alumno con ese ID ya fue agregado");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }

                //CARNET------------------------------
                if(((parametros[1].trim()).isEmpty()) ){
                    System.out.println("Lo sentimos, falta el carnet");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }else{
                    try{
                        Integer.parseInt(parametros[1].trim());
                        flag=false;
                    }catch (Exception e){
                        flag=true;
                    }
                }
                if (flag) {
                    System.out.println("Campo de carnet mal ingresado");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                //Carnet REPETIDO
                for (int z = 0; z < contadorA; z++) {
                    // only changes num, not the array element

                    if (alumnos[z].getCarnet() == Integer.parseInt(parametros[1].trim())) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    //Log.addToEndFile("Logs.txt", " " + new Date().toString() + " El alumno con el id: " + Integer.parseInt(parametros[0].trim()) +" Ya fue agregado"+ "\n");
                    System.out.println("El alumno con ese Carnet ya fue agregado");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                //Nombre
                if(((parametros[2].trim()).isEmpty()) ){
                    System.out.println("Lo sentimos, falta el nombre");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                //Fecha
                if(((parametros[3].trim()).isEmpty()) ){
                    System.out.println("Lo sentimos, falta la fecha");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                //CHAR----------------------------
                if((parametros[4].trim()).isEmpty()||!parametros[4].trim().equals("M")&&!parametros[4].trim().equals("F")  ){
                    System.out.println("Lo sentimos, falta un char");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }

                alumnos[contadorA] = new Alumnos(Integer.parseInt(parametros[0].trim()), Integer.parseInt(parametros[1].trim()),
                        parametros[2].trim(), parametros[3].trim(), (parametros[4].trim()));

                contadorA++;
                linea = br.readLine();      //Leemos una nueva línea del buffer;
            }
            JOptionPane.showMessageDialog(null, "La carga de alumnos se realizo y fue exitosa");
        } catch (Exception e) {
            //En caso de error mostraremos este mensaje
            JOptionPane.showMessageDialog(null, "Ocurrió un error al momento de leer el archivo Alumnos.csv");
            System.out.println("Ocurrió un error al momento de leer el archivo Alumnos.csv");

        } finally {
            // Si el buffer es diferente de nulo quiere decir que conseguimos abrir el archivo
            if (br != null) {
                //Por ende una vez dejemos de utilizarlo, debemos cerrarlo.
                br.close();
            }
        }

        mostrarAlumnos();
    }

    public static void mostrarAlumnos() {
        try{
        System.out.println("ID\t\tCARNET\t\t\tNOMBRE\t\tFecha de Nacimiento\t\t\tGenero\t\t\t");
        for (int i = 0; i < contadorA; i++) {
            System.out.println(alumnos[i].getId() + "\t\t" + alumnos[i].getCarnet()
                    + "\t\t" + alumnos[i].getNombre() + "\t\t" + alumnos[i].getFechaNacimiento()
                    + "\t\t" + alumnos[i].getGenero() + "\t\t"
                    + "\t\t");
            }
        }catch (Exception e){
            System.out.println("Ocurrió un error al momento de leer el archivo Alumnos.csv");
        }
    }

    public static void leerCursos(String arc1) throws IOException {
        //Declaramos el buffer donde se almacenará el contenido del archivo
        BufferedReader br = null;
        //Ruta del archivo
       // String lectura;
        String nombre = "\\cursos.csv";
        String rutaArchivo;
        rutaArchivo  = arc1 + nombre;
        //lectura = consola.nextLine(); //C:\Users\kevin\IdeaProjects\IPC1_PRACTICA3_G7\Cursos.csv
       // rutaArchivo = lectura;
        cursos= new Cursos[300];

        try {

            //Inicializamos el buffer colocando la ruta del archivo
            br = new BufferedReader(new FileReader(rutaArchivo));
            //Leemos el archivo línea por línea
            String linea = br.readLine();
            linea = br.readLine();


            //Mientras queden líneas en el buffer seguiremos leyendolas.
            while (linea != null) {
                String[] parametros = linea.split(",");
                boolean flag = false;

                //VERIFICACIONES

                //ID----------------------------
                if(((parametros[0].trim()).isEmpty()) ){
                    //System.out.println("Lo sentimos, falta el id");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }else{
                    try{
                        Integer.parseInt(parametros[0].trim());
                        flag=false;
                    }catch (Exception e){
                        flag=true;
                    }
                }
                if (flag) {
                    //System.out.println("Campo de ID mal ingresado");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                //ID REPETIDO
                for (int z = 0; z < contadorC; z++) {
                    // only changes num, not the array element

                    if (cursos[z].getId() == Integer.parseInt(parametros[0].trim())) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    //Log.addToEndFile("Logs.txt", " " + new Date().toString() + " El alumno con el id: " + Integer.parseInt(parametros[0].trim()) +" Ya fue agregado"+ "\n");
                    //System.out.println("El curso con ese ID ya fue agregado");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }

                //CODIGO------------------------------
                if(((parametros[1].trim()).isEmpty()) ){
                    //System.out.println("Lo sentimos, falta el codigo");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }else{
                    try{
                        Integer.parseInt(parametros[1].trim());
                        flag=false;
                    }catch (Exception e){
                        flag=true;
                    }
                }
                if (flag) {
                    //System.out.println("Campo de codigo mal ingresado");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                //CODIGO REPETIDO
                for (int z = 0; z < contadorC; z++) {
                    // only changes num, not the array element

                    if (cursos[z].getCodigo() == Integer.parseInt(parametros[1].trim())) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    //Log.addToEndFile("Logs.txt", " " + new Date().toString() + " El alumno con el id: " + Integer.parseInt(parametros[0].trim()) +" Ya fue agregado"+ "\n");
                    //System.out.println("El curso con ese codigo ya fue agregado");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                //Nombre
                if(((parametros[2].trim()).isEmpty()) ){
                    //System.out.println("Lo sentimos, falta el nombre");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }

                cursos[contadorC] = new Cursos(Integer.parseInt(parametros[0].trim()), Integer.parseInt(parametros[1].trim()),
                        parametros[2].trim());

                contadorC++;
                linea = br.readLine();      //Leemos una nueva línea del buffer;
            }
            JOptionPane.showMessageDialog(null, "La carga de cursos se realizo y fue exitosa");
        } catch (Exception e) {
            //En caso de error mostraremos este mensaje
            JOptionPane.showMessageDialog(null, "Ocurrió un error al momento de leer el archivo Cursos.csv");
            System.out.println("Ocurrió un error al momento de leer el archivo Cursos.csv");

        } finally {
            // Si el buffer es diferente de nulo quiere decir que conseguimos abrir el archivo
            if (br != null) {
                //Por ende una vez dejemos de utilizarlo, debemos cerrarlo.
                br.close();
            }
        }
        mostrarCursos();
    }

    public static void mostrarCursos() {
        try {
            System.out.println("ID\t\tCODIGO\t\t\tNOMBRE\t\t");
            for (int i = 0; i < contadorC; i++) {
                System.out.println(cursos[i].getId() + "\t\t" + cursos[i].getCodigo()
                        + "\t\t" + cursos[i].getNombre());

            }
        }catch (Exception e){
            System.out.println("Ocurrió un error al momento de leer el archivo Cursos.csv");
        }
    }

    public static void leerAsignaciones(String acr1) throws IOException  {
        //Declaramos el buffer donde se almacenará el contenido del archivo
        BufferedReader br = null;
        //Ruta del archivo
      //  String lectura;
        String nombre = "\\asignaciones.csv";
        String rutaArchivo;
        rutaArchivo = acr1 + nombre;
        //lectura = consola.nextLine();
        //rutaArchivo = lectura; //C:\Users\kevin\IdeaProjects\IPC1_PRACTICA3_G7\Asignaciones.csv
        asignaciones= new Asignaciones[300];

        try {

            //Inicializamos el buffer colocando la ruta del archivo
            br = new BufferedReader(new FileReader(rutaArchivo));
            //Leemos el archivo línea por línea
            String linea = br.readLine();
            linea = br.readLine();

            //Mientras queden líneas en el buffer seguiremos leyendolas.
            while (linea != null) {
                String[] parametros = linea.split(",");
                boolean flag = false;


                //ID----------------------------
                if(((parametros[0].trim()).isEmpty()) ){
                    //System.out.println("Lo sentimos, falta el id del alumno");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }else{
                    try{
                        Integer.parseInt(parametros[0].trim());
                        flag=false;
                    }catch (Exception e){
                        flag=true;
                    }
                }
                if (flag) {
                    //System.out.println("Campo de ID Alumno mal ingresado");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                //ID CURSO------------------------------
                if(((parametros[1].trim()).isEmpty()) ){
                    //System.out.println("Lo sentimos, falta el ID del curso");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }else{
                    try{
                        Integer.parseInt(parametros[1].trim());
                        flag=false;
                    }catch (Exception e){
                        flag=true;
                    }
                }
                if (flag) {
                    //System.out.println("Campo de Id del curso mal ingresado");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                //NOTAS-----------------------------------------
                if(((parametros[2].trim()).isEmpty()) ){
                    //System.out.println("Lo sentimos, falta la nota del curso");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }else{
                    try{
                        Double.parseDouble(parametros[1].trim());
                        flag=false;
                    }catch (Exception e){
                        flag=true;
                    }
                }
                if (flag) {
                    //System.out.println("Campo de notas de asignaciones mal ingresado");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                if (Double.parseDouble(parametros[2].trim())<0 || Double.parseDouble(parametros[2].trim())>100){
                    //System.out.println("Campo de notas de asignaciones fuera de rango");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }

                //ASIGNACION REPETIDA---------------------------------------------------
                for (int z = 0; z < contadorAsignaciones; z++) {
                    // only changes num, not the array element

                    if (asignaciones[z].getIdAlumno() == Integer.parseInt(parametros[0].trim()) && asignaciones[z].getIdCurso() == Integer.parseInt(parametros[1].trim())) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    //System.out.println("El alumno ya fue agregado a ese curso.");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }


                for (int z = 0; z < contadorA; z++) {
                    // only changes num, not the array element
                    if (alumnos[z].getId() == Integer.parseInt(parametros[0].trim())) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    //System.out.println("No existe el alumno con ese ID");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                flag = false;
                for (int z = 0; z < contadorC; z++) {
                    // only changes num, not the array element
                    if (cursos[z].getId() == Integer.parseInt(parametros[1].trim())) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    //System.out.println("No existe el curso con ese ID");
                    linea = br.readLine();      //Leemos una nueva línea del buffer;
                    continue;
                }
                asignaciones[contadorAsignaciones] = new Asignaciones(Integer.parseInt(parametros[0].trim()), Integer.parseInt(parametros[1].trim()), Double.parseDouble(parametros[2].trim()));
                contadorAsignaciones++;

                linea = br.readLine();      //Leemos una nueva línea del buffer;
            }
            JOptionPane.showMessageDialog(null, "La asignacion se realizo y fue exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al momento de leer el archivo Asignaciones.csv");
            System.out.println("Ocurrió un error al momento de leer el archivo Cursos.csv");

        } finally {
            // Si el buffer es diferente de nulo quiere decir que conseguimos abrir el archivo
            if (br != null) {
                //Por ende una vez dejemos de utilizarlo, debemos cerrarlo.
                br.close();
            }
        }
        mostrarAsignaciones();
    }

    public static void mostrarAsignaciones() {
        try {
            System.out.println("ID_Alumno\t\tID_CURSO\t\t\tNOTA\t\t");
            for (int i = 0; i < contadorAsignaciones; i++) {
                System.out.println(asignaciones[i].getIdAlumno() + "\t\t" + asignaciones[i].getIdCurso()
                        + "\t\t" + asignaciones[i].getNota());
            }
        }catch (Exception e){
            System.out.println("Algo salio mal intente de nuevo");
        }
    }
}
