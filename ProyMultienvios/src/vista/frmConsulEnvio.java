/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author sebas
 */
public class frmConsulEnvio extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmConsulEnvio
     */
    public frmConsulEnvio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_ConsulEnvio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_ConsulEnvio = new javax.swing.JTextArea();

        setTitle("Consulta de Envios");

        lbl_ConsulEnvio.setText("Registro de datos:");

        txtArea_ConsulEnvio.setColumns(20);
        txtArea_ConsulEnvio.setRows(5);
        jScrollPane1.setViewportView(txtArea_ConsulEnvio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_ConsulEnvio)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_ConsulEnvio)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLbl_ConsulEnvio() {
        return lbl_ConsulEnvio;
    }

    public void setLbl_ConsulEnvio(JLabel lbl_ConsulEnvio) {
        this.lbl_ConsulEnvio = lbl_ConsulEnvio;
    }

    public JTextArea getTxtArea_ConsulEnvio() {
        return txtArea_ConsulEnvio;
    }

    public void setTxtArea_ConsulEnvio(JTextArea txtArea_ConsulEnvio) {
        this.txtArea_ConsulEnvio = txtArea_ConsulEnvio;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_ConsulEnvio;
    private javax.swing.JTextArea txtArea_ConsulEnvio;
    // End of variables declaration//GEN-END:variables
}
