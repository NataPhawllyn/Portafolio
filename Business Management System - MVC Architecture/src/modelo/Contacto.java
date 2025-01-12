/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ander
 */
public class Contacto {
    private String direccion;
    private String mail;
    private long tel;

    public Contacto() {
    }

    public Contacto(String direccion, String mail, long tel) {
        this.direccion = direccion;
        this.mail = mail;
        this.tel = tel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Contacto{" + "direccion=" + direccion + ", mail=" + mail + ", tel=" + tel + '}';
    }    
}
