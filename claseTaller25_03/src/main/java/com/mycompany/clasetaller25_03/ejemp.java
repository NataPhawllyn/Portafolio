/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clasetaller25_03;
import java.util.Scanner;
/**
 *
 * @author nataly
 */
public class ejemp {
    
     public static void  main(String[] args){
         String  palabra=null;
         Scanner  tc=new Scanner (System.in);
          System.out.println("Ingrese una frase.");
                 palabra=tc.nextLine();
                 
                String[] sPalabra=palabra.split(" ");
                   
             System.out.println(sPalabra.length);         
      }
    
}
