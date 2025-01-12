package controlador;

import java.awt.event.*;
import java.io.*;
import vista.*;
import modelo.*;
import java.util.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Control implements ActionListener {

    

    private Administrador admin;
    private Cliente cliente;
    private Factura factura;
    private Inventario producto;
    private Principal frmPrin;
    private MenuAdmin frmMenuAdmin;
    private MenuVendedor frmMenuVendedor;
    private RegistrarEmpleado frmRegEmpl;
    private RegistrarCliente frmRegCli;
    private EditarCliente frmEditarCli;
    private Facturación frmFactura;
    private ConsultarCliente frmConsCli;
    private RegistrarProducto frmRegPro;
    private ListaProductos frmListaPro;
    private VentanaSalir vntAdvertencia;

    public Control() {
        frmPrin = new Principal();
        frmMenuAdmin = new MenuAdmin();
        frmMenuVendedor = new MenuVendedor();
        frmRegEmpl = new RegistrarEmpleado();
        frmRegCli = new RegistrarCliente();
        frmConsCli = new ConsultarCliente();
        frmRegPro = new RegistrarProducto();
        frmEditarCli = new EditarCliente();
        frmFactura = new Facturación();
        frmListaPro= new ListaProductos();
        vntAdvertencia = new VentanaSalir();
        
        admin = new Administrador();
        cliente = new Cliente();
        factura = new Factura();
        producto = new Inventario();
        
        vntAdvertencia.getBtnAceptar().addActionListener(this);
        vntAdvertencia.getBtnCancelar().addActionListener(this);

        frmPrin.getBtnIngresarPrincipal().addActionListener(this);
        frmPrin.getBtnSalirPrincipal().addActionListener(this);

        frmRegEmpl.getBtnIngresarEmpl().addActionListener(this);
        frmRegEmpl.getBtnSalirRegEmpl().addActionListener(this);

        frmRegCli.getBtnIngClien().addActionListener(this);
        frmRegCli.getBtnSalirClien().addActionListener(this);

        frmRegPro.getBtnRegisProducto().addActionListener(this);
        frmRegPro.getBtnSalirRegiProduc().addActionListener(this);

        frmConsCli.getBtnConsultarCliente().addActionListener(this);
        frmConsCli.getBtnEditarClien().addActionListener(this);
        frmConsCli.getBtnSalirConsul().addActionListener(this);

        frmEditarCli.getBtnEditarClien().addActionListener(this);
        frmEditarCli.getBtnSalirEditar().addActionListener(this);
        
        frmListaPro.getBtnBuscarProd().addActionListener(this);
        frmListaPro.getBtnSalirListaProd().addActionListener(this);
        frmListaPro.getBtnTodosProd().addActionListener(this);

        frmFactura.getBtnBuscarCliente().addActionListener(this);
        frmFactura.getBtnCotizarFac().addActionListener(this);
        frmFactura.getBtnFacturar().addActionListener(this);
        frmFactura.getBtnRegistarCliente().addActionListener(this);
        frmFactura.getBtnSalirFactura().addActionListener(this);
        frmFactura.getBtnAgregar().addActionListener(this);
        frmFactura.getBtnBuscarProducto().addActionListener(this);
        frmFactura.getBtnCalcular().addActionListener(this);
        frmFactura.getBtnConsProd().addActionListener(this);
        
        

        frmMenuAdmin.getMenuItemRegEmpl().addActionListener(this);
        frmMenuAdmin.getMenuItemRegClien().addActionListener(this);
        frmMenuAdmin.getMenuItemModClien().addActionListener(this);
        frmMenuAdmin.getMenuItemGenCot().addActionListener(this);
        frmMenuAdmin.getMenuItemSalir().addActionListener(this);
        frmMenuAdmin.getMenuItemRegProd().addActionListener(this);
        frmMenuAdmin.getMenuItemConsInventario().addActionListener(this);

        frmMenuVendedor.getMenuItemRegClien().addActionListener(this);
        frmMenuVendedor.getMenuItemConsultarCliente().addActionListener(this);
        frmMenuVendedor.getMenuItemCreaFac().addActionListener(this);
        frmMenuVendedor.getMenuItemConsultaProd().addActionListener(this);
        frmMenuVendedor.getMenuItemSalir().addActionListener(this);

    }

    public void Iniciar() {
        frmPrin.setVisible(true);

    }



    public String[] login() {
        String concUserPass = frmPrin.getTxtLogin().getText() + "," + frmPrin.getTxtPassword().getText();
        try {
            String sCarpAct = System.getProperty("user.dir");
            File carpeta = new File(sCarpAct);
            String[] texto = Lector.leerTextoPlano(carpeta + "\\Usuarios.txt");
            boolean bandera = false;
            for (String texto1 : texto) {
                String[] textosplit = texto1.split(",");
                if (concUserPass.equals(textosplit[0] + "," + textosplit[1])) {
                    bandera = true;
                    return textosplit;

                }
            }
            if (!bandera) {
                frmPrin.getLblValidaUsuario().setText("Usuario no encontrado");
            }
        } catch (FileNotFoundException p) {
            frmPrin.getLblValidaUsuario().setText("Usuario no encontrado");
            //Apntamiento hacia otro ladooooooo ------------------------------
        }
        return null;
    }

    public String[] cliente() {
        try {
            String sCarpAct = System.getProperty("user.dir");
            File carpeta = new File(sCarpAct);
            String[] texto = Lector.leerTextoPlano(carpeta + "\\Clientes.txt");
            return texto;
        } catch (FileNotFoundException p) {
            frmConsCli.getLblVerficarDatos().setText("Cliente no encontrado");
            //Apntamiento hacia otro ladooooooo ------------------------------
        }
        return null;
    }

    public String[] producto() {
        try {
            String sCarpAct = System.getProperty("user.dir");
            File carpeta = new File(sCarpAct);
            String[] texto = Lector.leerTextoPlano(carpeta + "\\Productos.txt");
            return texto;

        } catch (FileNotFoundException p) {
            frmFactura.getLblValidaProduc().setText("Producto no encontrado");
            //Apntamiento hacia otro ladooooooo ------------------------------
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] arrGen = new String[5];
        String[] arrClien = new String[4];
        String[] arrProd = new String[3];

        arrGen = login();
        arrClien = cliente();
        arrProd = producto();
        
       
        
        //boolean banderaConfirmar=false;
        //principal 

        if (e.getSource() == frmPrin.getBtnIngresarPrincipal()) {
            for (int i = 0; i < login().length; i++) {
                if (arrGen[i].equals("Administrador")) {
                    frmMenuAdmin.setVisible(true);
                    break;
                }
                if (arrGen[i].equals("Vendedor")) {
                    frmMenuVendedor.setVisible(true);
                    break;
                }
            }

        }
        if (e.getSource() == frmPrin.getBtnSalirPrincipal()) {
            System.exit(0);
        }

 // administrador
        if (e.getSource() == frmMenuAdmin.getMenuItemRegEmpl()) {
            frmMenuAdmin.getEscrito().add(frmRegEmpl);
            frmRegEmpl.setVisible(true);
        }

        if (e.getSource() == frmMenuAdmin.getMenuItemRegClien()) {
            frmMenuAdmin.getEscrito().add(frmRegCli);
            frmRegCli.setVisible(true);
        }

        if (e.getSource() == frmMenuAdmin.getMenuItemRegProd()) {
            frmMenuAdmin.getEscrito().add(frmRegPro);
            frmRegPro.setVisible(true);
        }

        if (e.getSource() == frmMenuAdmin.getMenuItemModClien()) {
            frmMenuAdmin.getEscrito().add(frmConsCli);
            frmConsCli.setVisible(true);
        }

        if (e.getSource() == frmMenuAdmin.getMenuItemGenCot()) { 
            frmMenuAdmin.getEscrito().add(frmFactura);
            frmFactura.setVisible(true);
        }
        
        if (e.getSource() == frmMenuAdmin.getMenuItemConsInventario()) { 
            frmMenuAdmin.getEscrito().add(frmListaPro);
            frmListaPro.setVisible(true);
        }
        
        if (e.getSource() == frmMenuAdmin.getMenuItemSalir()) {
            frmMenuAdmin.dispose();
        }

 // registro de Clientes 
        if (e.getSource() == frmRegCli.getBtnIngClien()) {
          
            
            if (frmRegCli.getTxtIdCliente().getText().length() == 0 || frmRegCli.getTxtDirClien().getText().length() == 0 || frmRegCli.getTxtTelCliente().getText().length() == 0) {
                frmRegCli.getLblVerficarDatos().setText("Ingrese todos los datos del formulario");
            } else {
                try {
                vntAdvertencia.setVisible(true);
                cliente.setId(Long.parseLong(frmRegCli.getTxtIdCliente().getText()));
                cliente.setDireccion(frmRegCli.getTxtDirClien().getText());
                cliente.setTel(Long.parseLong(frmRegCli.getTxtTelCliente().getText()));
                cliente.setNombre(frmRegCli.getTxtNombreCliente().getText());
                cliente.registrar();
                frmRegCli.getLblVerficarDatos().setText("Datos ingresados correctamente");
                
                } catch (NumberFormatException f) {
                    System.out.println("formato de dato ingresado incorrecto"+f);
                    frmRegCli.getLblVerficarDatos().setText("Formato de datos incorrecto");
                }
                
            }

        }

        if (e.getSource() == frmRegCli.getBtnSalirClien()) {
            frmRegCli.nuevaVentana();
            frmRegCli.dispose();
        }

// registrar  empleados 
        if (e.getSource() == frmRegEmpl.getBtnIngresarEmpl()) {
            if (frmRegEmpl.getTxtCedula().getText().length() == 0 || frmRegEmpl.getTxtSueldo().getText().length() == 0 || frmRegEmpl.getTxtUsuarioEmpl().getText().length() == 0 || frmRegEmpl.getTxtPassword().getText().length() == 0 || frmRegEmpl.getCmbCargo().getSelectedItem().toString().length() == 0) {
                frmRegEmpl.getLblValidaRegEmpl().setText("Ingrese todos los datos del formulario");
            } else {
                try {
                    admin.setId(Integer.parseInt(frmRegEmpl.getTxtCedula().getText()));
                admin.setSueldo(Long.parseLong(frmRegEmpl.getTxtSueldo().getText()));
                admin.setCargo(frmRegEmpl.getCmbCargo().getSelectedItem().toString());
                admin.setUsuario(frmRegEmpl.getTxtUsuarioEmpl().getText());
                admin.setClave(frmRegEmpl.getTxtPassword().getText());
                admin.registrar();
                frmRegEmpl.getLblValidaRegEmpl().setText("Datos ingresados correctamente");
                } catch (NumberFormatException f) {
                    System.out.println("formato de dato ingresado incorrecto"+f);
                    frmRegEmpl.getLblValidaRegEmpl().setText("Formato de datos incorrecto");
                }
            }
        }

        if (e.getSource() == frmRegEmpl.getBtnSalirRegEmpl()) {
            frmRegEmpl.nuevaVentana();
            frmRegEmpl.dispose();
        }
//registar Producto

        if (e.getSource() == frmRegPro.getBtnRegisProducto()) {
            if (frmRegPro.getTxtCantidadPro().getText().length() == 0 || frmRegPro.getTxtCodigoProducto().getText().length() == 0 || frmRegPro.getTxtNombreProducto().getText().length() == 0 || frmRegPro.getTxtValorUnitProducto().getText().length() == 0) {
                frmRegPro.getLblVerificarRegPro().setText("Ingrese todos los datos del formulario");
            } else {
                try {
                    producto.setCodigoBarra(Long.parseLong(frmRegPro.getTxtCodigoProducto().getText()));
                producto.setPrecio(Long.parseLong(frmRegPro.getTxtValorUnitProducto().getText()));
                producto.setNombreProducto(frmRegPro.getTxtNombreProducto().getText());
                producto.setCantidad(Integer.parseInt(frmRegPro.getTxtCantidadPro().getText()));
                producto.registrar();
                frmRegPro.getLblVerificarRegPro().setText("Datos ingresados correctamente");
                } catch (NumberFormatException f) {
                    System.out.println("formato de dato ingresado incorrecto"+f);
                    frmRegPro.getLblVerificarRegPro().setText("Formato de datos incorrecto.");
                }  
            }
        }

        
        if (e.getSource() == frmRegPro.getBtnSalirRegiProduc()) {
            frmRegPro.nuevaVentana();
            frmRegPro.dispose();
        }

 //Consultar Cliente
        if (e.getSource() == frmConsCli.getBtnConsultarCliente()) {
            boolean bandera = true;

            for (String arrClien1 : arrClien) {
                String[] textosplit = arrClien1.split(",");
                
                try {
                   long a=Long.parseLong(frmConsCli.getTxtIngresarID().getText());
                if (textosplit[0].equals(frmConsCli.getTxtIngresarID().getText()) && bandera == true) {
                    bandera = false;
                    frmConsCli.getLblImprimeID().setText(textosplit[0]);
                    frmConsCli.getLblImprimirDirec().setText(textosplit[1]);
                    frmConsCli.getLblImprimirTele().setText(textosplit[2]);
                    frmConsCli.getLblImprimirNombre().setText(textosplit[3]);
                    frmConsCli.getLblVerficarDatos().setText("");
                }
                
                if (bandera) {
                frmConsCli.getLblImprimeID().setText("");
                frmConsCli.getLblImprimirDirec().setText("");
                frmConsCli.getLblImprimirTele().setText("");
                frmConsCli.getLblImprimirNombre().setText("");
                frmConsCli.getLblVerficarDatos().setText("Cliente no encontrado");
            }
                
                } catch (NumberFormatException f) {
                    System.out.println("formato de dato ingresado incorrecto"+f);
                    frmConsCli.getLblVerficarDatos().setText("Formato de ID incorrecto.");
                }
                
            }
            
        }

        if (e.getSource() == frmConsCli.getBtnEditarClien()) {
            if ("".equals(frmConsCli.getLblVerficarDatos().getText())) {
              frmEditarCli.setVisible(true);//modificar
            frmEditarCli.getTxtEditarID().setText(frmConsCli.getLblImprimeID().getText());
            frmEditarCli.getTxtEditarDircc().setText(frmConsCli.getLblImprimirDirec().getText());
            frmEditarCli.getTxtEditarTele().setText(frmConsCli.getLblImprimirTele().getText());
            frmEditarCli.getTxtEditarNombre().setText(frmConsCli.getLblImprimirNombre().getText());
            } else {
                frmConsCli.getLblVerficarDatos().setText("No es posible editar");
            }
                    
            
        }

        if (e.getSource() == frmConsCli.getBtnSalirClien()) {
            frmConsCli.nuevaVentana();
            frmConsCli.dispose();
        }

//Editar Cliente 
        if (e.getSource() == frmEditarCli.getBtnEditarClien()) {
            try {
               Lector.remplar("Clientes.txt", frmConsCli.getLblImprimeID().getText() + "," + frmConsCli.getLblImprimirDirec().getText() + "," + frmConsCli.getLblImprimirTele().getText() + "," + frmConsCli.getLblImprimirNombre().getText(), frmEditarCli.getTxtEditarID().getText() + "," + frmEditarCli.getTxtEditarDircc().getText() + "," + frmEditarCli.getTxtEditarTele().getText() + "," + frmEditarCli.getTxtEditarNombre().getText());
            frmEditarCli.getLblVerficarDatos().setText("Registro actualizado con exito"); 
            } catch (FileNotFoundException f) {
                System.out.println("No se encuentra el archivo Clientes"+f);
            }
            
        }

        if (e.getSource() == frmEditarCli.getBtnSalirEditar()) {
            frmEditarCli.nuevaVentana();
            frmEditarCli.dispose();

        }

//Facturación

            //Buscar cliente/ regitrar Cliente
        if (e.getSource() == frmFactura.getBtnBuscarCliente()) {
            boolean bandera = true;
            
            try {
                long a=Long.parseLong(frmFactura.getTxtIngresarID().getText());
                 for (String arrClien1 : arrClien) {
                String[] textosplit = arrClien1.split(",");
                if (textosplit[0].equals(frmFactura.getTxtIngresarID().getText()) && bandera == true) {
                    bandera = false;
                    frmFactura.getLblImprDireccion().setText(textosplit[1]);
                    frmFactura.getLblImpTelefono().setText(textosplit[2]);
                    frmFactura.getLblImprimeNombre().setText(textosplit[3]);
                    frmFactura.getLblVerificarID().setText("");
                }
            }
            if (bandera) {
                frmFactura.getLblImprDireccion().setText("");
                frmFactura.getLblImpTelefono().setText("");
                frmFactura.getLblImprimeNombre().setText("");
                frmFactura.getLblVerificarID().setText("Cliente no encontrado");
            }
                
            } catch (NumberFormatException f) {
                System.out.println("Formato de datos ingresados  incorrectos "+f);
                 frmFactura.getLblVerificarID().setText("Formato de ID  incorrecto");
            }
           
            
        }
        
        if (e.getSource() == frmFactura.getBtnRegistarCliente()) {
            frmFactura.getEscritorio().add(frmRegCli);
            frmRegCli.setVisible(true);
        }
        
            //buscar,consultar y  agregar  producto
        if (e.getSource() == frmFactura.getBtnBuscarProducto()) {
            boolean bandera2 = true;
            
            try {
            long a=Long.parseLong(frmFactura.getTxtCodigoProducto().getText());
            for (String arrProd1 : arrProd) {
                String[] textosplit = arrProd1.split(",");
                if (textosplit[0].equals(frmFactura.getTxtCodigoProducto().getText())) {
                    bandera2 = false;
                    frmFactura.getLblValorUnitario().setText(textosplit[3]);
                    frmFactura.getLblNombreProducto().setText(textosplit[1]);
                    frmFactura.getLblValidaProduc().setText("Cantidad Disponible en Stock: "+textosplit[2]);
                }
            }
            if (bandera2) {
                frmFactura.getLblValorUnitario().setText("");
                frmFactura.getLblCodigoProducto().setText("");
                frmFactura.getLblValidaProduc().setText("Producto no encontrado");
            }    
            } catch (NumberFormatException f) {
                 System.out.println("Formato de datos ingresados  incorrectos "+f);
                 frmFactura.getLblValidaProduc().setText("Formato de codigo incorrecto.");
            }
            
            

        }
        
        if (e.getSource() == frmFactura.getBtnAgregar()) {
            
            try {
             frmFactura.llenarFactura();
            frmFactura.setDatos();
            } catch (  NumberFormatException f) {
             System.out.println("error de formato en Dato ingresado Cantidad factura "+f);
             frmFactura.getLblValidaProduc().setText("Ingrese en Cantidad un dato númerico.");
        }
            
        }
        
        if (e.getSource() == frmFactura.getBtnConsProd()) {
             frmFactura.getEscritorio().add(frmListaPro);
             frmListaPro.setVisible(true);
        }
        
        //calcular
        if (e.getSource() == frmFactura.getBtnCalcular()) {
            try {
                frmFactura.getLblImprimeSubtotal().setText(String.valueOf(frmFactura.calcular()));
            frmFactura.getLblImprimirIva().setText(String.valueOf(frmFactura.calcular() * 0.19));
            frmFactura.getLblImprimirTotal().setText(String.valueOf(frmFactura.calcular() * 1.19));
            } catch (NumberFormatException n) {
                System.out.println(" es Metodo Calcular datos no  numericos"+n);
            }
            
            if (Double.parseDouble(frmFactura.getLblImprimirTotal().getText())==0) {
                frmFactura.getLblVerficarFactura().setText("¡Cuidado! Factura en ceros");
            }
        }

        
        //cotizar/Facturar
        if (e.getSource() == frmFactura.getBtnCotizarFac()) {
          if (frmFactura.getLblImprimeNombre().getText().length() == 0 || frmFactura.getLblImprimirTotal().getText().length() == 0){
              frmFactura.getLblVerficarFactura().setText("Datos Incompletos");
            } else {
                factura.cotizacion(frmFactura);
            }
                
        }

        if (e.getSource() == frmFactura.getBtnFacturar()) {
       
                 
             if (frmFactura.getLblImprimeNombre().getText().length() == 0 || frmFactura.getLblImprimirTotal().getText().length() == 0){
                 frmFactura.getLblVerficarFactura().setText("Datos  de facturación Incompletos");
            } else {
                try {
                     long a=Long.parseLong(frmFactura.getTxtIngresarID().getText());
                     factura.setIdCliente(Long.parseLong(frmFactura.getTxtIngresarID().getText()));
                factura.setFechaCreacion(frmFactura.getLblFecha().getText());
                factura.setNumero(Integer.parseInt(frmFactura.getLblCodFactur().getText()));
                factura.setTotalFactura(Double.parseDouble(frmFactura.getLblImprimirTotal().getText()));
                factura.setInventario(frmFactura.getInv());
                factura.crear(frmFactura);
                 } catch (NumberFormatException f) {
                     System.out.println("error de formato en Dato ingresado Cantidad factura "+f);
                     frmFactura.getLblVerficarFactura().setText("Formato de Datos ingresados incorrectos.");
                 }
                }    
        }
        
      
        if (e.getSource() == frmFactura.getBtnSalirFactura()) {
            frmFactura.nuevaFac();
            frmFactura.dispose();
        }
//ListaProductos
        if (e.getSource() == frmListaPro.getBtnSalirListaProd()) {
            frmListaPro.nuevaVentana();
            frmListaPro.dispose();
        }
        if (e.getSource() == frmListaPro.getBtnBuscarProd()) {
            frmListaPro.buscarProductos(arrProd);
            frmListaPro.setDatos();
            
        }
        
        
        if (e.getSource() == frmListaPro.getBtnTodosProd()) {
            frmListaPro.buscarTodo(arrProd);
            frmListaPro.setDatos();
        }
            
//Vendedor
        if (e.getSource() == frmMenuVendedor.getMenuItemSalir()) {
            frmMenuVendedor.dispose();
        }
        if (e.getSource() == frmMenuVendedor.getMenuItemRegClien()) {
            frmMenuVendedor.getEscritorio().add(frmRegCli);
            frmRegCli.setVisible(true);
        }

        if (e.getSource() == frmMenuVendedor.getMenuItemConsultarCliente()) {
            frmMenuVendedor.getEscritorio().add(frmConsCli);
            frmConsCli.setVisible(true);
        }

        if (e.getSource() == frmMenuVendedor.getMenuItemConsultaProd()) {
            frmMenuVendedor.getEscritorio().add(frmListaPro);
            frmListaPro.setVisible(true);
        }

        if (e.getSource() == frmMenuVendedor.getMenuItemCreaFac()) {
            frmMenuVendedor.getEscritorio().add(frmFactura);
            frmFactura.setVisible(true);
        }
        
 //Ventana Advertencia 
        
        if ( vntAdvertencia.getBtnAceptar()== e.getSource()) {
            
            frmFactura.dispose();
        }
        
        if ( vntAdvertencia.getBtnCancelar()==e.getSource()) {
            
            frmFactura.dispose();
        }

    }

}
