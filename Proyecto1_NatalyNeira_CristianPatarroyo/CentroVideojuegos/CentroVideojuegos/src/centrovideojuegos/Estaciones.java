/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package centrovideojuegos;

/**
 *
 * @author conta
 */
public class Estaciones {
//Atributos
  private  String estado; //  cambié  esta para  hacer mas  facíl la verificación de ocupado
  private  long idJugador;
  private  String nombreJ;
  private String fecha;
  private  int tiempo;
  private  long ganancia;
    
    //Constructor

  
//  modifiqué  este para que sea un metodo del objeto,  lo reescribí linea 46
         
    /*public Estaciones(int idEstacion, long idJugador, String nombreJ, int tiempo, long ganancia) {
        this.idEstacion = idEstacion;
        this.idJugador = idJugador;
        this.nombreJ = nombreJ;
        this.tiempo = tiempo;
        this.ganancia = ganancia;
    }*/

   //constructor vacio 
  
    public Estaciones() {
    }
    
    //__________________________________________________________________________
    // Metodos  de comportamiento Propio
    
     public void showNombreJ(){
        System.out.println(nombreJ);
    }
    
    // asigna  un  jugador  a la  estación  y cambia  su condicion de  vacio a Ocupado
    public   void reAsignarEstaciones ( long idJugador, String nombreJ, long ganancia) {
        this.estado = "Ocupado";
        this.idJugador = idJugador;
        this.nombreJ = nombreJ;
        this.ganancia = ganancia;
      }

    
    // imprimir atributos del objeto 
    @Override
    public String toString() {
        return "Estaciones{" + "estado=" + estado + ", idJugador=" + idJugador + ", nombreJ=" + nombreJ + ", fecha=" + fecha + ", tiempo=" + tiempo + ", ganancia=" + ganancia + '}';
    }
    
    
//_______________________________________________________________________________    
    //Comportamientos o métodos de encapsulamiento 
     //Getter and Setter

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(long idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreJ() {
        return nombreJ;
    }

    public void setNombreJ(String nombreJ) {
        this.nombreJ = nombreJ;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public long getGanancia() {
        return ganancia;
    }

    public void setGanancia(long ganancia) {
        this.ganancia = ganancia;
    }
      
}
