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
public class Recaudo {
    
    private ArrayList<Factura> listaFac;

    /**
     * Crea un objeto de tipo Recaudo con datos nulos
     */
    public Recaudo() {
        this.listaFac = new ArrayList<>();
    }
    
    /**
     * Crea un objeto de tipo Recaudo utilizando lo siguientes parametros
     * @param listaFac: lista de facturas
     */
    public Recaudo(ArrayList<Factura> listaFac) {
        this.listaFac = listaFac;
    }

    /**
     * retorna la lista de facturas de mercancia en una cadena de caracteres
     * @return ArrayList<>
     */
    public ArrayList<Factura> getListaFac() {
        return listaFac;
    }

    /**
     * retorna o modifica los parametros de la lista de facturas de la mercancia
     * en una cadena de caracteres
     * @param listaFac: lista de facturas
     */
    public void setListaFac(ArrayList<Factura> listaFac) {
        this.listaFac = listaFac;
    }

    /**
     * retorna la lista de facturas de mercancia en el recaudo
     * @return String
     */
    @Override
    public String toString() {
        String datos="";
        for (int i = 0; i < listaFac.size(); i++) {
            datos += listaFac.get(i).toString()+"\n"+this.listaFac.get(i).total();
        }
        return "\n LISTA DE FACTURAS "+datos;
    }
    
    /**
     * Retorna el total de los recaudos
     * @return double
     */
    public double totalRecaudo(){
        double datos=0;
        for (int i = 0; i < listaFac.size(); i++) {
            datos+= listaFac.get(i).total();
        }
        return datos;
    }
}
