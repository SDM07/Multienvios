/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.EnterFormatException;
import modelo.*;
import persistencia.*;
import vista.*;

public class Controlador implements ActionListener{

    private MercanciasDAO MerDAO;
    private EnviosDAO EnvDAO;
    private Factura objFac;
    private Recaudo objRec;
    private Mercancia objMer;
    private Conexion objConex;
    private frmPrincipal frmPrin;
    private frmRegistrar frmEnv;
    private frmConBD frmCondb;
    private frmMercBD frmMerdb;
    private ArrayList<Factura> listaFac;

    public Controlador(MercanciasDAO MerDAO, EnviosDAO EnvDAO, Factura objFac, Recaudo objRec, Mercancia objMer, Conexion objConex, frmPrincipal frmPrin, frmRegistrar frmEnv,frmConBD frmCondb, frmMercBD frmMerbd, ArrayList<Factura> listaFac ) {
        this.MerDAO = MerDAO;
        this.EnvDAO = EnvDAO;
        this.objFac = objFac;
        this.objRec = objRec;
        this.objMer = objMer;
        this.objConex = objConex;
        this.frmPrin = frmPrin;
        this.frmEnv = frmEnv;
        this.frmCondb = frmCondb;
        this.frmMerdb = frmMerbd;
        this.listaFac = new ArrayList<Factura>();
        iniciarCompEnv();
        iniciarComponentePrinc();
    }

    public Controlador() throws IOException {
        this.MerDAO = new MercanciasDAO();
        this.EnvDAO = new EnviosDAO();
        this.objFac = new Factura();
        this.objRec = new Recaudo();
        this.objMer = new Mercancia();
        this.objConex = new Conexion();
        this.frmPrin = new frmPrincipal();
        this.frmEnv = new frmRegistrar();
        this.frmCondb = new frmConBD();
        this.frmMerdb = new frmMercBD();
        this.listaFac = new ArrayList<Factura>();
        iniciarCompEnv();
        iniciarComponentePrinc();
    }
    
    public void iniciar(){
        frmPrin.setTitle("MULTI-ENVIOS");
        frmPrin.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(frmPrin.getOpc_ConsulCliente() == evento.getSource()){
            frmConsulCliente frmConsulCliente1 = new frmConsulCliente();
            frmPrin.getDesktopPane().add(frmConsulCliente1);
            try {
                objConex = new Conexion();
                frmConsulCliente1.getTxt_ConsulClien().append(objConex.leerDatos("archivos/clientes.txt"));
                frmConsulCliente1.setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frmPrin, "Error en conexion..."+ ex.toString());
            }
        }
        
        if(frmPrin.getOpc_ConsulEnvio()== evento.getSource()){
            frmCondb = new frmConBD();
            frmPrin.getDesktopPane().add(frmCondb);
            iniciarCompEnv();
            consultaBDenTable("envios", frmCondb.getjTable_datosBD());
            frmCondb.setVisible(true);
        }
        
        if(frmPrin.getOpc_ConsulMerc() == evento.getSource()){
            frmMerdb = new frmMercBD();
            frmPrin.getDesktopPane().add(frmMerdb);
            iniciarCompEnv();
            consultaBDMercenTable("mercancias", frmMerdb.getjTable_ConMerBD());
            frmMerdb.setVisible(true);
        }
        
        if(frmPrin.getOpc_RegEnvio()== evento.getSource()){
            frmEnv = new frmRegistrar();
            frmPrin.getDesktopPane().add(frmEnv);
            iniciarCompEnv();
            frmEnv.setVisible(true);
            frmEnv.getLbl_fecha().setText(objFac.getFecha().toString());
            frmEnv.getLbl_numFactura().setText(objFac.getNumFac().toString());
            frmEnv.getLbl_serialMerca().setText(objMer.getSerial().toString());
            Aereo objA = new Aereo();
            Terrestre objT = new Terrestre();
            switch(frmEnv.getCmb_tipoEnvio().getSelectedIndex()){
                case 0:{
                    frmEnv.getLbl_numeroEnvio().setText(objA.getNumEnv().toString());
                    break;
                }
                case 1:{
                    frmEnv.getLbl_numeroEnvio().setText(objT.getNumEnv().toString());
                    break;
                }
            }
        }
        
