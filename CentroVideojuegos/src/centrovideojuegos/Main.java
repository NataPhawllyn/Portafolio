/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centrovideojuegos;

import java.util.Scanner;

/**
 *
 * Nataly Neira
 * Cristian Patarroyo
 */
public class Main {

    /// Variables Globales 
    public static Scanner sc = new Scanner(System.in);
    // creacion de los objetos constructor vacio
    public static Estaciones estUno = new Estaciones();
    public static Estaciones estDos = new Estaciones();
    public static Estaciones estTres = new Estaciones();
    public static Estaciones estCuatro = new Estaciones();
    public static Estaciones estCinco = new Estaciones();

   // definición de arreglos  por  tipos de variable de los objetos 
    public static int tiempo[] = new int[5];
    public static long id[] = new long[5];
    public static String nombre[] = new String[5];
    public static String estado[] = new String[5];
    public static String fecha[] = new String[5];
    public static String imprimir[] = new String[5];
    public static int uso[] = new int[5];
    //__________________________________________________________________________
   
    // Codigo  central 
    public static void main(String[] args) {
          
        long gananciaT=0;
        // variables de control o temporales    
        int opc; // opcion menu
        int est; //estacion
        long idJ; // identificación
        int valiId = 0,reg=0,rAsig=0; //  control de uso 
        int mayorUso=0,usoEst=0;
//_______________________________________________________________________________
        

//MENU
        System.out.println("---Centro de Videojuegos---");

        do {
            System.out.println("0. Salir");
            System.out.println("1. Asignar jugador a estación");
            System.out.println("2. Agregar tiempo a jugador");
            System.out.println("3. Cambiar jugador de estación");
            System.out.println("4. Registrar salida de jugador");
            System.out.println("5. Mostrar ingresos totales.");
            System.out.println("6.Estación más utilizada.\n\nIngrese la opción");

            opc = sc.nextInt();

            switch (opc) {
                case 0:
                    System.out.println("Gracias");
                    break;
//_________________________________________________________________________________________________
               
                case 1://Completo y corriendo bien 
                    
                    System.out.println("Ingrese el número de la estación:");
                    est = sc.nextInt();

                    if (est > 0 && est < 6) // evalua  si  esta  dentro de las opciones
                    { 
                        if (null==estado[(est - 1)]) //  evaluar  si la estacion esta  vacia 
                         { reg = 1;
                            if (est == 1) {
                                registrar1();
                            } else if (est == 2) {
                                registrar2();
                            } else if (est == 3) {
                                registrar3();
                            } else if (est == 4) {
                                registrar4();
                            } else if (est == 5) {
                                registrar5();
                                
                            }
                            System.out.println("el jugador " + imprimir[est-1] + "\n ha sido agregado a la estación  " + est +".");// imprime los datos del  registro}
                        }else {
                            System.out.println("El nuevo jugador no se puede agregar a la estación " + est + "\n porque está ocupada por el jugador:");
                            System.out.println(imprimir[est - 1]);
                        }
                    }else System.out.println("Número de estación incorrecto. Debe ingresar un número de 1 a 5. ");
                    

                        break;

                    
  //________________________________________________________________________________________________________________________________________________________          
            case 2://Completo y corriendo bien 
                   
                   if (reg!=0) // evaluar  si hay  usuarios  registrados  
                    {
                        System.out.println("Ingrese identificación del jugador:");
                        idJ = sc.nextLong();
                        valiId=0;
                        for (int i = 0; i < 5; i++) // busca en que estación está el jugador 
                        {
                            if (id[i] == idJ) {
                                System.out.println("Ingrese minutos:");
                              valiId=1;
                                switch (i + 1) {
                                    case 1:
                                        estUno.setTiempo(sc.nextInt());
                                        tiempo[i]=estUno.getTiempo();
                                        imprimir[i]=estUno.toString();
                                        break;
                                    case 2:
                                        estDos.setTiempo(sc.nextInt());
                                        tiempo[i]=estDos.getTiempo();
                                        imprimir[i]=estDos.toString();
                                        break;
                                    case 3:
                                        estTres.setTiempo(sc.nextInt());
                                        tiempo[i]=estTres.getTiempo();
                                        imprimir[i]=estTres.toString();
                                        break;
                                    case 4:
                                        estCuatro.setTiempo(sc.nextInt());
                                        tiempo[i]=estCuatro.getTiempo();
                                        imprimir[i]=estCuatro.toString();
                                        break;
                                    case 5:
                                        estCinco.setTiempo(sc.nextInt());
                                        tiempo[i]=estCinco.getTiempo();
                                        imprimir[i]=estCinco.toString();
                                        break;
                                }
                                System.out.println("El nuevo estado del jugador es " + imprimir[i]);
                                break;
                            }else continue;
                            
                        }if (valiId == 0) System.out.println("El jugador consultado NO existe. ");
                        
                   }else{System.out.println("No se puede utilizar esta opción hasta que no haya al menos un jugador en el centro.");}
            
            break;
//________________________________________________________________________________________________________________________________________________
          
            case 3://completo y corriendo bien 
                    
              if (reg!=0) // evaluar  si hay  usuarios  registrados  
                {  

                    System.out.println("Ingrese identificación del jugador:");
                    idJ = sc.nextLong();
                    valiId=0;
                    for (int i = 0; i < 5; i++) // busca en que estación está el jugador 
                        { if (id[i] == idJ) 
                        {
                           valiId=1;
                           System.out.println("Ingrese Estación:");
                           est=sc.nextInt();
                           
                           if (est>0 && est< 6 && estado[est-1]!=null) //  si la estación esta  ocupada 
                           {System.out.println("El jugador: "+imprimir[i] +"\n  no se puede mover al espacio "+est
                                            +"\n porque está ocupado por el jugador: "+imprimir[est-1] );
                           break;
                           }
                           rAsig=0;
                           switch (est) {// re asignar estación
                                case 1:
                                      estUno.reAsignarEstaciones(id[i], nombre[i], tiempo[i], fecha[i]);
                                      actualizar1(0);
                                      rAsig=1;
                                    break;
                                case 2:
                                    estDos.reAsignarEstaciones(id[i], nombre[i], tiempo[i], fecha[i]);
                                    actualizar2(1);
                                    rAsig=1;
                                  break;
                                case 3:
                                    estTres.reAsignarEstaciones(id[i], nombre[i], tiempo[i], fecha[i]);
                                    actualizar3(2);
                                    rAsig=1;
                                  break;
                                case 4:
                                    estCuatro.reAsignarEstaciones(id[i], nombre[i], tiempo[i], fecha[i]);
                                    actualizar4(3);
                                    rAsig=1;
                                  break;
                                case 5:
                                    estCinco.reAsignarEstaciones(id[i], nombre[i], tiempo[i], fecha[i]);
                                    actualizar5(4);
                                    rAsig=1;
                                  break;
                                 default:System.out.println("Número de estación incorrecto. Debe ingresar un número de 1 a 5. ");
                            }
                           
                          
                           // vaciar  estación anterior 
                           if(rAsig==1)
                           {
                               System.out.println("El jugador: "+imprimir[est-1]+"ha sido cambiado a la estación "+ est );
                           switch (i+1) {
                             case 1:
                                   vaciar1(i);
                             break;
                             case 2:
                                   vaciar2(i);
                             break;
                             case 3:
                                   vaciar3(i);
                             break;
                             case 4:
                                   vaciar4(i);
                             break;
                             case 5:
                                   vaciar5(i);
                             break;
                            }}
                        
                        break;}
                        }
                 if (valiId == 0) System.out.println("El jugador consultado NO existe. ");
                 }else{System.out.println("No se puede utilizar esta opción hasta que no haya al menos un jugador en el centro.");}
             
              break;
             
 //______________________________________________________________________________________________________            
                case 4:
                    if (reg!=0) // evaluar  si hay  usuarios  registrados
                    {
                    System.out.println("Ingrese identificación del jugador:");
                    idJ = sc.nextLong();
                    valiId=0;
                    for (int i = 0; i < 5; i++) // busca en que estación está el jugador 
                    {       if (id[i] == idJ) {
                        {    valiId=1;
                                switch (i+1) {
                             case 1:
                                   estUno.liquidarCuenta();
                                   vaciar1(i);
                             break;
                             case 2:
                                    estDos.liquidarCuenta();
                                    vaciar2(i);
                             break;
                             case 3:
                                   estTres.liquidarCuenta();
                                   vaciar3(i);
                             break;
                             case 4:
                                   estCuatro.liquidarCuenta();
                                   vaciar4(i);
                             break;
                             case 5:
                                   estCinco.liquidarCuenta();
                                   vaciar5(i);
                             break;
                            }
                                
                                }
                            break;
                            }else continue;
                            
                        }if (valiId == 0) System.out.println("El jugador consultado NO existe. ");
                    }else System.out.println("No se puede utilizar esta opción hasta que no haya al menos un jugador en el centro.");
                    break;    
                    
                    
   //______________________________________________________________________________________________________
                case 5: 
                    gananciaT=estUno.getGanancia()+estDos.getGanancia()+estTres.getGanancia()+estCuatro.getGanancia()+estCinco.getGanancia();
                    System.out.println("Los ingresos totales son $"+gananciaT);
                    break;    
   //______________________________________________________________________________________________________                 
                case 6: 
                   if (reg!=0) // evaluar  si hay  usuarios  registrados
                    { 
                    for (int i = 0; i < 5; i++) {
                        System.out.println("estacion "+(i+1)+" "+uso[i]);
                        if (mayorUso<uso[i]) {
                            mayorUso=uso[i];
                            usoEst=i;
                        }
                     }
                    System.out.println("La estación más utilizada es la estación  "+ (usoEst+1)+
                              "\n  ,la cual ha recibido " +uso[usoEst]+ " jugadores hasta el momento \n.");
                   
                    for (int i = 0; i < 5; i++) {
                        if (mayorUso==uso[i] && i!=usoEst) {
                            
                            System.out.println("Junto con la estación   "+ (i+1)+
                              "\n  ,la cual  también ha recibido " +uso[usoEst]+ " jugadores hasta el momento.");
                        }
                    }
                    
                      }else System.out.println("No se puede utilizar esta opción hasta que no haya al menos un jugador en el centro.");
                       break;
   //______________________________________________________________________________________________________                 
                default:
                    System.out.println("Por favor selecciones una respuesta correcta");
                         
            }
   //_________________-FIN DEL MENÚ-_______________________________________________________________   
    
        } while (opc!= 0);
        
//____________________________________________________________________________________________________________
            //impresiones de control de  los  atributos de los objetos 
            System.out.println(
                    "Estación 1" + estUno.toString());
            System.out.println(
                    "Estación 2" + estDos.toString());
            System.out.println(
                    "Estación 3" + estTres.toString());
            System.out.println(
                    "Estación 4" + estCuatro.toString());
            System.out.println(
                    "Estación 4" + estCinco.toString());

      
        } 
//__________________________________________________________________________________________________________
///_______________ Fin del codigo central _________________________________________________________________________________________________________

///  metodos del Main 


