/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clasetaller25_03;
import  java.util.Scanner;
/**
 *
 * @author nataly
 */
public class NatalyNeira {
    public static Scanner tc= new Scanner(System.in);
    public static String palabra=null;
    
    public static void main(String[] args) {
        int  opc,cant;
        
        
         
         
        
         do{
            
             System.out.println("Ingrese el  número de la opción  que  necesita"
                +"\n 1.Palabra Limitada. "
                +"\n 2.Palabra con mayúscula  al final. "
                +"\n 3.Contar palabras. "
                +"\n 4.Palabra con número. "
                +"\n 5.Palabra con  símbolo. "
                +"\n 6.Salir. ");
        
            opc =tc.nextInt();
         switch (opc)
         {
             case 1:
                 validarPalabra(7);
                 
                     break;
             case 2:
                 
                 mayusFinal();
                 
                     break;
             case 3:
                 
                 cant=contarPalabras();
                 System.out.println("La frase ingresada tiene "+cant+" palabras.");
                 
                     break;
             case 4:
                 
                 numeroPalabra();
                 
                     break;
             case 5:
                 
                 if(simboloPalabra())System.out.println("Palabra Correcta.");
                else System.out.println("La palabra no cumple con los  criterios.");
                 
                     break;
             case 6:
                 System.out.println("Gracias");
                     break;
                     
             default: 
                 
         }}while(opc!=6);
             
        
        
    }    
    
   public static void validarPalabra( int  cantidad){
       
       System.out.println("Ingrese una palabra de al menós "+cantidad+ " caracteres. ");
                 palabra=tc.next();
                 
                 if(palabra.length()>=cantidad)
                 {System.out.println("Palabra Correcta.");
                 }else{System.out.println("La palabra no cumple con los  criterios.");}
                 
   }
   public static void mayusFinal(){
       
       System.out.println("Ingrese una palabra con  solo la ultima letra en mayúscula");
                 palabra=tc.next();
                 int f=palabra.length();
                 String minus=palabra.toLowerCase();
                 char[] cPalabra=palabra.toCharArray();
                 char[] cMinus=minus.toCharArray();
                 
                 
                 for (int i = 0; i < f; i++) {
                     
                     if (i!=f-1){
                     if (cPalabra[i]==cMinus[i])continue;
                     else System.out.println("La palabra no cumple con los  criterios.");
                     }else if(cPalabra[i]!=cMinus[i])System.out.println("Palabra Correcta.");
                     else System.out.println("La palabra no cumple con los  criterios.");
                     }}
                 
      public static int contarPalabras(){
          
          System.out.println("Ingrese una frase.");
                 palabra=tc.nextLine();
                 
                String[] sPalabra=palabra.split(" ");
                   
             return sPalabra.length;         
      }
      
      public static void numeroPalabra(){
          System.out.println("Ingrese una Palabra que contenga al menos  un  número.");
                 palabra=tc.next();
                 char[] cPalabra=palabra.toCharArray();
                 
                  int a=0;
                 for (int i = 0; i < palabra.length(); i++) {
                    if(58>cPalabra[i] && cPalabra[i]>47)a++;
                    }
                 
                if(a!=0)System.out.println("Palabra Correcta.");
                else System.out.println("La palabra no cumple con los  criterios.");
          
      }
      
      public static boolean  simboloPalabra(){
           System.out.println("Ingrese una Palabra que contenga al menos uno de tres símbolos (#, *, @");
                 palabra=tc.next();
                 char[] cPalabra=palabra.toCharArray();
                 
                  boolean a=false;
                 for (int i = 0; i < palabra.length(); i++) {
                    if(35==cPalabra[i] || cPalabra[i]==64 || cPalabra[i]==42)a=true;
                    }
                 return a;
      }
 
}
