
package modelo;

import java.util.ArrayList;


public  class Cliente extends Lector{
    private String direccion;
    private long tel;
    private long id;
    private String nombre;
    private ArrayList<Factura> factura;
    
    

    public Cliente() {
    }

    public Cliente(String direccion, long tel, long id, ArrayList<Factura> factura) {
        this.direccion = direccion;
        this.tel = tel;
        this.id = id;
        this.factura = factura;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   

    

    public ArrayList<Factura> getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura.add(factura);  
    }

    @Override
    public String toString() {
        return "Cliente{" + "direccion=" + direccion + ", tel=" + tel + ", id=" + id + ", factura=" + factura + '}';
    }

    /*public abstract void comprar();
    public abstract void pagar();
//   */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    @Override
    public void registrar() {
       super.escribirArchivo("Clientes.txt", this.getId()+","+this.getDireccion()+","+this.getTel()+","+this.getNombre());
    }
}
