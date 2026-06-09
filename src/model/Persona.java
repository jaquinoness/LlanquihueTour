package model;

/**
 * Clase que representa una persona
 */
public class Persona {
    private String nombre;
    private String apellido;
    private Direccion direccion;
    private String telefono;
    private String email;
    private Rut rut;


    /**
     * Constructor de la clase Persona
     * @param nombre nombre de la persona
     * @param apellido apellido de la persona
     * @param direccion direccion de la persona
     * @param telefono telefono de la persona
     * @param email email de la persona
     * @param rut rut de la persona
     */
    public Persona(String nombre, String apellido, Direccion direccion, String telefono, String email, Rut rut) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.rut = rut;
    }

    /**
     * Metodo que retorna el nombre de la persona
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que retorna el apellido de la persona
     * @return apellido de la persona
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Metodo que retorna la direccion de la persona
     * @return direccion de la persona
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Metodo que retorna el telefono de la persona
     * @return telefono de la persona
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo que retorna el email de la persona
     * @return email de la persona
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo que retorna el rut de la persona
     * @return rut de la persona
     */
    public Rut getRut() {
        return rut;
    }

    /**
     * Metodo que establece el nombre de la persona
     * @param nombre nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que establece el apellido de la persona
     * @param apellido apellido de la persona
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Metodo que establece la direccion de la persona
     * @param direccion direccion de la persona
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo que establece el telefono de la persona
     * @param telefono telefono de la persona
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo que establece el email de la persona
     * @param email email de la persona
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo que establece el rut de la persona
     * @param rut rut de la persona
     */
    public void setRut(Rut rut) {
        this.rut = rut;
    }
    
    /**
     * Metodo que retorna una representacion en cadena de la persona
     * @return representacion en cadena de la persona
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Direccion: " + direccion + ", Telefono: "
                + telefono + ", Email: " + email + ", Rut: " + rut;
    }
}
