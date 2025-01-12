/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ahorrosfam;
import java.util.Scanner;
/**
 *
 * @author Nataly Neira 614212782
 */
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      int  temp;
      Scanner tc= new Scanner(System.in);
        System.out.println("Calculo de ahorro para la  Familia Neira en el Mes de Marzo");
        
       FliaNeira objFliaNeira=new FliaNeira();
       
       //  digitar ingresos 
        for (int i = 1; i <5; i++) {
            System.out.println("Digite el  ingreso "+i);
            objFliaNeira.setIngresos(objFliaNeira.getIngresos()+tc.nextInt());
            
         
        }System.out.println("Total Ingresos= "+objFliaNeira.getIngresos());
        
       // digitar  egresos  
        for (int i = 1; i < 11; i++) {
            System.out.println("Digite el gasto "+i);
            objFliaNeira.setEgresos(objFliaNeira.getEgresos()+tc.nextInt());
            
        }System.out.println("Total Ingresos= "+objFliaNeira.getEgresos());
       
        objFliaNeira.gananciaTotal();
      System.out.println( objFliaNeira.toString());
        
    }
    
}