        /*if(frmEnv.getBtn_registrar()== evento.getSource()){
            try {
                    Persona cliente = new Persona(
                    frmEnv.getTxt_idCliente().getText(), 
                    frmEnv.getTxt_nombreCliente().getText(),
                    frmEnv.getTxt_telCliente().getText());
                        objConex = new Conexion();
                        objConex.EscribeDatos("archivos/clientes.txt", cliente.adRegistrar());
                        JOptionPane.showMessageDialog(frmPrin, "Datos Registrados: \n" + cliente.toString());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frmPrin, "Error en conexion..."+ ex.toString());
            }
        }*/
        
        if(frmEnv.getBtn_registrar() == evento.getSource()){
            try {
                    Persona cliente = new Persona(
                        frmEnv.getTxt_idCliente().getText(), 
                        frmEnv.getTxt_nombreCliente().getText(),
                        frmEnv.getTxt_telCliente().getText());
                        objConex = new Conexion();
                        objConex.EscribeDatos("archivos/clientes.txt", cliente.adRegistrar());
                        JOptionPane.showMessageDialog(frmPrin, "Datos Registrados: \n" + cliente.toString());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frmPrin, "Error en conexion..."+ ex.toString());
            } 
            
            switch(frmEnv.getCmb_tipoEnvio().getSelectedIndex()){
                    case 0:{
                        Persona destinatario = new Persona(
                                frmEnv.getTxt_idDestina().getText(), 
                                frmEnv.getTxt_nombreDestina().getText(),
                                frmEnv.getTxt_telDestina().getText());
                        Mercancia datosMa = new Mercancia();
                                datosMa.setSerial(frmEnv.getLbl_serialMerca().getText());
                                datosMa.setDescripcion(frmEnv.getjTArea_descripMerca().getText());
                                datosMa.setCant(Integer.parseInt(frmEnv.getTxt_cantidadMerca().getText()));
                                datosMa.setPeso(Double.parseDouble(frmEnv.getTxt_pse_Merca().getText()));
                                agregarMercanciaTable(datosMa, frmMerdb.getjTable_ConMerBD());
                                this.MerDAO.setObjMerca(datosMa);
                                JOptionPane.showMessageDialog(frmMerdb, this.MerDAO.insertar2());
                        Aereo objA = new Aereo();
                                objA.setNumEnv(frmEnv.getLbl_numeroEnvio().getText());
                                objA.setListMer(datosMa);
                                objA.setOrigen(frmEnv.getTxt_origenEnvio().getText());
                                objA.setDestino(frmEnv.getTxt_destinoEnvio().getText());
                                objA.setTipo(frmEnv.getCmb_tipoEnvio().getSelectedItem().toString());
                                objA.setDestinatario(destinatario);
                                agregarEnvioTable(objA, frmCondb.getjTable_datosBD());
                                this.EnvDAO.setObjEnvio(objA);
                                JOptionPane.showMessageDialog(frmCondb, this.EnvDAO.insertar());
                                //objFac.getCliente();
                                objFac.getListEnvio().add(objA);
                                objRec.getListaFac().add(objFac);
                                frmEnv.getBtn_PDF().setEnabled(true);
                        break;
                    }
                    case 1:{
                        Persona destinatario = new Persona(
                                frmEnv.getTxt_idDestina().getText(), 
                                frmEnv.getTxt_nombreDestina().getText(),
                                frmEnv.getTxt_telDestina().getText());
                        Mercancia datosMe = new Mercancia();
                                datosMe.setSerial(frmEnv.getLbl_serialMerca().getText());
                                datosMe.setDescripcion(frmEnv.getjTArea_descripMerca().getText());
                                datosMe.setCant(Integer.parseInt(frmEnv.getTxt_cantidadMerca().getText()));
                                datosMe.setPeso(Double.parseDouble(frmEnv.getTxt_pse_Merca().getText()));
                                agregarMercanciaTable(datosMe, frmMerdb.getjTable_ConMerBD());
                                this.MerDAO.setObjMerca(datosMe);
                                JOptionPane.showMessageDialog(frmMerdb, this.MerDAO.insertar2());
                        Terrestre objT = new Terrestre();
                                objT.setNumEnv(frmEnv.getLbl_numeroEnvio().getText());
                                objT.setListMer(datosMe);
                                objT.setOrigen(frmEnv.getTxt_origenEnvio().getText());
                                objT.setDestino(frmEnv.getTxt_destinoEnvio().getText());
                                objT.setTipo(frmEnv.getCmb_tipoEnvio().getSelectedItem().toString());
                                objT.setDestinatario(destinatario);
                                agregarEnvioTable(objT, frmCondb.getjTable_datosBD());
                                this.EnvDAO.setObjEnvio(objT);
                                JOptionPane.showMessageDialog(frmCondb, this.EnvDAO.insertar());
                                objFac.getListEnvio().add(objT);
                                objRec.getListaFac().add(objFac);
                                frmEnv.getBtn_PDF().setEnabled(true);
                        break;
                    }
                }
            /*try {
                frmEnv.setClosed(true);
            } catch (PropertyVetoException ex) {
                System.err.println("Closing Exception");
            }*/
        }
        
        if(frmEnv.getBtn_PDF() == evento.getSource()){
            ArchPdf archivo= new ArchPdf();
            if(objRec.getListaFac().get(objRec.getListaFac().size()-1)!=null){
            archivo.crear_PDF(objRec.getListaFac().get(objRec.getListaFac().size()-1));
            }
            else{
            JOptionPane.showMessageDialog(frmPrin, "No hay cliente registrado");
            }
        }
        
        /*if(frmEnv.getBtn_registrar()== evento.getSource()){
            try {
                Mercancia datos = new Mercancia(
                    frmEnv.getLbl_serialMerca().getText(), 
                    frmEnv.getjTArea_descripMerca().getText(), 
                    Integer.parseInt(frmEnv.getTxt_cantidadMerca().getText()), 
                    Double.parseDouble(frmEnv.getTxt_pse_Merca().getText()));
                objConex = new Conexion();
                objConex.EscribeDatos("archivos/mercancias.txt", datos.addRegistro());
                JOptionPane.showMessageDialog(frmPrin, "Datos Registrados \n" + datos.toString());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frmPrin, "Error en conexion..."+ ex.toString());
            }
            frmEnv.setLbl_serialMerca.settext();
        }
        
        if(frmEnv.getBtn_registrar()== evento.getSource()){
            Aereo objAe= new Aereo();
            Terrestre objTe = new Terrestre();
            try{
                switch(frmEnv.getCmb_tipoEnvio().getSelectedIndex()){
                    case 0:{
                        Persona destinatario = new Persona(
                                frmEnv.getTxt_idDestina().getText(), 
                                frmEnv.getTxt_nombreDestina().getText(),
                                frmEnv.getTxt_telDestina().getText());
                        Aereo objA = new Aereo(
                                frmEnv.getLbl_numFactura().getText(), 
                                objAe.getListMer(),
                                frmEnv.getTxt_origenEnvio().getText(),
                                frmEnv.getTxt_destinoEnvio().getText(),
                                frmEnv.getCmb_tipoEnvio().getSelectedItem().toString(),
                                destinatario);
                        objRec.getListaFac().add(objFac);
                        objConex = new Conexion();
                        objConex.EscribeDatos("archivos/envios.txt", objA.adRegistrar());
                        JOptionPane.showMessageDialog(frmPrin, "Datos Registrados \n" + objA.toString());
                        break;
                    }
                    case 1:{
                        Persona destinatario = new Persona(
                                frmEnv.getTxt_idDestina().getText(), 
                                frmEnv.getTxt_nombreDestina().getText(),
                                frmEnv.getTxt_telDestina().getText());
                        Terrestre objT = new Terrestre(
                                frmEnv.getLbl_numFactura().getText(), 
                                objTe.getListMer(),
                                frmEnv.getTxt_origenEnvio().getText(),
                                frmEnv.getTxt_destinoEnvio().getText(),
                                frmEnv.getCmb_tipoEnvio().getSelectedItem().toString(),
                                destinatario);
                        objRec.getListaFac().add(objFac);
                        objConex = new Conexion();
                        objConex.EscribeDatos("archivos/envios.txt", objT.adRegistrar());
                        JOptionPane.showMessageDialog(frmPrin, "Datos Registrados \n" + objT.toString());
                        break;
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frmPrin, "Error en conexion..."+ ex.toString());
            }
        }*/
        
        if(evento.getSource().equals(frmPrin.getOpcSalida())){
            int Resp=JOptionPane.showConfirmDialog(frmPrin, "Desea Salir?");
            if(Resp==JOptionPane.YES_OPTION){
              System.exit(1);
            }
            /*if else(Resp==JOptionPane.CANCEL_OPTION){
                System.
            }*/
        }
    }
    
    public void iniciarComponentePrinc(){
        frmPrin.getOpc_RegEnvio().addActionListener(this);
        frmPrin.getOpc_ConsulCliente().addActionListener(this);
        frmPrin.getOpc_ConsulEnvio().addActionListener(this);
        frmPrin.getOpc_ConsulMerc().addActionListener(this);
        frmPrin.getOpcSalida().addActionListener(this);
    }
    
    public void iniciarCompEnv(){
        frmEnv.getBtn_registrar().addActionListener(this);
        frmEnv.getBtn_PDF().setEnabled(false);
        frmEnv.getBtn_PDF().addActionListener(this);
    }
    
    public void datosMerca() throws IOException{
        objConex = new Conexion();
        objConex.leerDatos("archivos/mercancias.txt");
    }
    
    private void consultaBDenTable(String registro, JTable tbl){
        DefaultTableModel modelo =(DefaultTableModel) tbl.getModel();
        int filas=tbl.getRowCount();
        for (int i = 0 ; filas>i ; i++) {
            modelo.removeRow(0);
        }
        if(registro.equals("envios"))
        {
            EnviosDAO objE = new EnviosDAO();
            modelo = objE.consulta();
            tbl.setModel(modelo);
        }
    }
    
    private void consultaBDMercenTable(String registro, JTable tbl){
        DefaultTableModel modelo =(DefaultTableModel) tbl.getModel();
        int filas=tbl.getRowCount();
        for (int i = 0 ; filas>i ; i++) {
            modelo.removeRow(0);
        }
        if(registro.equals("mercancias"))
        {
            MercanciasDAO objM = new MercanciasDAO();
            modelo = objM.consulta();
            tbl.setModel(modelo);
        }
    }
    
    public void agregarEnvioTable(Envio env, JTable tabla){
        Object datos[] = {
            env.getNumEnv(),
            env.getListMer(),
            env.getOrigen(),
            env.getDestino(),
            env.getTipo(),
            env.getDestinatario()};
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        plantilla.addRow(datos);
        }
    
    public void agregarMercanciaTable(Mercancia mer, JTable tabla){
        Object datos[] = {
            mer.getSerial(),
            mer.getDescripcion(),
            mer.getCant(),
            mer.getPeso()};
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        plantilla.addRow(datos);
        }
    
    public void limpiarTextos(JDesktopPane principal){
        for (Object limpiar : principal.getComponents()) {
            //((JTextField)limpiar).setText("");
            ((JLabel)limpiar).setText("");
        }
    }
}
