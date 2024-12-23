/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conversion2_614212782;
public class Temperatura2 {
    // atributos  
    public double  grados;
    public double  fahren;
    
    
 // constructor 
    public Temperatura2() {
         
    }

    //  get 
    public double getGrados() {
        return grados;
    }

    public double getFahren() {
        return fahren;
    }
    
    // set 

    public void setGrados(double grados) {
        this.grados = grados;
    }

    public void setFahren(double fahren) {
        this.fahren = fahren;
    }
    
    // metodos 
    public double conversion (){
        
        fahren= (1.8*grados)+32;
            
        return fahren; 
    }
}
