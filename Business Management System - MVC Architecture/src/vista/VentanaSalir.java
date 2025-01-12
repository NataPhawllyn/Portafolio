/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
 import javax.swing.*; 
import java.awt.Image;
import javax.swing.ImageIcon;





public class VentanaSalir extends JFrame {

    JLabel lblAdvertencia;  
    JPanel jpnImagen;  
    JPanel jpnAdvertencia;
    JPanel jpnBotones;
    JButton btnAceptar;  
    JButton btnCancelar;
   LogoUser imgAdver = new LogoUser();
    
    
    public VentanaSalir() {
        //panel 1
        this.jpnImagen= new JPanel(new FlowLayout()); 
        this.jpnImagen.add(imgAdver);
        
       
        // panel 2
        
        this.jpnAdvertencia= new JPanel(new FlowLayout());
        this.lblAdvertencia=new JLabel("¿Desea guardar los  cambios  efectuados?");
        this.jpnAdvertencia.add(lblAdvertencia);
        
       
        
        // panel 3
       
        this.jpnBotones= new JPanel(new  FlowLayout());
        this.btnAceptar= new JButton("ACEPTAR");
        this.btnCancelar= new JButton("CANCELAR");
        this.jpnBotones.add(btnAceptar);
        this.jpnBotones.add(btnCancelar);
       
        
        
        
        // poner el paneles  en la  ventana 
        this.setTitle("Advertencia");// titulo
        this.getContentPane().setLayout(new BorderLayout());// borde de la ventana 
        
        // ubicacion  de los  paneles 
        add(jpnImagen,BorderLayout.NORTH); 
        add(jpnAdvertencia,BorderLayout.CENTER);
        add(jpnBotones, BorderLayout.SOUTH);
        pack();
        
    }

    public JLabel getLblAdvertencia() {
        return lblAdvertencia;
    }

    public void setLblAdvertencia(JLabel lblAdvertencia) {
        this.lblAdvertencia = lblAdvertencia;
    }

    public JPanel getJpnImagen() {
        return jpnImagen;
    }

    public void setJpnImagen(JPanel jpnImagen) {
        this.jpnImagen = jpnImagen;
    }

    public JPanel getJpnAdvertencia() {
        return jpnAdvertencia;
    }

    public void setJpnAdvertencia(JPanel jpnAdvertencia) {
        this.jpnAdvertencia = jpnAdvertencia;
    }

    public JPanel getJpnBotones() {
        return jpnBotones;
    }

    public void setJpnBotones(JPanel jpnBotones) {
        this.jpnBotones = jpnBotones;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

   class LogoUser extends JPanel{
     
    private Image imagen;
    @Override
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource("/Imagenes/advertencia.png")).getImage();
        g.drawImage(imagen, 0, 0, 3000,3000, this);
        setOpaque(false);
        super.paint(g);
    }}
    
    
}
