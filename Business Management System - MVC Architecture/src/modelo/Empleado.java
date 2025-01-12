
package modelo;


public class Empleado extends Lector{
    private String cargo, usuario, clave;
    private long sueldo;
    private int id;

    public Empleado(String cargo, String usuario, String clave, long sueldo, int id) {
        this.cargo = cargo;
        this.usuario = usuario;
        this.clave = clave;
        this.sueldo = sueldo;
        this.id = id;
    }


    public Empleado() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public long getSueldo() {
        return sueldo;
    }

    public void setSueldo(long sueldo) {
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Empleado{" + "cargo=" + cargo + ", usuario=" + usuario + ", clave=" + clave + ", sueldo=" + sueldo + ", id=" + id + '}';
    }

    @Override
    public void registrar() {
     super.escribirArchivo("Usuarios.txt", this.getUsuario()+","+this.getClave()+","+this.getId()+","+this.getCargo()+","+this.getSueldo());
       
    }

    

    
}
