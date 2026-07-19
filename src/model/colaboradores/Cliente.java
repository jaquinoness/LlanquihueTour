package model.colaboradores;

import model.Direccion;
import model.Registrable;
import model.Rut;

/**
 * Clase que representa un cliente de la agencia
 */
public class Cliente extends Persona implements Registrable {
    private String nacionalidad;
    private String tipoCliente; // nacional o extranjero

    /**
     * Constructor de la clase Cliente
     * @param nombre nombre del cliente
     * @param apellido apellido del cliente
     * @param direccion direccion del cliente
     * @param telefono telefono del cliente
     * @param email email del cliente
     * @param rut rut del cliente
     * @param nacionalidad nacionalidad del cliente
     * @param tipoCliente tipo de cliente (nacional o extranjero)
     */
    public Cliente(String nombre, String apellido, Direccion direccion,
                   String telefono, String email, Rut rut,
                   String nacionalidad, String tipoCliente) {
        super(nombre, apellido, direccion, telefono, email, rut);
        this.nacionalidad = nacionalidad;
        this.tipoCliente = tipoCliente;
    }

    // getters
    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    // setters
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    // overrides
    @Override
    public String toString() {
        return "Cliente [nacionalidad: " + nacionalidad + ", tipo: " + tipoCliente + "]";
    }

    @Override
    public void registrar() {
        System.out.println("Registrando cliente: " + getNombre() + " " + getApellido() + " | RUT: " + getRut().getRut());
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Cliente: " + getNombre() + " " + getApellido());
        System.out.println("RUT: " + getRut());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Email: " + getEmail());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Tipo de cliente: " + tipoCliente);
    }
}
