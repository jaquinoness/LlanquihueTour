package model;

/**
 * Clase que representa un cliente del centro turistico o que ha contratado un paquete.
 */
public class Cliente extends Persona{
    private String paqueteContratado;
    
    /**
     * Constructor de la clase Cliente.
     * @param nombre El nombre del cliente.
     * @param apellido El apellido del cliente.
     * @param direccion La direccion del cliente.
     * @param telefono El teléfono del cliente.
     * @param email El email del cliente.
     * @param rut El rut del cliente.
     * @param paqueteContratado El paquete contratado por el cliente.
     */
    public Cliente(String nombre, String apellido, Direccion direccion, String telefono, String email, Rut rut, String paqueteContratado) {
        super(nombre, apellido, direccion, telefono, email, rut);
        this.paqueteContratado = paqueteContratado;
    }
    
    /**
     * Getter del paquete contratado.
     * @return El paquete contratado.
     */
    public String getPaqueteContratado() {
        return paqueteContratado;
    }
    
    /**
     * Setter del paquete contratado.
     * @param paqueteContratado El paquete contratado.
     */
    public void setPaqueteContratado(String paqueteContratado) {
        this.paqueteContratado = paqueteContratado;
    }
    
    /**
     * Método para mostrar la información del cliente.
     * @return La información del cliente.
     */
    @Override
    public String toString() {
        return "Cliente: " + getNombre() + " " + getApellido() + "\n" +
               "Email: " + getEmail() + "\n" +
               "Teléfono: " + getTelefono() + "\n" +
               "Paquete Contratado: " + paqueteContratado;
    }
}
