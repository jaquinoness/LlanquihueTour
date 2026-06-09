package model;

/**
 * Clase que representa una direccion
 */
public class Direccion {
    private String calle;
    private int numero;
    private String comuna;
    private String ciudad;
    private String region;
    
    /**
     * Constructor de la clase Direccion
     * @param calle calle de la direccion
     * @param numero numero de la direccion
     * @param comuna comuna de la direccion
     * @param ciudad ciudad de la direccion
     * @param region region de la direccion
     */
    public Direccion(String calle, int numero, String comuna, String ciudad, String region) {
        this.calle = calle;
        this.numero = numero;
        this.comuna = comuna;
        this.ciudad = ciudad;
        this.region = region;
    }
    
    /**
     * Metodo que retorna la calle de la direccion
     * @return calle de la direccion
     */
    public String getCalle() {
        return calle;
    }
    
    /**
     * Metodo que retorna el numero de la direccion
     * @return numero de la direccion
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     * Metodo que retorna la comuna de la direccion
     * @return comuna de la direccion
     */
    public String getComuna() {
        return comuna;
    }
    
    /**
     * Metodo que retorna la ciudad de la direccion
     * @return ciudad de la direccion
     */
    public String getCiudad() {
        return ciudad;
    }
    
    /**
     * Metodo que retorna la region de la direccion
     * @return region de la direccion
     */
    public String getRegion() {
        return region;
    }
    
    /**
     * Metodo que establece la calle de la direccion
     * @param calle calle de la direccion
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }
    
    /**
     * Metodo que establece el numero de la direccion
     * @param numero numero de la direccion
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    /**
     * Metodo que establece la comuna de la direccion
     * @param comuna comuna de la direccion
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    
    /**
     * Metodo que establece la ciudad de la direccion
     * @param ciudad ciudad de la direccion
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    /**
     * Metodo que establece la region de la direccion
     * @param region region de la direccion
     */
    public void setRegion(String region) {
        this.region = region;
    }
    
    /**
     * Metodo que retorna la direccion en formato string
     * @return direccion en formato string
     */
    @Override
    public String toString() {
        return "Calle: " + calle + ", Numero: " + numero + ", Comuna: " + comuna + ", Ciudad: " + ciudad + ", Region: " + region;
    }
}
