/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3_hincapieneira;

/**
 *
 * @autores Duran,Hincapie,Neira. 
 */
public class Factura {
    private int codigoProducto;
    private String fecha;
    private int cantidad;
    private int codigoVendedor;

    public Factura(int codigoProducto, int cantidad, String fecha, int codigoVendedor) {
        this.codigoProducto = codigoProducto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.codigoVendedor = codigoVendedor;
    }

    //cierra Factura

    public int getCodigoProducto() {
        return codigoProducto;
    }//cierra getCodigoProducto

    public int getCantidad() {
        return cantidad;
    }//cierra getCantidad
    
}
