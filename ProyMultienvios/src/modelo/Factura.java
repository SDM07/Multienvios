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
public class Factura {
    
    private String numFac;
    private Fecha fecha;
    private ArrayList<Envio> listEnvio;
    private Persona cliente;

    /**
     * Crea un objeto de tipo Factura con datos nulos
     */
    public Factura() {
        this.numFac = "" + (int)(Math.random()*999+1);
        this.fecha = new Fecha();
        this.listEnvio = new ArrayList<Envio>();
        this.cliente = new Persona();
    }
    
    /**
     * Crea un objeto de tipo Factura utilizando lo siguientes parametros
     * @param numFac: numero de factura
     * @param fecha: fecha
     * @param listEnvio: lista de envios 
     * @param cliente: datos del cliente
     */
    public Factura(String numFac, Fecha fecha, ArrayList<Envio> listEnvio, Persona cliente) {
        this.numFac = numFac;
        this.fecha = fecha;
        this.listEnvio = listEnvio;
        this.cliente = cliente;
    }

    /**
     * retorna el numero de la factura en una cadena de caracteres
     * @return String
     */
    public String getNumFac() {
        return numFac;
    }

    /**
     * retorna o modifica los parametros del numero de la factura
     * en una cadena de caracteres
     * @param numFac: numero de factura
     */
    public void setNumFac(String numFac) {
        this.numFac = numFac;
    }

    /**
     * retorna la fecha de la Factura en una cadena de caracteres
     * @return Fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * retorna o modifica los parametros del numero de la fecha
     * en una cadena de caracteres
     * @param fecha: fecha
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    /**
     * retorna la lista de envios de la Factura en cadena de caracteres
     * @return Arraylist<>
     */
    public ArrayList<Envio> getListEnvio() {
        return listEnvio;
    }

    /**
     * retorna o modifica los parametros en la lista de envios
     * en una cadena de caracteres
     * @param listEnvio: lista de envios 
     */
    public void setListEnvio(ArrayList<Envio> listEnvio) {
        this.listEnvio = listEnvio;
    }

    /**
     * retorna del cliente o destinatario en una cadena de caracteres
     * @return Persona
     */
    public Persona getCliente() {
        return cliente;
    }

    /**
     * retorna o modifica los parametros de la cliente o destinatario
     * en una cadena de caracteres
     * @param cliente: datos del cliente
     */
    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna el numero de la factura, la fecha,
     * las lista de envios y los datos del cliente o destinatario
     * @return toString
     */
    @Override
    public String toString() {
        return  "\n*********************" +
                "\n Numero de Factura: " + numFac + 
                "\n Fecha:" + fecha.toString() + 
                "\n Lista de envios: " + listEnvio.get(0).toString() + 
                "\n Cliente: " + cliente.toString() +
                "\n*********************" +
                "\n    Valor A Pagar    " +
                "\n*********************" +
                "\n Subtotal: " + this.subTotal() +
                "\n IVA: " + this.iva() + 
                "\n Total: " + this.total();
    }
    
    /**
     * Retorna el valor total de la Factura
     * @return double
     */
    public double total(){
        return subTotal()+iva();
    }
    
    /**
     * Retorna el valor subtotal de la Factura
     * @return double
     */
    public double subTotal(){
        double total=0;
        for (Envio valor: listEnvio) {
            total=valor.valorEnv();
        }
        return total;
    }
    
    /**
     * Retorna el valor del IVA de la Factura 
     * @return double
     */
    public double iva(){
        return this.subTotal()*0.10;
    }
}
