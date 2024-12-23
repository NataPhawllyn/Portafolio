package modelo;
import java.nio.file.*;
import java.io.*;
import java.util.Scanner;

public abstract class Lector {

    public Scanner leer = new Scanner(System.in);
    
    public abstract void registrar();

    public String leerString(){
        String valor;
        valor = leer.nextLine();
        return valor;
    }
    
    public String leerTexto(){
        String valor;
        valor = leer.next();
        return valor;
    }
    
    public void escribirArchivo(String archivo, String texto) {
        // Validamos si existe el fichero
        Path path = Paths.get(archivo);
        String text = texto+"\n";
 
        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] leerTextoPlano(String ruta) throws FileNotFoundException {
        
        InputStream ins = new FileInputStream(ruta);
        Scanner obj = new Scanner(ins);
        String contenido = "";
        String[] texto= null;       
        while (obj.hasNextLine())
            contenido=contenido+obj.nextLine()+"\n";
        texto = contenido.split("\n");
        return texto;
    }
    
    public void imprimirTextoPlano(String[] texto){
        for (int i = 0; i < texto.length; i++) {
            System.out.println(texto[i]);
        }
    }
        
    public int leerInt() {
        int valor;
        valor = leer.nextInt();
        return valor;
    }
    
    public double leerLong() {
        double valor;
        valor = leer.nextDouble();
        return valor;
    }

    public void imprimirTexto(String texto) {
        System.out.print(texto);
    }

    public void imprimirTextoLn(String texto) {
         System.out.println(texto);
    }
    
    //Reemplazo de texto en txt
    
    public static void remplar (String ruta2, String modificacion, String renplazar) throws FileNotFoundException {

        try {

            String sCarpAct = System.getProperty("user.dir");
            File carpeta = new File(sCarpAct);
            Path path = Paths.get(ruta2);

            remplazo(carpeta + "\\" + ruta2,  modificacion, renplazar);

        } catch (IOException e) {
            System.err.println("no entro");
        }

    }

    public static void sobreEscribir(String archivo, String texto) {
        // Validamos si existe el fichero
        Path path = Paths.get(archivo);
        String text = texto + "";

        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void remplazo(String ruta, String modificacion, String renplazar) throws FileNotFoundException, IOException {

        InputStream ins = new FileInputStream(ruta);

        Scanner obj = new Scanner(ins);

        String contenido = "";
        while (obj.hasNextLine()) {
            contenido = contenido + obj.nextLine() + "\n";
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        bw.write("");
        bw.close();

        sobreEscribir(ruta, contenido.replace(modificacion, renplazar));
    }
  

}