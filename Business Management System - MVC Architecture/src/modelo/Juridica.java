
package modelo;

import java.util.ArrayList;


public class Juridica extends Cliente{
    private ArrayList<Contacto> contacto;

    public Juridica() {
    }

    public Juridica(ArrayList<Contacto> contacto) {
        this.contacto = contacto;
    }

    public Juridica(ArrayList<Contacto> contacto, String direccion, long tel, int id, ArrayList<Factura> factura) {
        super(direccion, tel, id, factura);
        this.contacto = contacto;
    }

    public ArrayList<Contacto> getContacto() {
        return contacto;
    }

    public void setContacto(ArrayList<Contacto> contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Juridica{" + "contacto=" + contacto + '}';
    }
/*
    @Override
    public void comprar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pagar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
}
