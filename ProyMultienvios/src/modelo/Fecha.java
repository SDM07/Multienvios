/**
 * Clase Final
 */
package modelo;

import java.util.Calendar;

/**
 * Clase final 
 * La clase envio permite permite definir
 * las caracteristicas de los posible envios
 * de sitema Multienvios
 * @author Sebastian Diaz y Daniel Lopez
 * @version 1.0;
 */
public class Fecha {
    private int dd, mm, aa;
    
    /**
     * Crea un objeto de tipo Fecha con datos nulos
     */
    public Fecha() {
        Calendar objC = Calendar.getInstance();
        this.dd = objC.get(Calendar.DAY_OF_MONTH);
        this.mm = objC.get(Calendar.MONTH)+1;
        this.aa = objC.get(Calendar.YEAR);
    }
    
    /**
     * Crea un objeto de tipo Fecha utilizando lo siguientes parametros
     * @param dd: dia
     * @param mm: mes 
     * @param aa: año
     */
    public Fecha(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }

    /**
     * retorna el dia de la fecha en una cadena de caracteres
     * @return int
     */
    public int getDd() {
        return dd;
    }

    /**
     * retorna o modifica los parametros del dia de la fecha
     * en una cadena de caracteres
     * @param dd: dia
     */
    public void setDd(int dd) {
        this.dd = dd;
    }

    /**
     * retorna el mes de la fecha en una cadena de caracteres
     * @return int
     */
    public int getMm() {
        return mm;
    }

    /**
     * retorna o modifica los parametros del mes de la fecha
     * en una cadena de caracteres
     * @param mm: mes 
     */
    public void setMm(int mm) {
        this.mm = mm;
    }

    /**
     * retorna el año de la fecha en una cadena de caracteres
     * @return int
     */
    public int getAa() {
        return aa;
    }

    /**
     * retorna o modifica los parametros del año de la fecha
     * en una cadena de caracteres
     * @param aa: año
     */
    public void setAa(int aa) {
        this.aa = aa;
    }

    /**
     * Retorna el dia, el mes y el año de la fecha
     * @return
     */
    @Override
    public String toString() {
        return dd + "/" + mm + "/" + aa;
    }
    
    /**
     * retorna los datos de la fecha separados por punto y coma
     * los cuales se almacenaran en un archivo
     * @return
     */
    public String adRegistrarFec(){
        return dd+";"+mm+";"+aa;
    }
    
}
