/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3_hincapieneira;

import java.util.ArrayList;

/**
 *
 * @autores Duran,Hincapie,Neira. 
 */
public class Venta {
    private ArrayList<Factura> facturas = new ArrayList<>();

    public Venta() {
    }
     
    
    
    public void registrarFactura(int cP, int c, String fecha, int cV){
        Factura f = new Factura(cP, c, fecha, cV);
         facturas.add(f);
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    
}
