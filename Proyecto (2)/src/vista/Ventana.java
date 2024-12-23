/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import javax.swing.*;  

/**
 *
 * @author ander
 */
public class Ventana {
    public static String[] solicitarloging(){
        String[] login = new String[2];
                login[0]=JOptionPane.showInputDialog(null,"Ingrese el usuario");
                login[1]=JOptionPane.showInputDialog(null,"Ingrese la contraseña");

        return login;
    }
    
    public static String solicitarDato(String texto){
        return JOptionPane.showInputDialog(null,texto);
        
    }

    public static void mostarTextoAlerta(String texto) {
         JOptionPane.showMessageDialog(null,texto,"Alert",JOptionPane.WARNING_MESSAGE);     
    }
    
    public static void mostarTexto(String texto) {
         JOptionPane.showMessageDialog(null,texto);     
    }
    
    public static void mostarTextoError(String texto) {
         JOptionPane.showMessageDialog(null,texto,"Error",0);     
    }
    
    
    public static String solicitarTexto(String texto) {
        return JOptionPane.showInputDialog(null,texto);
    }

    public static int solicitarOpcion(String[] opciones, String texto) {
        return JOptionPane.showOptionDialog(null, texto,
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }
    
    
}
