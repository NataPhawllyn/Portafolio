
package vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author nataly
 */
public class Facturación extends javax.swing.JInternalFrame {
    
    DefaultTableModel dtmFactura = new DefaultTableModel();
    public ArrayList<Inventario> inv = new ArrayList<>();
    Calendar fecha = new GregorianCalendar();
    int numFactuta;

    public Facturación() {
        initComponents();
        setModelo();
        fecha();
    }

    public void llenarFactura()throws  NumberFormatException{
        String producto = lblNombreProducto.getText();
        String valUnit = lblValorUnitario.getText();
        String Cant = txtCantidadProducto.getText();
        String codigo = txtCodigoProducto.getText();
        Inventario Inven = new Inventario(producto, Integer.parseInt(Cant), Long.parseLong(valUnit),Long.parseLong(codigo));
            inv.add(Inven);
           
    }

    private void setModelo() {
        String[] cabecera = {"#", "Cantidad","Descripción", "Valor unitario","Valor total"};
        dtmFactura.setColumnIdentifiers(cabecera);
        tblFactura.setModel(dtmFactura);

    }

    public void setDatos() {
        Object[] datos = new Object[dtmFactura.getColumnCount()];
         dtmFactura.setRowCount(0);
         int cont=1;
        for (Inventario inventario : inv) {
            datos[0] = cont;
            datos[1] = inventario.getCantidad();
            datos[2] = inventario.getNombreProducto();
            datos[3] = inventario.getPrecio();
            datos[4] = (inventario.getPrecio()*inventario.getCantidad());
            dtmFactura.addRow(datos);
            cont++;
        }
        tblFactura.setModel(dtmFactura);
    }

    public long calcular()throws  NumberFormatException {
        long subtotal = 0;
        for (Inventario Inv1 : inv) {
            subtotal = subtotal + (Inv1.getCantidad() * Inv1.getPrecio());
        }
        return subtotal;
    }
    
    public void fecha() {
        String fechaComp = Integer.toString(fecha.get(Calendar.DATE)) + "/" + Integer.toString(fecha.get(Calendar.MONTH)+1) + "/" + Integer.toString(fecha.get(Calendar.YEAR));
        lblFecha.setText(fechaComp);
        numFactuta = autoIncremental("Facturas.txt");
        lblCodFactur.setText(Integer.toString(numFactuta));
    }


    public String cargarFactura() {
        String productos = "";
        for (int i = 0; i < inv.size(); i++) {
            if (i == 0) {
                productos =inv.get(i).getNombreProducto() + ";" + inv.get(i).getCantidad();
            } else {
                productos = productos + ";" + inv.get(i).getNombreProducto() + ";" + inv.get(i).getCantidad();

            }
        }
        
        return numFactuta +","+txtIngresarID.getText()+ ","+productos+","+lblImprimirTotal.getText();
    }

    private int autoIncremental(String facturastxt) {
        int numero = 1;
        try {
            InputStream ins = new FileInputStream(facturastxt);
            Scanner obj = new Scanner(ins);
            while (obj.hasNextLine()) {
                numero = numero + 1;
                obj.nextLine();
                
            }
            return numero;
        } catch (FileNotFoundException e) {
        }

        return numero;
    }
    
