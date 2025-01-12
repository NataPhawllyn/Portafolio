
package proyecto2_neiracruz;


public class Libros {
    private String isbn;
    private String titulo;
    private float precio;
    private int cantDisp;
    private int cantVendida;

    public Libros() {
    }

    public Libros(String isbn, String titulo, float precio, int cantDisp, int cantVendida) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.precio = precio;
        this.cantDisp = cantDisp;
        this.cantVendida = cantVendida;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantDisp() {
        return cantDisp;
    }

    public void setCantDisp(int cantDisp) {
        this.cantDisp = cantDisp;
    }

    public int getCantVendida() {
        return cantVendida;
    }

    public void setCantVendida(int cantVendida) {
        this.cantVendida = cantVendida;
    }

    @Override
    public String toString() {
        return "Libros{" + "isbn=" + isbn + ", Titulo=" + titulo + ", Precio=" + precio + ", Cantidad disponible=" + cantDisp + ", Cantidad vendida=" + cantVendida + '}';
    }
   
    
   public void agregarLibro(String datos) {
        String[] nPalabras = datos.split("\\&",3);
        this.isbn = nPalabras[0];
        this.titulo = nPalabras[1];
        this.precio = Integer.parseInt(nPalabras[2]);
        System.out.println("Se agregó el libro : \n" + toString());
    }
    
}
