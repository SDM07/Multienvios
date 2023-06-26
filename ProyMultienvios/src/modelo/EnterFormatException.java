/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Estudiante
 */
public class EnterFormatException extends Exception{
    private int NroE;
    private String msj;
     public EnterFormatException() {
        this.NroE = 100;
        this.msj = "Error de Formato de entrada...";
    }
     public EnterFormatException(int NroE) {
        this.NroE = NroE;
        switch(NroE){
            case 100:{this.msj = "Error de Formato de entrada..."; break;}
            case 101:{this.msj = "Datos Nulos..."; break;}
            case 102:{this.msj = "Solo se admiten letras..."; break;}
        }
        
    }
    public EnterFormatException(int NroE, String msj) {
        this.NroE = NroE;
        this.msj = msj;
    }
    @Override
    public String toString() {
        return "Error:" + NroE + " generado por: " + msj;
    }
    public int getNroE() {
        return NroE;
    }
    public void setNroE(int NroE) {
        this.NroE = NroE;
    }
    public String getMsj() {
        return msj;
    }
    public void setMsj(String msj) {
        this.msj = msj;
    }    
}
