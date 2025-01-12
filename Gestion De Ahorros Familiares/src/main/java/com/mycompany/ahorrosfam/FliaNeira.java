/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ahorrosfam;
/**
 *
 * @author Ingenieria
 */
public class FliaNeira {
     
   // atributos  
    public int  ingresos;
    public int  egresos;
    public int  ahorro;
    
    
 // constructor 
    public FliaNeira() {
         
    }

    //  get 

    public int getIngresos() {
        return ingresos;
    }

    public int getEgresos() {
        return egresos;
    }

    public int getAhorro() {
        return ahorro;
    }
    
    
    // set 

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public void setEgresos(int egresos) {
        this.egresos = egresos;
    }

    public void setAhorro(int ahorro) {
        this.ahorro = ahorro;
    }

    
    
    // metodos 
   
    
    
    public int gananciaTotal (){
        
        ahorro= ingresos-egresos;
            
        return ahorro; 
       
    }
    

    @Override
    public String toString() {
        return "FliaNeira{" + "ingresos=" + ingresos + ", egresos=" + egresos + ", ahorro=" + ahorro + '}';
    }
    
    
  
    
}
