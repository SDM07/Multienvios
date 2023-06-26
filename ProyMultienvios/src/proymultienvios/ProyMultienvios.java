/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proymultienvios;

import controlador.Controlador;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class ProyMultienvios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Controlador objC = new Controlador();
        objC.iniciar();
    }
    
}
