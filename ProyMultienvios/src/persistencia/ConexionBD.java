/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sonia Pinzón
 */
public class ConexionBD {
    private Connection conexion;
    private String bd, usuario, clave, mensaje;
    public ConexionBD(Connection conexion, String bd, String usuario, String clave, String mensaje) {
        this.conexion = conexion;
        this.bd = bd;
        this.usuario = usuario;
        this.clave = clave;
        this.mensaje = mensaje;
    }
     public ConexionBD() {
        this.conexion = null;
        this.bd = "multienvios";
        this.usuario = "root";
        this.clave = "";
        this.mensaje = "";
    }
    public void conectar(){
       try {
            Class.forName("com.mysql.jdbc.Driver");
            String ruta= "jdbc:mysql://localhost/"+bd;
            conexion=DriverManager.getConnection(ruta,usuario,clave);
            mensaje= "Conexión exitosa a Base de datos " + bd;
       } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver no encontrado...");
       }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al intentar conectar BD: "+ bd +"\n"+ex);
       }
    }        
    public Connection getConexion() {
        return conexion;
    }
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }    
}
