package model.colaboradores;

import model.Direccion;
import model.Registrable;
import model.Rut;

/**
 * Clase que representa un guía turístico de la empresa
 */
public class GuiaTuristico extends Persona implements Registrable{
    private String zonaAsignada;
    private String especialidad;
    
    /**
     * Constructor de la clase GuiaTuristico
     * @param nombre nombre del guía turístico
     * @param apellido apellido del guía turístico
     * @param direccion direccion del guía turístico
     * @param telefono telefono del guía turístico
     * @param email email del guía turístico
     * @param rut rut del guía turístico
     * @param zonaAsignada zona asignada al guía turístico
     * @param especialidad especialidad del guía turístico
     */
    public GuiaTuristico(String nombre, String apellido, Direccion direccion, 
                        String telefono, String email, Rut rut, 
                        String zonaAsignada, String especialidad) {
        super(nombre, apellido, direccion, telefono, email, rut);
        this.zonaAsignada = zonaAsignada;
        this.especialidad = especialidad;
    }
    
    // getters
    public String getZonaAsignada() {
        return zonaAsignada;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }

    // setters
    public void setZonaAsignada(String zonaAsignada) {
        this.zonaAsignada = zonaAsignada;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    // overrides
    @Override
    public String toString() {
        return "Guía Turístico [zona asignada: " + zonaAsignada + ", especialidad: " + especialidad + "]";
    }

    @Override
    public void registrar() {
        System.out.println("Registrando guía turístico: " + getNombre() + " " + getApellido() + " | Especialidad: " + especialidad);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Guía Turístico: " + getNombre() + " " + getApellido());
        System.out.println("RUT: " + getRut());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Email: " + getEmail());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Zona Asignada: " + zonaAsignada);
        System.out.println("Especialidad: " + especialidad);
    }
}
