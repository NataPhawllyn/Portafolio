/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class RegistrarProducto extends javax.swing.JInternalFrame {

    
    
    public RegistrarProducto() {
        initComponents();
    }

    public void nuevaVentana(){
        lblVerificarRegPro.setText("");
        txtCantidadPro.setText("");
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtValorUnitProducto.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomProd = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        lblValorPro = new javax.swing.JLabel();
        txtValorUnitProducto = new javax.swing.JTextField();
        lblCodigoPro = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        btnRegisProducto = new javax.swing.JButton();
        btnSalirRegiProduc = new javax.swing.JButton();
        lblcantidadProd = new javax.swing.JLabel();
        txtCantidadPro = new javax.swing.JTextField();
        lblVerificarRegPro = new javax.swing.JLabel();

        setTitle("Registro de producto nuevo");

        lblNomProd.setText("Nombre producto");

        lblValorPro.setText("Valor unitario");

        lblCodigoPro.setText("Código de barras ");

        btnRegisProducto.setText("Registrar");

        btnSalirRegiProduc.setText("Salir");
        btnSalirRegiProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirRegiProducActionPerformed(evt);
            }
        });

        lblcantidadProd.setText("Cantidad En Stock");

        lblVerificarRegPro.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnRegisProducto)
                        .addGap(35, 35, 35)
                        .addComponent(btnSalirRegiProduc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomProd)
                            .addComponent(lblValorPro)
                            .addComponent(lblCodigoPro)
                            .addComponent(lblcantidadProd))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreProducto)
                            .addComponent(txtValorUnitProducto)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(txtCantidadPro)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lblVerificarRegPro, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNomProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCodigoPro))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorUnitProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcantidadProd)
                    .addComponent(txtCantidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVerificarRegPro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegisProducto)
                    .addComponent(btnSalirRegiProduc))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirRegiProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirRegiProducActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirRegiProducActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegisProducto;
    private javax.swing.JButton btnSalirRegiProduc;
    private javax.swing.JLabel lblCodigoPro;
    private javax.swing.JLabel lblNomProd;
    private javax.swing.JLabel lblValorPro;
    private javax.swing.JLabel lblVerificarRegPro;
    private javax.swing.JLabel lblcantidadProd;
    private javax.swing.JTextField txtCantidadPro;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtValorUnitProducto;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtNombreProducto() {
        return txtNombreProducto;
    }

    public void setTxtNombreProducto(JTextField txtNombreProducto) {
        this.txtNombreProducto = txtNombreProducto;
    }

    public JTextField getTxtValorUnit() {
        return txtValorUnitProducto;
    }

    public void setTxtValorUnit(JTextField txtValorUnit) {
        this.txtValorUnitProducto = txtValorUnit;
    }

    public JButton getBtnRegisProducto() {
        return btnRegisProducto;
    }

    public void setBtnRegisProducto(JButton btnRegisProducto) {
        this.btnRegisProducto = btnRegisProducto;
    }

    public JButton getBtnSalirRegiProduc() {
        return btnSalirRegiProduc;
    }

    public void setBtnSalirRegiProduc(JButton btnSalirRegiProduc) {
        this.btnSalirRegiProduc = btnSalirRegiProduc;
    }

    public JTextField getTxtCodigoProducto() {
        return txtCodigoProducto;
    }

    public void setTxtCodigoProducto(JTextField txtCodigoProducto) {
        this.txtCodigoProducto = txtCodigoProducto;
    }

    public JTextField getTxtValorUnitProducto() {
        return txtValorUnitProducto;
    }

    public void setTxtValorUnitProducto(JTextField txtValorUnitProducto) {
        this.txtValorUnitProducto = txtValorUnitProducto;
    }

    public JLabel getLblVerificarRegPro() {
        return lblVerificarRegPro;
    }

    public void setLblVerificarRegPro(JLabel lblVerificarRegPro) {
        this.lblVerificarRegPro = lblVerificarRegPro;
    }

    public JTextField getTxtCantidadPro() {
        return txtCantidadPro;
    }

    public void setTxtCantidadPro(JTextField txtCantidadPro) {
        this.txtCantidadPro = txtCantidadPro;
    }


}
