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
public abstract class Envio {

    protected String NumEnv;
    protected Mercancia listMer;
    protected String origen, destino;
    protected String tipo;
    protected Persona destinatario;

    /**
     *Crea un objeto de tipo Envio con datos nulos
     * 
     */
    public Envio() {
        this.NumEnv = "" + (int)(Math.random()*9+1);
        this.listMer = new Mercancia();
        this.origen = "";
        this.destino = "";
        this.tipo = "";
        this.destinatario = new Persona();
    }
    
    /**
     * Crea un objeto de tipo envio utilizando lo siguientes parametros
     * @param NumEnv: Nnumero del envio 
     * @param listMer: lista de mercancias
     * @param origen: origen de la mercancia
     * @param destino: destino de la mercancia
     * @param tipo: tipo de envio
     * @param destinatario: datos del destinatario
     */
    public Envio(String NumEnv, Mercancia listMer, String origen, String destino, String tipo, Persona destinatario) {
        this.NumEnv = NumEnv;
        this.listMer = new Mercancia();
        this.origen = origen;
        this.destino = destino;
        this.tipo = tipo;
        this.destinatario = destinatario;
    }

    /**
     * Retorna el numero del envio, la mercancia,
     * el origen del envio, el destino del envio,
     * el tipo de envio y los datos del destinatario
     * @return toString
     */
    @Override
    public String toString() {
        return  "\n*********************" +
                "\n   Datos de Envio    " +
                "\n*********************" +
                "\n Numero de Envio: " + NumEnv +
                "\n Mercancia: " + listMer.toString()+
                "\n Origen del envio: " + origen + 
                "\n Destino del envio: " + destino + 
                "\n Tipo de envio: " + tipo + 
                "\n Destinatario: " + destinatario.toString();
    }
    /**
     * retorna el numero del envio en una cadena de caracteres
     * @return String
     */
    public String getNumEnv() {
        return NumEnv;
    }

    /**
     * retorna o modifica los parametros del numero de envio
     * en una cadena de caracteres
     * @param NumEnv: Nnumero del envio 
     */
    public void setNumEnv(String NumEnv) {
        this.NumEnv = NumEnv;
    }

    /**
     * retorna la lista de mercacias del envio en una cadena de caracteres
     * @return ArrayList
     */
    public Mercancia getListMer() {
        return listMer;
    }

    /**
     * retorna o modifica los parametros de la lista de mercancias del envio
     * en una cadena de caracteres
     * @param listMer: lista de mercancias
     */
    public void setListMer(Mercancia listMer) {
        this.listMer = listMer;
    }

    /**
     * retorna el origen del envio en una cadena de caracteres
     * @return String
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * retorna o modifica los parametros del origen del envio
     * en una cadena de caracteres
     * @param origen: origen de la mercancia
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * retorna el destino del envio en una cadena de caracteres
     * @return String
     */
    public String getDestino() {
        return destino;
    }

    /**
     * retorna o modifica los parametros del destino de envio
     * en una cadena de caracteres
     * @param destino: destino de la mercancia
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * retorna el tipo de envio en una cadena de caracteres
     * @return String
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * retorna o modifica los parametros del tipo de envio
     * en una cadena de caracteres
     * @param tipo: tipo de envio
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * retorna los datos del cliente 
     * a quien se le realiza el envio 
     * en una cadena de caracteres
     * @return Persona
     */
    public Persona getDestinatario() {
        return destinatario;
    }

    /**
     * retorna o modifica los parametros del destinatario del envio
     * en una cadena de caracteres
     * @param destinatario: datos del destinatario
     */
    public void setDestinatario(Persona destinatario) {
        this.destinatario = destinatario;
    }
    
    /**
     * retorna los datos del envio separados por punto y coma
     * los cuales se almacenaran en un archivo
     * @return
     */
    public String adRegistrar(){
        return NumEnv +";"+ listMer +";"+ origen +";"+ destino +";"+ tipo +";"+ destinatario;
    }
    
    /**
     * crea una clase abstracta llamada total peso 
     * que sera heredada a las clases hijas
     * @return double 
     */
    public abstract double totalpesoM();
    
    /**
     * crea una clase abstracta llamada tipo 
     * que sera heredada a las clases hijas
     * @return double
     */
    public abstract String tipo();
    
    /**
     * crea una clase abstracta llamada valor envio
     * que sera heredada a las clases hijas
     * @return double
     */
    public abstract double valorEnv();
}
