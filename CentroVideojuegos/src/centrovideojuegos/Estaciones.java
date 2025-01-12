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
  private  String estado; 
  private  long idJugador;
  private  String nombreJ;
  private String fecha;
  private  int tiempo;
  private  long ganancia;
  private int uso=0;
    
    //Constructor

  

   //constructor vacio 
  
    public Estaciones() {
    }
    
    //__________________________________________________________________________
    // Metodos  de comportamiento Propio
    
   
    
    // asigna  un  jugador a esta  estación 
    public   void reAsignarEstaciones ( long idJugador, String nombreJ,int tiempo,String fecha) {
        this.estado = "Ocupado";
        this.idJugador = idJugador;
        this.nombreJ = nombreJ;
        this.tiempo=tiempo;
        this.fecha=fecha;
      }
    
    // vacia la  estación cuando sale un jugador 
    public  void vaciarEstacion(){
        estado=null;
        idJugador =0;
        nombreJ = null;
       tiempo=0;
        fecha=null;
    }
    
    //Calcula  el cobreo del tiempo jugado 
    public void liquidarCuenta(){
        ganancia=ganancia+(100*tiempo);
        System.out.println("Se ha registrado la salida del jugador "+toString());
        System.out.println("debe cancelar $"+(100*tiempo));
      
    }
    
    // lleva el conteo de uso de la estación
   public void registroUso(){
   
       uso++;
 
   }
    
    // imprimir atributos del objeto 
    @Override
    public String toString() {
        return  "identificación:" + idJugador + ", nombre:" + nombreJ + ", fecha:" + fecha + ", minutos:" + tiempo ;
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

    public int getUso() {
        return uso;
    }

    public void setUso(int uso) {
        this.uso = uso;
    }
      
}
