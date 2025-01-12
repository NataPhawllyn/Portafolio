
package modelo;


public class Inventario extends Lector {
    private String nombreProducto;
    private int cantidad;
    private long precio;
    private long codigoBarra;
    
    

    public Inventario() {
    }

    public Inventario(String nombreProducto, int cantidad, long precio,long codigo) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.codigoBarra=codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public long getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(long codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    
    
    @Override
    public String toString() {
        return "Inventario{" + "nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

    private void sacar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    private void consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    @Override
    public void registrar() {
       super.escribirArchivo("Productos.txt", this.getCodigoBarra()+","+this.getNombreProducto()+","+this.getCantidad()+","+this.getPrecio());
     }
    
    
}
