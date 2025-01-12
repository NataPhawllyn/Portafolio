package proyecto2_neiracruz;

import java.util.Scanner;

public class Proyecto2_NeiraCruz {

    private static Scanner sc = new Scanner(System.in);
    private static int op,a;
    // static Libros[] objLibro=new Libros[a];
    private static Lista libList = new Lista();
    
    

    public static void main(String[] args) {
        

        do {
            menu();
        } while (op != 6);

    }

    public static void menu() {
        System.out.println("Menú del usuario.\n\n"
                + "1. Agregar libro.\n"
                + "2. Agregar unidades a un libro.\n"
                + "3. Reritar libro.\n"
                + "4. Cambiar libro de posición\n"
                + "5. Vender libro.\n"
                + "6. Salir\n"
                + "Seleccione una opción:\n");

        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                if(a%2==0)libList.asignarTamaño('A',a);
                else libList.asignarTamaño('L',a);
                
                Libros objAux = new Libros();
                System.out.println("Ingresó a la opción 1: Agregar libro");
                System.out.println("Ingrese los datos separados por & (isbn, título, precio): ");
               objAux.agregarLibro(sc.nextLine());
                libList.agregarEspacio(objAux, a);
                libList.imprimirLista();
                libList.copiarLista();
                agregarEspacioArray(op);
                
               break;

            case 2:
                
                break;

            case 3:
                break;

            case 4:
                break;
                
            case 5:
                break;
                
            case 6:
                break;
                
            default:
                 System.out.println("Opción no  es valida");
                break;
        }
    }// Aca termian el metodo menu
    
    public static int agregarEspacioArray(int op){
        if(op==1){
            return a++; 
            
        }
        return a;
    }

}
