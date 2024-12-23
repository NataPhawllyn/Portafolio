/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conversion2_614212782;
import java.util.Scanner;
/**
 *
 * @author Nataly Neira 614212782
 */
public class Conversion2 {

     public static void main(String[] args) {
         
         
        Scanner tc= new Scanner(System.in);
        System.out.println("Digite el valor de la temperatura en  grados  celcius");
       
       
         
        Temperatura2 objTemperatura2 = new Temperatura2(); 
        
        objTemperatura2.setGrados(tc.nextDouble());
        
        objTemperatura2.conversion();
        
        System.out.println("La temperatura  en  grados  centigrados  es 30");
        System.out.println("La temperatura  en grados  fahrenheit es de "+objTemperatura2.fahren);
        
    }
    
}
