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
public class frmConsulMerc extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmConsulMerc
     */
    public frmConsulMerc() {
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

        lbl_ConsulMerc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_ConsulMerc = new javax.swing.JTextArea();

        setTitle("Consulta de Mercancia");

        lbl_ConsulMerc.setText("Registro de Datos:");

        txtArea_ConsulMerc.setColumns(20);
        txtArea_ConsulMerc.setRows(5);
        jScrollPane1.setViewportView(txtArea_ConsulMerc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_ConsulMerc)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_ConsulMerc)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLbl_ConsulMerc() {
        return lbl_ConsulMerc;
    }

    public void setLbl_ConsulMerc(JLabel lbl_ConsulMerc) {
        this.lbl_ConsulMerc = lbl_ConsulMerc;
    }

    public JTextArea getTxtArea_ConsulMerc() {
        return txtArea_ConsulMerc;
    }

    public void setTxtArea_ConsulMerc(JTextArea txtArea_ConsulMerc) {
        this.txtArea_ConsulMerc = txtArea_ConsulMerc;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_ConsulMerc;
    private javax.swing.JTextArea txtArea_ConsulMerc;
    // End of variables declaration//GEN-END:variables
}
