/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author ander
 */
public class Natural extends Cliente{
    private Contacto contacto;

    public Natural(Contacto contacto) {
        this.contacto = contacto;
    }

    public Natural(Contacto contacto, String direccion, long tel, int id, ArrayList<Factura> factura) {
        super(direccion, tel, id, factura);
        this.contacto = contacto;
    }

    public Natural() {
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

   /* @Override
    public void comprar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pagar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
}
