package model.colaboradores;

import model.Direccion;
import model.Registrable;
import model.Rut;

/**
 * Clase que representa a un operador de planta de la empresa
 */
public class OperadorLocal extends Persona implements Registrable{
    private String sucursal;
    private String cargo;

    /**
     * Constructor de la clase OperadorLocal
     * @param nombre Nombre del operador
     * @param apellido Apellido del operador
     * @param direccion Direccion del operador
     * @param telefono Telefono del operador
     * @param email Email del operador
     * @param rut Rut del operador
     * @param sucursal Sucursal a la que pertenece el operador
     * @param cargo Cargo del operador
     */
    public OperadorLocal(String nombre, String apellido, Direccion direccion, 
                        String telefono, String email, Rut rut, 
                        String sucursal, String cargo) {
        super(nombre, apellido, direccion, telefono, email, rut);
        this.sucursal = sucursal;
        this.cargo = cargo;
    }
    
    // getters
    public String getSucursal() {
        return sucursal;
    }
    
    public String getCargo() {
        return cargo;
    }

    // setters
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    // overrides
    @Override
    public String toString() {
        return "Operador Local [sucursal: " + sucursal + ", cargo: " + cargo + "]";
    }
    
    @Override
    public void registrar() {
        System.out.println("Registrando operador local: " + getNombre() + " " + getApellido() + " | Cargo: " + cargo);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Operador Local: " + getNombre() + " " + getApellido());
        System.out.println("RUT: " + getRut());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Email: " + getEmail());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Sucursal: " + sucursal);
        System.out.println("Cargo: " + cargo);
    }
}