    public static void registrar1() {

        System.out.println("Ingrese identificación del Jugador:");
        estUno.setIdJugador(sc.nextLong());
        id[0]=estUno.getIdJugador();
        System.out.println("Ingrese nombre del jugador:");
        estUno.setNombreJ(sc.next());
        nombre[0]=estUno.getNombreJ();
        System.out.println("Ingrese fecha:");
        estUno.setFecha(sc.next());
        fecha[0]=estUno.getFecha();
        estUno.setEstado("Ocupado");
        estado[0]=estUno.getEstado();
        imprimir[0]=estUno.toString();
        estUno.registroUso();
        uso[0]=estUno.getUso();
       
    }

    public static void registrar2() {

        System.out.println("Ingrese identificación del Jugador:");
        estDos.setIdJugador(sc.nextLong());
        id[1]=estDos.getIdJugador();
        System.out.println("Ingrese nombre del jugador:");
        estDos.setNombreJ(sc.next());
        nombre[1]=estDos.getNombreJ();
        System.out.println("Ingrese fecha:");
        estDos.setFecha(sc.next());
        fecha[1]=estDos.getFecha();
        estDos.setEstado("Ocupado");
        estado[1]=estDos.getEstado();
        imprimir[1]=estDos.toString();
        estDos.registroUso();
        uso[1]=estDos.getUso();
    }

