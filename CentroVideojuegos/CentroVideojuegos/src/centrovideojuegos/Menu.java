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
public class Menu {
     public static void mostrarMenu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---Centro de Videojuegos---");
   
        int op = 0;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Asignar jugador a estación");
            System.out.println("2. Agregar tiempo a jugador");
            System.out.println("3. Cambiar jugador de estación");
            System.out.println("4. Registrar salida de jugador");
            System.out.println("5. Mostrar ingresos totales\n\nIngrese la opción");

            op=sc.nextInt();

            switch (op){
                case 1:
                    System.out.println("Ingrese el número de la estación:");
                    System.out.println("Ingrese identificación del Jugador:");
                    System.out.println("Ingrese nombre del jugador:");
                    System.out.println("Ingrese fecha:");
                    break;
                case 2:
                    System.out.println("Ingrese identificación del jugador:");
                    System.out.println("Ingrese minutos:");
                    break;
                case 3:
                    System.out.println("Ingrese identificación del jugador:");
                    System.out.println("Ingrese Estación:");
                    break;
                case 4:
                    System.out.println("Ingrese identificación del jugador:");
                    break;    
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Por favor selecciones una respuesta correcta");
            }
        }while (op != 0);
    }
}
