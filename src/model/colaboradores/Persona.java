package model.colaboradores;

import model.Direccion;
import model.Rut;

/**
 * Clase que representa un colaborador de la empresa
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

    // getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Rut getRut() {
        return rut;
    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Direccion: " + direccion + ", Telefono: "
                + telefono + ", Email: " + email + ", Rut: " + rut;
    }
}
