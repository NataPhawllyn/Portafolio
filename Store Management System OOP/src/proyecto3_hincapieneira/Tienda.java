package proyecto3_hincapieneira;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @autores Duran,Hincapie,Neira. 
 */
public class Tienda {


    //Atributos de la clase
    private Scanner sc;
    private String[] productos = {"Pantalones", "Camisetas", "Chaquetas", "Zapatos", "Blusas"};
    private String[] vendedores = {"Juan", "Rosa", "Camilo", "Lina"};
    private String[] diasemana={"Domingo", "Lunes" , "Martes" , "Miercoles", "Jueves", "Viernes", "Sábado"};
    private Venta[][] registroVentas = new Venta[5][7];
    private boolean bandera = false;

    //Constructor de la clase
    public Tienda() {
        sc = new Scanner(System.in);
    }//Cierra constructor

    public static void main(String[] args) {
        Tienda menu = new Tienda(); //objeto para acceder a los métodos de esta misma clase
        menu.desplegarMenu();
    }//cierra main

    public void desplegarMenu() {
        mostrarOpciones();
        System.out.print("Seleccione una opción: ");
        try{
        int opcionSeleccionada = Integer.parseInt(sc.next());
        ejecutarOpcion(opcionSeleccionada);
        }catch(Exception e){
            System.out.println("Opción incorrecta. ");
        }
        desplegarMenu(); //llamada recursiva
    }//cierra desplegarMenu

    private void mostrarOpciones() {
        String cadenaMenu = "\nMenu de usuario.";
        cadenaMenu += "\n1. Registrar factura de venta.";
        cadenaMenu += "\n2. Consultar ventas de un día.";
        cadenaMenu += "\n3. Consultar ventas de un producto.";
        cadenaMenu += "\n4. Eliminar facturas (2 o menos unidades vendidas).";
        cadenaMenu += "\n5. Salir.";

        System.out.println(cadenaMenu);
    }//cierra mostrarOpciones

    private void ejecutarOpcion(int opcionSeleccionada) {
        switch (opcionSeleccionada) {
            case 1:
                //instrucciones para la opción 1
                System.out.println("\nIngresó a la opción 1: Registrar factura de venta");
                registrarFacturaDeVenta();
                break;
            case 2:
                //instrucciones para la opción 2
                System.out.println("\nIngresó a la opción 2: Consultar ventas de un día");
                imprimirDias();
                System.out.println("Seleccione día:");
                consultarVentasDia(Integer.parseInt(sc.next()));
                break;
            case 3:
                //instrucciones para la opción 3
                System.out.println("\nIngresó a la opción 3: Consultar ventas de un producto");
                imprimirProductos();
                System.out.println("Seleccione producto:");
                consultarVentasProducto(Integer.parseInt(sc.next()));
               
                break;
            case 4:
                //instrucciones para la opción 4
                System.out.println("\nIngresó a la opción 4: Eliminar facturas (2 o menos unidades vendidas).");
                eliminarFacturasVentasEscasas();
                break;
            case 5:
                System.out.println("\nGracias por utilizar el Sistema.");
                System.exit(0);
                break;
            default:
                System.out.println("\n Opción incorrecta.");
                

        }
    }//Cierra ejecutarOpcion

    public void imprimirProductos() {
        int j=1;
           for (String i : productos){
               System.out.println(j+". "+i);j++;
           }      
    }//cierra imprimirProductos

    public void imprimirRegistroVentas() {
         System.out.print(" ");
        for ( String d: diasemana)
        {System.out.print("  "+getFirstCharacter(d)+"  ");}
         System.out.println();
         
        for (int i = 0; i < 5; i++) {
            System.out.print(getFirstCharacter(productos[i]));
            for (int j = 0; j < 7; j++) {
                int suma=0;
                if(registroVentas[i][j]==null){
                    System.out.print("  0  ");
                }else{
                for(Factura k: registroVentas[i][j].getFacturas()){
                 suma=suma+k.getCantidad();}
                 System.out.print("  "+suma+"  ");
                }
            }
            System.out.println("");

        }
    }//cierra imprimirRegistroVentas

    public void imprimirVendedores() {
        int j=1;
        for (String i: vendedores) {
            System.out.println(j+"."+i);j++;
        }
    }//cierra imprimirVendedores

    public void imprimirDias() {
        int i=1;
           for (String j : diasemana){
               System.out.println(i+". "+j);i++;
           }}//ci}erra imprimirDias
    

