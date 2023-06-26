/*
 * Clase Final
 */
package modelo;

import java.util.ArrayList;

/**
 * Clase final 
 * La clase envio permite permite definir
 * las caracteristicas de los posible envios
 * de sitema Multienvios
 * @author Sebastian Diaz y Daniel Lopez
 * @version 1.0;
 */
public class Aereo extends Envio{

    /**
     * Crea un objeto de tipo Aereo que hereda de Envio con datos nulos
     */
    public Aereo() {
        super();
    }

    /**
     * Crea un objeto de tipo Aereo utilizando lo siguientes parametros
     * @param NumEnv: Nnumero del envio 
     * @param listMer: lista de mercancias
     * @param origen: origen de la mercancia
     * @param destino: destino de la mercancia
     * @param tipo: tipo de envio
     * @param destinatario: datos del destinatario
     */
    public Aereo(String NumEnv, Mercancia listMer, String origen, String destino, String tipo, Persona destinatario) {
        super(NumEnv, listMer, origen, destino, tipo, destinatario);
    }

    /**
     * Retorna el numero del envio, la mercancia,
     * el origen del envio, el destino del envio,
     * el tipo de envio y los datos del destinatario
     * heredados de la clase Envio 
     * @return toString
     */
    @Override
    public String toString() {
        return super.toString();
    }
    
    /**
     * Retorna el peso total de la mercancia 
     * @return double 
     */
    @Override
    public double totalpesoM() {
         double total=0;
            total += listMer.totalPesoM();
         return total;
    }

    /**
     * Retorna el tipo de envio de Envio Aereo
     * @return String 
     */
    @Override
    public String tipo() {
        return "Aereo";
    }

    /**
     * Retorna el valor del envio de Envio Aereo con su valor adicional
     * @return double
     */
    @Override
    public double valorEnv() {
       double extra=0, totalE=0, valorkilo=6000;
       extra = valorkilo*0.10;
       totalE= extra*this.totalpesoM();
       return totalE;
    }
    
}
