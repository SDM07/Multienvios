/*
 * Clase Final
 */
package modelo;

/**
 * Clase final 
 * La clase envio permite permite definir
 * las caracteristicas de los posible envios
 * de sitema Multienvios
 * @author Sebastian Diaz y Daniel Lopez
 * @version 1.0;
 */
public class Mercancia {
    private String serial;
    private String descripcion;
    private int cant;
    private double peso;
    
    /**
     * Crea un objeto de tipo Mercancia con datos nulos
     */
    public Mercancia() {
        this.serial = "" + (int)(Math.random()*999+1);
        this.descripcion = "";
        this.cant = 0;
        this.peso = 0;
    }
    
    /**
     * Crea un objeto de tipo Mercancia utilizando lo siguientes parametros
     * @param serial: numero Serial de la mercancia
     * @param descripcion: descripcion de la mercancia
     * @param cant: cantidad de la mercancia
     * @param peso: peso de la mercancia
     */
    public Mercancia(String serial, String descripcion, int cant, double peso) {
        this.serial = serial;
        this.descripcion = descripcion;
        this.cant = cant;
        this.peso = peso;
    }

    /**
     * retorna el numero serial de la mercancia en una cadena de caracteres
     * @return String
     */
    public String getSerial() {
        return serial;
    }

    /**
     * retorna o modifica los parametros del numero serial de la mercancia 
     * en una cadena de caracteres
     * @param serial: numero Serial de la mercancia
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * retorna la descripcion de la mercancia en una cadena de caracteres
     * @return String
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * retorna o modifica los parametros de la descripcion de la mercancia 
     * en una cadena de caracteres
     * @param descripcion: descripcion de la mercancia
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * retorna la cantidad de mercancia en una cadena de caracteres
     * @return int
     */
    public int getCant() {
        return cant;
    }

    /**
     * retorna o modifica los parametros de la cantidad de mercancia 
     * en una cadena de caracteres
     * @param cant: cantidad de la mercancia
     */
    public void setCant(int cant) {
        this.cant = cant;
    }
    
    /**
     * retorna el peso de la mercancia en una cadena de caracteres
     * @return double
     */
    public double getPeso() {
        return peso;
    }

    /**
     * retorna o modifica los parametros del peso de la mercancia 
     * en una cadena de caracteres
     * @param peso: peso de la mercancia
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Retorna el numero serial de la mercancia, la descipcion,
     * la cantidad y el peso de la mercancia
     * @return String
     */
    @Override
    public String toString() {
        return "Mercancia serial: " + serial + 
                "\n Descripcion: " + descripcion + 
                "\n Cantidad: " + cant +
                "\n Peso: " + peso;
    }
    
    /**
     * retorna los datos de la mercacnia separados por punto y coma
     * los cuales se almacenaran en un archivo
     * @return String
     */
    public String addRegistro(){
        return serial+";"+descripcion+";"+cant+";"+peso;
    }
    
    /**
     * Retorna el peso total de la mercancia
     * @return double
     */
    public double totalPesoM(){
        double TotalPeso=0;
        TotalPeso=cant*peso;
        return TotalPeso;   
    }
}
