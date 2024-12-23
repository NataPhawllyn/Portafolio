
package modelo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import vista.Facturación;


public class Factura  extends Lector{
    private int numero;
    private String fechaCreacion;
    private Double totalFactura;
    private long idCliente;
    private ArrayList<Inventario> inventario;
    
    Facturación fact = new Facturación();
    

    

    public Factura() {
    }

    public Factura(int numero, String fechaCreacion, double totalFactura, ArrayList<Inventario> inventario) {
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.totalFactura = totalFactura;
        this.inventario = inventario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public ArrayList<Inventario> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Inventario> inventario) {
        this.inventario = inventario;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    
    
    @Override
    public String toString() {
        return "Factura{" + "numero=" + numero + ", fechaCreacion=" + fechaCreacion + ", totalFactura=" + totalFactura + ", inventario=" + inventario + '}';
    }

    public void cotizacion(Facturación frmFactura) {
         Document documento = new  Document();
           documento.setMargins(60, 60, 0, 50);
            try {
                String ruta= System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/Desktop/Cotizacion.pdf"));
                System.out.println(ruta);
                Image encabezado =Image.getInstance("src/Imagenes/cotizar.png");
                encabezado.scaleToFit(650,650);       
                encabezado.setAlignment(Chunk.ALIGN_CENTER);    
                
                Paragraph fecha= new Paragraph();
                fecha.setAlignment(Chunk.ALIGN_TOP);
                fecha.setFont(FontFactory.getFont("Tahoma",18,Font.BOLD,BaseColor.BLUE));
                fecha.add(frmFactura.getLblFecha().getText());
                
                Paragraph clienteInfo = new Paragraph();
                clienteInfo.setAlignment(Chunk.ALIGN_LEFT);
                clienteInfo.add("\n\n");
                clienteInfo.add(" DATOS CLIENTE \n"
                                +"\n NIT/CC: "+frmFactura.getTxtIngresarID().getText()
                                +"\n NOMBRE: "+frmFactura.getLblImprimeNombre().getText()
                                +"\n DIRECCIÓN: "+ frmFactura.getLblImprDireccion().getText()
                                +"\n TELÉFONO: "+frmFactura.getLblImpTelefono().getText()+"\n\n");
               
                
                documento.open();
                documento.add(encabezado);
                documento.add(fecha);
                documento.add(clienteInfo);
                
                PdfPTable tabla = new PdfPTable(4);
                tabla.addCell("Numero");
                tabla.addCell("Producto");
                tabla.addCell("Cantidad");
                tabla.addCell("Valor unitario");
                 
                for (int i = 0; i < frmFactura.getDtmFactura().getRowCount(); i++) {
                    for (int j = 0; j < frmFactura.getDtmFactura().getColumnCount();j++) {
                        tabla.addCell(frmFactura.getDtmFactura().getValueAt(i, j).toString());
                    }
                }
                documento.add(tabla);
                
                Paragraph totales = new Paragraph();
                totales.setAlignment(Chunk.ALIGN_RIGHT);
                totales.add("\n SUBTOTAL: $ "+ frmFactura.getLblImprimeSubtotal().getText()
                           +"\n  IVA 19%: $ "+ frmFactura.getLblImprimirIva().getText()
                           +"\n   TOTAL : $ "+ frmFactura.getLblImprimirTotal().getText()+"\n\n");
                
                documento.add(totales);
                
                Paragraph disclaimerCot = new Paragraph();
                disclaimerCot.setAlignment(Chunk.ALIGN_BOTTOM);
                disclaimerCot.setFont(FontFactory.getFont("Tahoma",8,Font.BOLD,BaseColor.GRAY));
                disclaimerCot.add("Este documento no tiene valor comercial y es valida por 15 días calendario.");
                
                documento.add(disclaimerCot);
                 documento.close();
                frmFactura.getLblVerficarFactura().setText("Cotización PDF Generada  en escritorio");
                
                
            } catch (DocumentException | FileNotFoundException f) {
                System.out.println(" error  en  impresión pdf "+ f);
            }catch(IOException f){
                System.out.println("error en imagen encabezado "+ f);
            }
        }

    public void crear(Facturación frmFactura) {
         Document documento = new  Document();
             documento.setMargins(70, 60, 0, 18);
             try {
                String ruta= System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/Desktop/Factura.pdf"));
                
                Image encabezado =Image.getInstance("src/Imagenes/facturar.png");
                encabezado.scaleToFit(650,650);       
                encabezado.setAlignment(Chunk.ALIGN_CENTER);    
                
                Paragraph fecha= new Paragraph();
                fecha.setAlignment(Chunk.ALIGN_TOP);
               fecha.setFont(FontFactory.getFont("Tahoma",24,Font.BOLD,BaseColor.BLUE));
               fecha.add("\n FACTURA DE VENTA N° "+frmFactura.getLblCodFactur().getText());
               fecha.setFont(FontFactory.getFont("Tahoma",18,Font.BOLD,BaseColor.BLACK));
               fecha.add("\n"+frmFactura.getLblFecha().getText());
                
                Paragraph clienteInfo = new Paragraph();
                clienteInfo.setAlignment(Chunk.ALIGN_LEFT);
                clienteInfo.add("\n\n");
                clienteInfo.add(" DATOS CLIENTE \n"
                                +"\n NIT/CC: "+frmFactura.getTxtIngresarID().getText()
                                +"\n NOMBRE: "+frmFactura.getLblImprimeNombre().getText()
                                +"\n DIRECCIÓN: "+ frmFactura.getLblImprDireccion().getText()
                                +"\n TELÉFONO: "+frmFactura.getLblImpTelefono().getText()+"\n\n");
               
                
                documento.open();
                documento.add(encabezado);
                documento.add(fecha);
                documento.add(clienteInfo);
                
                PdfPTable tabla = new PdfPTable(5);
                tabla.addCell("#");
                tabla.addCell("Cantidad");
                tabla.addCell("Descripción");
                tabla.addCell("Valor unitario");
                tabla.addCell("Valor total");
                
                 
                for (int i = 0; i < frmFactura.getDtmFactura().getRowCount(); i++) {
                    for (int j = 0; j < frmFactura.getDtmFactura().getColumnCount();j++) {
                        tabla.addCell(frmFactura.getDtmFactura().getValueAt(i, j).toString());
                    }
                }
                documento.add(tabla);
                
                Paragraph totales = new Paragraph();
                totales.setAlignment(Chunk.ALIGN_RIGHT);
                totales.add("\n SUBTOTAL: $ "+ frmFactura.getLblImprimeSubtotal().getText()
                           +"\n  IVA 19%: $ "+ frmFactura.getLblImprimirIva().getText()
                           +"\n   TOTAL : $ "+ frmFactura.getLblImprimirTotal().getText()+"\n\n");
                
                documento.add(totales);
                
                Paragraph disclaimerFac = new Paragraph();
                disclaimerFac.setAlignment(Chunk.ALIGN_BOTTOM);
                disclaimerFac.setFont(FontFactory.getFont("Tahoma",8,Font.BOLD,BaseColor.GRAY));
                disclaimerFac.add("A esta factura de ventas aplican las normas relativas a la  letra de cambio (Articulo 5 ley 1231  del 2008).");
                
                documento.add(disclaimerFac);
                 documento.close();
                frmFactura.getLblVerficarFactura().setText("Factura PDF Generada  en escritorio");
                
                
            } catch (DocumentException | FileNotFoundException f) {
                System.out.println(" error  en  impresión pdf "+ f);
            }catch(IOException f){
                System.out.println("error en imagen encabezado "+ f);
            }
         
            super.escribirArchivo("Facturas.txt", frmFactura.cargarFactura());
       
     }
/*
    private void consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void anular() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

    @Override
    public void registrar() {
       super.escribirArchivo("Facturas.txt",this.getNumero()+","+this.getFechaCreacion()+","+this.getIdCliente()+","+this.getTotalFactura());
     }
    
     
    
}
