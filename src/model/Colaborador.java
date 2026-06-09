package model;

/**
 * Clase que representa un colaborador de la empresa, este puede ser:
 * - Operador local
 * - Guia Turistico
 * - Proveedor de alojamiento
 * - Proveedor de transporte
 * - Colaborador de planta
 */
public class Colaborador extends Persona {
    private String rol;
    private Sucursal sucursal;
    private String posicion;
    
    /**
     * Constructor de la clase Colaborador
     * @param nombre Nombre del colaborador
     * @param apellido Apellido del colaborador
     * @param direccion Direccion del colaborador
     * @param telefono Telefono del colaborador
     * @param email Email del colaborador
     * @param rut Rut del colaborador
     * @param rol Rol del colaborador (Administrador, Visualizador, Creador, Editor)
     * @param sucursal Sucursal del colaborador
     * @param posicion Posicion del colaborador (si es operador local, guia turistico, proveedor de alojamiento, proveedor de transporte, colaborador de planta)
     */
    public Colaborador(String nombre, String apellido, Direccion direccion, String telefono, String email, Rut rut, String rol, Sucursal sucursal, String posicion) {
        super(nombre, apellido, direccion, telefono, email, rut);
        this.rol = rol;
        this.sucursal = sucursal;
        this.posicion = posicion;
    }
    
    /**
     * Metodo que retorna el rol del colaborador
     * @return rol del colaborador
     */
    public String getRol() {
        return rol;
    }
    
    /** 
     * Metodo que retorna la sucursal del colaborador
     * @return sucursal del colaborador
     */
    public Sucursal getSucursal() {
        return sucursal;
    }
    
    /**
     * Metodo que retorna la posicion del colaborador
     * @return posicion del colaborador
     */
    public String getPosicion() {
        return posicion;
    }
    
    /**
     * Metodo que establece el rol del colaborador
     * @param rol rol del colaborador
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    /**
     * Metodo que establece la sucursal del colaborador
     * @param sucursal sucursal del colaborador
     */
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    /**
     * Metodo que establece la posicion del colaborador
     * @param posicion posicion del colaborador
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    /**
     * Metodo que retorna una representacion en cadena del colaborador
     * @return representacion en cadena del colaborador
     */
    @Override
    public String toString() {
        return "Colaborador: " + getNombre() + " " + getApellido() + "\n" +
               "Email: " + getEmail() + "\n" +
               "Teléfono: " + getTelefono() + "\n" +
               "Rol: " + rol + "\n" +
               "Sucursal: " + sucursal + "\n" +
               "Posición: " + posicion;
    }
}