    public static void registrar3() {

        System.out.println("Ingrese identificación del Jugador:");
        estTres.setIdJugador(sc.nextLong());
        id[2]=estTres.getIdJugador();
        System.out.println("Ingrese nombre del jugador:");
        estTres.setNombreJ(sc.next());
        nombre[2]=estTres.getNombreJ();
        System.out.println("Ingrese fecha:");
        estTres.setFecha(sc.next());
        fecha[2]=estTres.getFecha();
        estTres.setEstado("Ocupado");
        estado[2]=estTres.getEstado();
        imprimir[2]=estTres.toString();
        estTres.registroUso();
        uso[2]=estTres.getUso();
    }

    public static void registrar4() {

        System.out.println("Ingrese identificación del Jugador:");
        estCuatro.setIdJugador(sc.nextLong());
        id[3]=estCuatro.getIdJugador();
        System.out.println("Ingrese nombre del jugador:");
        estCuatro.setNombreJ(sc.next());
        nombre[3]=estCuatro.getNombreJ();
        System.out.println("Ingrese fecha:");
        estCuatro.setFecha(sc.next());
        fecha[3]=estCuatro.getFecha();
        estCuatro.setEstado("Ocupado");
        estado[3]=estCuatro.getEstado();
        imprimir[3]=estCuatro.toString();
        estCuatro.registroUso();
        uso[3]=estCuatro.getUso();
    }
    public static void registrar5() {

        System.out.println("Ingrese identificación del Jugador:");
        estCinco.setIdJugador(sc.nextLong());
        id[4]=estCinco.getIdJugador();
        System.out.println("Ingrese nombre del jugador:");
        estCinco.setNombreJ(sc.next());
        nombre[4]=estCinco.getNombreJ();
        System.out.println("Ingrese fecha:");
        estCinco.setFecha(sc.next());
        fecha[4]=estCinco.getFecha();
        estCinco.setEstado("Ocupado");
        estado[4]=estCinco.getEstado();
        imprimir[4]=estCinco.toString();
        estCinco.registroUso();
        uso[4]=estCinco.getUso();
    }
    