    public void nuevaFac(){
        fecha();
     lblNombreProducto.setText("");
    lblImpTelefono.setText("");
    lblImprDireccion.setText("");
     lblImprimeNombre.setText("");
    lblImprimeSubtotal.setText("");
     lblImprimirIva.setText("");
     lblImprimirTotal.setText("");
    lblValidaProduc.setText("");
     lblVerficarFactura.setText("");
   lblVerificarID.setText("");
     txtCantidadProducto.setText("");
     txtIngresarID.setText("");
    txtCodigoProducto.setText("");
    lblValorUnitario.setText("");
    lblNombreProducto.setText("");
    dtmFactura.setRowCount(0);  
     inv = new ArrayList<>();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        lblTitulo = new javax.swing.JLabel();
        lblIDCliente = new javax.swing.JLabel();
        txtIngresarID = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        lbldireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblImprDireccion = new javax.swing.JLabel();
        lblImpTelefono = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblImprimeNombre = new javax.swing.JLabel();
        btnRegistarCliente = new javax.swing.JButton();
        lblVerificarID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        lblSubtotal = new javax.swing.JLabel();
        lblImprimeSubtotal = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        lblImprimirIva = new javax.swing.JLabel();
        lblImprimirTotal = new javax.swing.JLabel();
        lblTotalFac = new javax.swing.JLabel();
        btnCotizarFac = new javax.swing.JButton();
        btnFacturar = new javax.swing.JButton();
        lblVerficarFactura = new javax.swing.JLabel();
        btnSalirFactura = new javax.swing.JButton();
        escritorio = new javax.swing.JPanel();
        lblValorUnitario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblValidaProduc = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblCodFactur = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        btnConsProd = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTitulo.setText("Facturación");

        lblIDCliente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblIDCliente.setText("NIT/CC");

        txtIngresarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngresarIDActionPerformed(evt);
            }
        });

        btnBuscarCliente.setText("Buscar Cliente");

        lbldireccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbldireccion.setText("Dirección");

        lblTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTelefono.setText("Teléfono");

        lblImprDireccion.setText(" ");

        lblImpTelefono.setText(" ");

        lblNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");

        btnRegistarCliente.setText("Registrar cliente");
        btnRegistarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarClienteActionPerformed(evt);
            }
        });

        lblVerificarID.setText(" ");

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblFactura.getTableHeader().setReorderingAllowed(false);
        tblFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblFacturaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFactura);
        if (tblFactura.getColumnModel().getColumnCount() > 0) {
            tblFactura.getColumnModel().getColumn(0).setHeaderValue("codigo");
            tblFactura.getColumnModel().getColumn(1).setHeaderValue("producto");
            tblFactura.getColumnModel().getColumn(2).setHeaderValue("Cantidad");
            tblFactura.getColumnModel().getColumn(3).setHeaderValue("Valor/ und");
            tblFactura.getColumnModel().getColumn(4).setHeaderValue("Total");
        }

        lblSubtotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblSubtotal.setText("Subtotal");

        lblImprimeSubtotal.setText(" ");

        lblIva.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblIva.setText("IVA 19%");

        lblImprimirIva.setText(" ");

        lblImprimirTotal.setText(" ");

        lblTotalFac.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblTotalFac.setText("TOTAL");

        btnCotizarFac.setText("Cotizar");

        btnFacturar.setText("Factura");

        lblVerficarFactura.setText(" ");

        btnSalirFactura.setText("Salir");
        btnSalirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Codigo Producto");

        jLabel2.setText("Valor Unitario");

        jLabel3.setText("Nombre");

        jLabel4.setText("Cantidad");

        btnBuscarProducto.setText("Buscar Producto");

        btnAgregar.setText("Agregar");

        btnCalcular.setText("Calcular");

        jLabel6.setText("ID Factura");

        jLabel7.setText("Fecha");

        btnConsProd.setText("Ver lista  de productos");
        btnConsProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(lblVerficarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)))
                                        .addComponent(lblImprimirTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnCalcular)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCotizarFac)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnFacturar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSalirFactura)
                                                .addGap(144, 144, 144))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblCodFactur, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblTelefono)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lblImpTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(33, 33, 33)
                                                        .addComponent(lbldireccion)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblImprDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(30, 30, 30)
                                                        .addComponent(lblVerificarID, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jLabel1)
                                                                    .addComponent(jLabel2)
                                                                    .addComponent(jLabel3)
                                                                    .addComponent(jLabel4))
                                                                .addGap(44, 44, 44)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(lblValorUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(lblNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(txtCodigoProducto)
                                                                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addComponent(lblValidaProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(27, 27, 27)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(btnBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(btnConsProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblNombre)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lblImprimeNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblIDCliente)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtIngresarID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btnBuscarCliente)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btnRegistarCliente)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(13, 13, 13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(274, 274, 274)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblIva, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblImprimirIva, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblImprimeSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(btnAgregar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblTitulo)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(lblCodFactur, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblIDCliente)
                                    .addComponent(txtIngresarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarCliente)
                                    .addComponent(btnRegistarCliente))
                                .addGap(3, 3, 3)
                                .addComponent(lblVerificarID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre)
                                    .addComponent(lblImprimeNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbldireccion)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblImprDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblImpTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarProducto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addComponent(btnConsProd))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValidaProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblSubtotal)
                                            .addComponent(lblImprimeSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblIva)
                                            .addComponent(lblImprimirIva, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblTotalFac)
                                            .addComponent(lblImprimirTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnAgregar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnFacturar)
                                    .addComponent(btnCotizarFac)
                                    .addComponent(btnSalirFactura)
                                    .addComponent(btnCalcular)))
                            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lblVerficarFactura)))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIngresarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngresarIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngresarIDActionPerformed

    private void btnRegistarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistarClienteActionPerformed

    private void btnSalirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirFacturaActionPerformed
        
    }//GEN-LAST:event_btnSalirFacturaActionPerformed

    private void tblFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblFacturaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblFacturaKeyPressed

    private void btnConsProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsProdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnConsProd;
    private javax.swing.JButton btnCotizarFac;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnRegistarCliente;
    private javax.swing.JButton btnSalirFactura;
    private javax.swing.JPanel escritorio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodFactur;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIDCliente;
    private javax.swing.JLabel lblImpTelefono;
    private javax.swing.JLabel lblImprDireccion;
    private javax.swing.JLabel lblImprimeNombre;
    private javax.swing.JLabel lblImprimeSubtotal;
    private javax.swing.JLabel lblImprimirIva;
    private javax.swing.JLabel lblImprimirTotal;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotalFac;
    private javax.swing.JLabel lblValidaProduc;
    private javax.swing.JLabel lblValorUnitario;
    private javax.swing.JLabel lblVerficarFactura;
    private javax.swing.JLabel lblVerificarID;
    private javax.swing.JLabel lbldireccion;
    private javax.swing.JTable tblFactura;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtIngresarID;
    // End of variables declaration//GEN-END:variables
   
    
    
    public JButton getBtnBuscarCliente() {
        return btnBuscarCliente;
    }

    public void setBtnBuscarCliente(JButton btnBuscarCliente) {
        this.btnBuscarCliente = btnBuscarCliente;
    }

    public JButton getBtnCotizarFac() {
        return btnCotizarFac;
    }

    public void setBtnCotizarFac(JButton btnCotizarFac) {
        this.btnCotizarFac = btnCotizarFac;
    }

    public JButton getBtnFacturar() {
        return btnFacturar;
    }

    public void setBtnFacturar(JButton btnFacturar) {
        this.btnFacturar = btnFacturar;
    }

    public JLabel getLblImpTelefono() {
        return lblImpTelefono;
    }

    public void setLblImpTelefono(JLabel lblImpTelefono) {
        this.lblImpTelefono = lblImpTelefono;
    }

    public JLabel getLblImprDireccion() {
        return lblImprDireccion;
    }

    public void setLblImprDireccion(JLabel lblImprDireccion) {
        this.lblImprDireccion = lblImprDireccion;
    }

    public JLabel getLblImprimeNombre() {
        return lblImprimeNombre;
    }

    public void setLblImprimeNombre(JLabel lblImprimeNombre) {
        this.lblImprimeNombre = lblImprimeNombre;
    }

    public JLabel getLblImprimeSubtotal() {
        return lblImprimeSubtotal;
    }

    public void setLblImprimeSubtotal(JLabel lblImprimeSubtotal) {
        this.lblImprimeSubtotal = lblImprimeSubtotal;
    }

    public JLabel getLblImprimirIva() {
        return lblImprimirIva;
    }

    public void setLblImprimirIva(JLabel lblImprimirIva) {
        this.lblImprimirIva = lblImprimirIva;
    }

    public JLabel getLblImprimirTotal() {
        return lblImprimirTotal;
    }

    public void setLblImprimirTotal(JLabel lblImprimirTotal) {
        this.lblImprimirTotal = lblImprimirTotal;
    }

    public JLabel getLblVerficarFactura() {
        return lblVerficarFactura;
    }

    public void setLblVerficarFactura(JLabel lblVerficarFactura) {
        this.lblVerficarFactura = lblVerficarFactura;
    }

    public JLabel getLblVerificarID() {
        return lblVerificarID;
    }

    public void setLblVerificarID(JLabel lblVerificarID) {
        this.lblVerificarID = lblVerificarID;
    }

    public JTable getTblFactura() {
        return tblFactura;
    }

    public void setTblFactura(JTable tblFactura) {
        this.tblFactura = tblFactura;
    }

    public JTextField getTxtIngresarID() {
        return txtIngresarID;
    }

    public void setTxtIngresarID(JTextField txtIngresarID) {
        this.txtIngresarID = txtIngresarID;
    }

    public JButton getBtnRegistarCliente() {
        return btnRegistarCliente;
    }

    public void setBtnRegistarCliente(JButton btnRegistarCliente) {
        this.btnRegistarCliente = btnRegistarCliente;
    }

    public JButton getBtnSalirFactura() {
        return btnSalirFactura;
    }

    public void setBtnSalirFactura(JButton btnSalirFactura) {
        this.btnSalirFactura = btnSalirFactura;
    }

    public JPanel getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JPanel escritorio) {
        this.escritorio = escritorio;
    }

    public JLabel getLblCodigoProducto() {
        return lblNombreProducto;
    }

    public void setLblCodigoProducto(JLabel lblCodigoProducto) {
        this.lblNombreProducto = lblCodigoProducto;
    }

    public JTextField getTxtCantidadProducto() {
        return txtCantidadProducto;
    }

    public void setTxtCantidadProducto(JTextField txtCantidadProducto) {
        this.txtCantidadProducto = txtCantidadProducto;
    }

    public JTextField getTxtNombreProducto() {
        return txtCodigoProducto;
    }

    public void setTxtNombreProducto(JTextField txtNombreProducto) {
        this.txtCodigoProducto = txtNombreProducto;
    }

    public JLabel getLblValorUnitario() {
        return lblValorUnitario;
    }

    public void setLblValorUnitario(JLabel lblValorUnitario) {
        this.lblValorUnitario = lblValorUnitario;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnBuscarProducto() {
        return btnBuscarProducto;
    }

    public void setBtnBuscarProducto(JButton btnBuscarProducto) {
        this.btnBuscarProducto = btnBuscarProducto;
    }

    public JLabel getLblValidaProduc() {
        return lblValidaProduc;
    }

    public void setLblValidaProduc(JLabel lblValidaProduc) {
        this.lblValidaProduc = lblValidaProduc;
    }

    public JButton getBtnCalcular() {
        return btnCalcular;
    }

    public void setBtnCalcular(JButton btnCalcular) {
        this.btnCalcular = btnCalcular;
    }

    public JLabel getLblCodFactur() {
        return lblCodFactur;
    }

    public void setLblCodFactur(JLabel lblCodFactur) {
        this.lblCodFactur = lblCodFactur;
    }

    public JLabel getLblFecha() {
        return lblFecha;
    }

    public void setLblFecha(JLabel lblFecha) {
        this.lblFecha = lblFecha;
    }

    public DefaultTableModel getDtmFactura() {
        return dtmFactura;
    }

    public void setDtmFactura(DefaultTableModel dtmFactura) {
        this.dtmFactura = dtmFactura;
    }

    public ArrayList<Inventario> getInv() {
        return inv;
    }

    public void setInv(ArrayList<Inventario> inv) {
        this.inv = inv;
    }

    public JLabel getLblNombreProducto() {
        return lblNombreProducto;
    }

    public void setLblNombreProducto(JLabel lblNombreProducto) {
        this.lblNombreProducto = lblNombreProducto;
    }

    public JTextField getTxtCodigoProducto() {
        return txtCodigoProducto;
    }

    public void setTxtCodigoProducto(JTextField txtCodigoProducto) {
        this.txtCodigoProducto = txtCodigoProducto;
    }

    public JButton getBtnConsProd() {
        return btnConsProd;
    }

    public void setBtnConsProd(JButton btnConsProd) {
        this.btnConsProd = btnConsProd;
    }


    

}
