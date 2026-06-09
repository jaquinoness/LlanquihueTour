package model;

/**
 * Clase que representa una sucursal de la empresa Llanquihue Tour
 */
public class Sucursal {
    private int codigo;
    private String nombre;
    private Direccion direccion;
    private String telefono;
    private String email;
    private Persona encargado;
    
    /**
     * Constructor de la clase Sucursal
     * @param codigo codigo de la sucursal
     * @param nombre nombre de la sucursal
     * @param direccion direccion de la sucursal
     * @param telefono telefono de la sucursal
     * @param email email de la sucursal
     */
    public Sucursal(int codigo, String nombre, Direccion direccion, String telefono, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    
    /**
     * Método que retorna el código de la sucursal
     * @return código de la sucursal
     */
    public int getCodigo() {
        return codigo;
    }
    
    /**
     * Método que retorna el nombre de la sucursal
     * @return nombre de la sucursal
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método que retorna la dirección de la sucursal
     * @return dirección de la sucursal
     */
    public Direccion getDireccion() {
        return direccion;
    }
    
    /**
     * Método que retorna el teléfono de la sucursal
     * @return teléfono de la sucursal
     */
    public String getTelefono() {
        return telefono;
    }
    
    /**
     * Método que retorna el email de la sucursal
     * @return email de la sucursal
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Método que retorna el encargado de la sucursal
     * @return encargado de la sucursal
     */
    public Persona getEncargado() {
        return encargado;
    }
    
    /**
     * Método que establece el código de la sucursal
     * @param codigo codigo de la sucursal
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Método que establece el nombre de la sucursal
     * @param nombre nombre de la sucursal
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método que establece la dirección de la sucursal
     * @param direccion direccion de la sucursal
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Método que establece el teléfono de la sucursal
     * @param telefono telefono de la sucursal
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Método que establece el email de la sucursal
     * @param email email de la sucursal
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Método que establece el encargado de la sucursal
     * @param encargado encargado de la sucursal
     */
    public void setEncargado(Persona encargado) {
        this.encargado = encargado;
    }
    
    /**
     * Método que retorna una representación en cadena de la sucursal
     * @return representación en cadena de la sucursal
     */
    @Override
    public String toString() {
        return "Sucursal: " + nombre + "\n" +
               "Dirección: " + direccion + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Email: " + email + "\n" +
               "Encargado: " + (encargado != null ? encargado.getNombre() + " " + encargado.getApellido() : "Sin encargado");
    }
}