    public int consultarNumeroDeDia(String fechaRecibida) {
        //fechaRecibida debe estar en formato dia/mes/año
        //Objeto de tipo Date
        //Date es la clase que permite manejar fechas
        Date nuevaFecha;
        nuevaFecha = null;
        //El bloque try-catch se agrega para controlar posibles excepciones
        try {
            //La fecha recibida se convierte a tipo Date para poderla guardar en el objeto fecha
            nuevaFecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaRecibida);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        //Se crea un objeto de tipo Calendario
        //para poder acceder a número de día exacto según la fecha dada
        Calendar calendario = Calendar.getInstance();

        //se fija el calendario en la nueva fecha
        calendario.setTime(nuevaFecha);

        //Por medio del objeto calendario, se llama al método get de la clase Calendar
        //el cual retorna un entero con el número del día
        //1:D 2:L 3:M 4:M 5:J 6:V 7:S
        return calendario.get(Calendar.DAY_OF_WEEK)-1;
    }//cierra consultarNumeroDeDia

    //RQ1
    public void registrarFacturaDeVenta() {
        imprimirProductos();        
        System.out.println("\nSeleccione producto: ");
        int a = sc.nextInt();
         if (a > 0 && a < 6){
             
             
        System.out.println("\nIngrese datos separados por & (cantidad&fecha dd/MM/yyyy)");
        String vector = sc.next();  
         String[] datos = vector.split("&");
        try {   
        if (Integer.parseInt(datos[0]) != 0) {
            
        
            int weekDay = consultarNumeroDeDia(datos[1]);
  
        imprimirVendedores();
        System.out.println("\nSeleccione vendedor: ");
        int b = sc.nextInt();
         if (b > 0 && b <5) {
                    
                    if (Integer.parseInt(datos[0]) <= 2) {
                        bandera = true;
                    }
                    if(registroVentas[(a - 1)][weekDay]==null)
                    {Venta v = new Venta();
                    registroVentas[(a - 1)][weekDay] = v;}
                    registroVentas[(a - 1)][weekDay].registrarFactura(a, Integer.parseInt(datos[0]), datos[1], b);
                    imprimirRegistroVentas();
                    
                } else {
                    System.out.println("Vendedor no disponible");
                }
            } else {
                System.out.println("Cantidad incorrecta");
            }
        }catch(Exception e){
                        System.out.println("La fecha es incorrecta");
                        
                    }
        } else
           System.out.println("Producto no disponible"); 
                 
    }//cierra registrarFacturaDeVenta

    //RQ2
    public int consultarVentasDia(int numeroDia) {
        if(numeroDia>=1 && numeroDia<=7){
            int suma=0;
            for(int i=0; i<registroVentas.length; i++){
                if(registroVentas[i][numeroDia-1] != null){
                    for (Factura j : registroVentas[i][numeroDia - 1].getFacturas()) {
                        suma = suma + j.getCantidad();
                    }
                }

            }
            System.out.println("En total se han vendido "+suma+" unidades de todos los productos para el día seleccionado");
        }
        else{
            System.out.println("Día incorrecto");
        }
        return 0;
    }//cierra consultarVentasDia

    //RQ3
    public void consultarVentasProducto(int cod) {
        int suma=0;
        if(cod>0 && cod<=5){
            for (int j = 0; j < 7; j++) {
                if(registroVentas[cod-1][j] != null){
                for(Factura i:registroVentas[cod-1][j].getFacturas()) {
                    suma=suma+i.getCantidad();
                }
                }
                
            } System.out.println("En total se han vendido "+suma+" unidades del producto seleccionado.");
        }else System.out.println("Producto incorrecto");
       
     }//cierra consultarVentasProducto

    //RQ4
    public void eliminarFacturasVentasEscasas() {
        if(bandera){
        for (int i = 0; i <registroVentas.length; i++) {
            for (int j = 0; j <registroVentas[i].length; j++) {
                if(registroVentas[i][j] != null){
                 registroVentas[i][j].getFacturas().removeIf(n -> (n.getCantidad()<=2));
               
                }
            }
        }
        bandera=false;
        imprimirRegistroVentas();
        }else System.out.println("No hay  facturas por  depurar");
    }//cierra eliminarFacturasVentasEscasas
    
    public static Character getFirstCharacter(String s)
    {
        if(s == null || s.length() == 0)
            return null;
        else
        {
            char[] charArr = s.toCharArray();
            return charArr[0];
        }
    }
}//Cierra class
