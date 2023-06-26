/**
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
public class Persona {
    private String id, nombre, telefono;
    
    /**
     * Crea un objeto de tipo Persona con datos nulos
     */
    public Persona() {
        this.id = "";
        this.nombre = "";
        this.telefono = "";
    }
    
    /**
     * Crea un objeto de tipo Persona utilizando lo siguientes parametros
     * @param id: identificacion 
     * @param nombre: nombre
     * @param telefono: telefono movil
     */
    public Persona(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    /**
     * retorna la identificacion de una persona en una cadena de caracteres
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * retorna o modifica los parametros de la identificacion de una persona 
     * en una cadena de caracteres
     * @param id: identificacion
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * retorna el nombre de una persona en una cadena de caracteres
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * retorna o modifica los parametros del nombre de una persona 
     * en una cadena de caracteres
     * @param nombre: nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * retorna el numero de telefono de una persona en una cadena de caracteres
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * retorna o modifica los parametros del numero de telefono de una persona 
     * en una cadena de caracteres
     * @param telefono: telefono movil
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * retorna la identificacion, el nombre y el telefono de una persona
     * @return
     */
    @Override
    public String toString() {
        return "\nId: " + id +
                "\nNombre: " + nombre +
                "\nTelefono: " + telefono;
    }
    
    /**
     * retorna los datos de la persona separados por punto y coma
     * los cuales se almacenaran en un archivo
     * @return
     */
    public String adRegistrar(){
        return id+";"+nombre+";"+telefono+";";
    }
}
