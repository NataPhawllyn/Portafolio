/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centrovideojuegos;

import java.util.Scanner;

/**
 *
 * @author conta
 */
public class Main {

    /// Variables Globales 
    public static Scanner sc = new Scanner(System.in);
    // creacion de los objetos constructor vacio
    public static Estaciones estUno = new Estaciones();
    public static Estaciones estDos = new Estaciones();
    public static Estaciones estTres = new Estaciones();
    public static Estaciones estCuatro = new Estaciones();

    //__________________________________________________________________________
    // Codigo  central 
    public static void main(String[] args) {

        // CREACIÓN DE VARIABLES
        // variables de control o temporales    
        int opc; // opcion menu
        int a; //estacion
        long idJ; // nombre
        int temp = 0; //  control  de  registro tiempo 

        // definición de arreglos  por  tipos de variable de los objetos 
        String[] nombre = {estUno.getNombreJ(), estDos.getNombreJ(), estTres.getNombreJ(), estCuatro.getNombreJ()};
        String[] estado = {estUno.getEstado(), estDos.getEstado(), estTres.getEstado(), estCuatro.getEstado()};
        long[] id = {estUno.getIdJugador(), estDos.getIdJugador(), estTres.getIdJugador(), estCuatro.getIdJugador()};
        String[] fecha = {estUno.getFecha(), estDos.getFecha(), estTres.getFecha(), estCuatro.getFecha()};
        int[] tiempo = {estUno.getTiempo(), estDos.getTiempo(), estTres.getTiempo(), estCuatro.getTiempo()};
        String[] toString = {estUno.toString(), estDos.toString(), estTres.toString(), estCuatro.toString()};
        //____ _____________________________________________________________________

        //MENU
        System.out.println("---Centro de Videojuegos---");

        do {
            System.out.println("0. Salir");
            System.out.println("1. Asignar jugador a estación");
            System.out.println("2. Agregar tiempo a jugador");
            System.out.println("3. Cambiar jugador de estación");
            System.out.println("4. Registrar salida de jugador");
            System.out.println("5. Mostrar ingresos totales\n\nIngrese la opción");

            opc = sc.nextInt();

            switch (opc) {
                case 0:
                    System.out.println("Gracias");
                    break;

                case 1:
                    System.out.println("Ingrese el número de la estación:");
                    a = sc.nextInt();

                    if (a > 0 && a < 5) // evalua  si  esta  dentro de las opciones
                    {
                        if ("ocupado".equals(estado[(a - 1)])) //  evaluar  si la estacion esta  vacia 
                        {
                            if (a == 1){
                                registrar1();
                            } else if (a == 2) {
                                registrar2();
                            } else if (a == 3) {
                                registrar3();
                            } else if (a == 4) {
                                registrar4();
                            }
                            System.out.println("Estación " + a + " " + toString[(a-1)]);// imprime los datos del  registro
                        }else{System.out.println("El nuevo jugador no se puede agregar a la estación "+a+ "porque está ocupada por el jugador");
                               System.out.println(toString[a-1]);}
                    }else {
                        System.out.println("Número de estación incorrecto. Debe ingresar un número de 1 a 4. ");
                    }

                    break;

                case 2:
                     
                        
                    
                    //if (id[] != null) // evaluar  si hay  usuarios  registrados  
                    //{
                        System.out.println("Ingrese identificación del jugador:");
                        idJ = sc.nextLong();
                        temp = 0; //reinicio la variable de control 
                        for (int i = 0; i < 4; i++) // busca en que estación está el jugador 
                        {
                            if (id[i] == idJ) {
                                System.out.println("Ingrese minutos:");
                                temp = 1;
                                switch (i + 1) {
                                    case 1:
                                        estUno.setTiempo(sc.nextInt());
                                        break;
                                    case 2:
                                        estDos.setTiempo(sc.nextInt());
                                        break;
                                    case 3:
                                        estTres.setTiempo(sc.nextInt());
                                        break;
                                    case 4:
                                        estCuatro.setTiempo(sc.nextInt());
                                        break;
                                }
                                System.out.println("El nuevo estado del jugador es " + toString[i]);
                            }else continue;
                        }
                    
                    if (temp != 1) {
                        System.out.println("El jugador consultado NO existe. ");
                        }
            
            break;

          case 3:

                    System.out.println("Ingrese identificación del jugador:");
                    
                    System.out.println("Ingrese Estación:");
                   // estUno.setIdEstacion(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Ingrese identificación del jugador:");
                    estUno.setIdJugador(sc.nextLong());
                    break;    
                default:
                    System.out.println("Por favor selecciones una respuesta correcta");
            }
        
    }
    while (opc

    != 0);
        
        
        // para imprimir los  atributos de los objetos 
    System.out.println (

    "Estación 1"+estUno.toString());
    System.out.println (

    "Estación 2"+estDos.toString());
    System.out.println (

    "Estación 3"+estTres.toString());
    System.out.println (

"Estación 4"+estCuatro.toString());
        
     /*   Esto se puede hacer mas rapido con el toString
        
    System.out.println("El id de la estación 1 es: "+estUno.idEstacion);
    System.out.println("El id del jugador 1 es: "+estUno.idJugador);
    System.out.println("El nombre del jugador 1 es: "+estUno.nombreJ);
    System.out.println("La fecha 1 es: "+estUno.fecha);
    System.out.println("El id de la estación  es: "+estDos.idEstacion);
    System.out.println("El id del jugador es: "+estDos.idJugador);
    System.out.println("El nombre del jugador es: "+estDos.nombreJ);
    System.out.println("La fecha es: "+estDos.fecha);
    */    
    }
    
////  metodos  para  registrar 
    
 public static void registrar1(){
                    
                    
                    System.out.println("Ingrese identificación del Jugador:");
                    estUno.setIdJugador(sc.nextLong());
                    System.out.println("Ingrese nombre del jugador:");
                    estUno.setNombreJ(sc.next());
                    System.out.println("Ingrese fecha:");
                    estUno.setFecha(sc.next());
                    estUno.setEstado("Ocupado");

 }
 
  public static void registrar2(){
                    
                    
                    System.out.println("Ingrese identificación del Jugador:");
                    estDos.setIdJugador(sc.nextLong());
                    System.out.println("Ingrese nombre del jugador:");
                    estDos.setNombreJ(sc.next());
                    System.out.println("Ingrese fecha:");
                    estDos.setFecha(sc.next());
                    estDos.setEstado("Ocupado");
}
  public static void registrar3(){
                    
                    
                    System.out.println("Ingrese identificación del Jugador:");
                    estTres.setIdJugador(sc.nextLong());
                    System.out.println("Ingrese nombre del jugador:");
                    estTres.setNombreJ(sc.next());
                    System.out.println("Ingrese fecha:");
                    estTres.setFecha(sc.next());
                    estTres.setEstado("Ocupado");
}
  public static void registrar4(){
                    
                    
                    System.out.println("Ingrese identificación del Jugador:");
                    estCuatro.setIdJugador(sc.nextLong());
                    System.out.println("Ingrese nombre del jugador:");
                    estCuatro.setNombreJ(sc.next());
                    System.out.println("Ingrese fecha:");
                    estCuatro.setFecha(sc.next());
                    estCuatro.setEstado("Ocupado");
}
 
}
