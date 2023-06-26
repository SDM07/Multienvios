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
public class MercanciasDAO {
    private Mercancia objMerca;

    public MercanciasDAO(Mercancia objMerca) {
        this.objMerca = objMerca;
    }
    
    public MercanciasDAO() {
        this.objMerca = new Mercancia();
    }

    public Mercancia getObjMerca() {
        return objMerca;
    }

    public void setObjMerca(Mercancia objMerca) {
        this.objMerca = objMerca;
    }
    public DefaultTableModel consulta(){
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD objCon= new ConexionBD();
        try {
            objCon.conectar();
            Statement consulta = objCon.getConexion().createStatement();
            ResultSet datos= consulta.executeQuery("select * from mercancias");
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
    
    public String insertar2(){
        String mensaje="";
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into mercancias values(?,?,?,?)";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.setString(1,objMerca.getSerial());
            consulta.setString(2,objMerca.getDescripcion());
            consulta.setInt(3,objMerca.getCant());
            consulta.setDouble(4,objMerca.getPeso());
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