    public static void vaciar1(int i){
                
            estUno.vaciarEstacion();
            estado[i]=estUno.getEstado();
            id[i] =estUno.getIdJugador();
           nombre[i] = estUno.getNombreJ();
            tiempo[i]=estUno.getTiempo();
            fecha[i]=estUno.getFecha();
            imprimir[i]=estUno.toString();
    }
    
    public static void vaciar2(int i){
        estDos.vaciarEstacion();
        estado[i]=estDos.getEstado();
        id[i] =estDos.getIdJugador();
        nombre[i] = estDos.getNombreJ();
        tiempo[i]=estDos.getTiempo();
        fecha[i]=estDos.getFecha();
        imprimir[i]=estDos.toString();
        
    }
    
     public static void vaciar3(int i){
         estTres.vaciarEstacion();
        estado[i]=estTres.getEstado();
        id[i] =estTres.getIdJugador();
        nombre[i] = estTres.getNombreJ();
        tiempo[i]=estTres.getTiempo();
        fecha[i]=estTres.getFecha();
        imprimir[i]=estTres.toString();
     }

     public static void vaciar4(int i ){
         estCuatro.vaciarEstacion();
         estado[i]=estCuatro.getEstado();
         id[i] =estCuatro.getIdJugador();
         nombre[i] = estCuatro.getNombreJ();
         tiempo[i]=estCuatro.getTiempo();
         fecha[i]=estCuatro.getFecha();
         imprimir[i]=estCuatro.toString();
     }
     public static void vaciar5(int i ){
         estCinco.vaciarEstacion();
         estado[i]=estCinco.getEstado();
         id[i] =estCinco.getIdJugador();
         nombre[i] = estCinco.getNombreJ();
         tiempo[i]=estCinco.getTiempo();
         fecha[i]=estCinco.getFecha();
         imprimir[i]=estCinco.toString();
     }
    public static void actualizar1(int i){
            
            estado[i]=estUno.getEstado();
            id[i] =estUno.getIdJugador();
           nombre[i] = estUno.getNombreJ();
            tiempo[i]=estUno.getTiempo();
            fecha[i]=estUno.getFecha();
            imprimir[i]=estUno.toString();
            estUno.registroUso();
            uso[i]=estUno.getUso();
    }
    
    public static void actualizar2(int i){
        
        estado[i]=estDos.getEstado();
        id[i] =estDos.getIdJugador();
        nombre[i] = estDos.getNombreJ();
        tiempo[i]=estDos.getTiempo();
        fecha[i]=estDos.getFecha();
        imprimir[i]=estDos.toString();
        estDos.registroUso();
        uso[i]=estDos.getUso();
        
    }
    
     public static void actualizar3(int i){
        
        estado[i]=estTres.getEstado();
        id[i] =estTres.getIdJugador();
        nombre[i] = estTres.getNombreJ();
        tiempo[i]=estTres.getTiempo();
        fecha[i]=estTres.getFecha();
        imprimir[i]=estTres.toString();
        estTres.registroUso();
        uso[i]=estTres.getUso();
     }

     public static void actualizar4(int i ){
        
         estado[i]=estCuatro.getEstado();
         id[i] =estCuatro.getIdJugador();
         nombre[i] = estCuatro.getNombreJ();
         tiempo[i]=estCuatro.getTiempo();
         fecha[i]=estCuatro.getFecha();
         imprimir[i]=estCuatro.toString();
         estCuatro.registroUso();
         uso[i]=estCuatro.getUso();
     }
     public static void actualizar5(int i ){
         
         estado[i]=estCinco.getEstado();
         id[i] =estCinco.getIdJugador();
         nombre[i] = estCinco.getNombreJ();
         tiempo[i]=estCinco.getTiempo();
         fecha[i]=estCinco.getFecha();
         imprimir[i]=estCinco.toString();
         estCinco.registroUso();
         uso[i]=estCinco.getUso();
     }
     
}
