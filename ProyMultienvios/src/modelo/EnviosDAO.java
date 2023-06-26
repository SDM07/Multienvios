/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.ConexionBD;

/**
 *
 * @author sebas
 */
public class EnviosDAO {
    private Envio objEnvio;

    public EnviosDAO(Envio objEnvio) {
        this.objEnvio = objEnvio;
    }
    
    public EnviosDAO() {
        this.objEnvio = new Envio() {
            @Override
            public double totalpesoM() {
                return 0;
            }

            @Override
            public String tipo() {
                return "";
            }

            @Override
            public double valorEnv() {
                return 0;
            }
        };
        
    }

    public Envio getObjEnvio() {
        return objEnvio;
    }

    public void setObjEnvio(Envio objEnvio) {
        this.objEnvio = objEnvio;
    }
    
    public DefaultTableModel consulta(){
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD objCon= new ConexionBD();
        try {
            objCon.conectar();
            Statement consulta = objCon.getConexion().createStatement();
            ResultSet datos= consulta.executeQuery("select * from envios");
            ResultSetMetaData campos= datos.getMetaData();
            for (int i = 1; i <= campos.getColumnCount(); i++){
              plantilla.addColumn(campos.getColumnName(i));           
            }
            while (datos.next()){
            Object[] fila = new Object[campos.getColumnCount()];
            for (int i = 0; i < campos.getColumnCount(); i++){
              fila[i]=datos.getObject(i+1);
             }
             plantilla.addRow(fila);
            }
            datos.close();
            objCon.getConexion().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return plantilla;
    }
    
    public String insertar(){
        String mensaje="";
        Factura objFac = new Factura();
        Mercancia objMer = new Mercancia();
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into envios values(?,?,?,?,?,?)";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.setString(1,objFac.getNumFac());
            consulta.setString(2,objMer.toString());
            consulta.setString(3,objEnvio.getOrigen());
            consulta.setString(4,objEnvio.getDestino());
            consulta.setString(5,objEnvio.getTipo());
            consulta.setString(6,objEnvio.getDestinatario().toString());
            consulta.execute();
            mensaje="Registro BD exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar en BD...\n"+ex;
        }
      return mensaje;  
    }
}
