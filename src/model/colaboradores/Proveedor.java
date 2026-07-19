package model.colaboradores;

import model.Direccion;
import model.Registrable;
import model.Rut;

/**
 * Clase que representa a un proveedor relacionado con la empresa
 */
public class Proveedor extends Persona implements Registrable{
    private String tipoProveedor; // transporte o alojamiento
    private String tipoDeVehiculo; // van, bus, automovil, etc
    private String infraestructura; // hotel, camping, hostal, cabañas, etc
    
    /**
     * Constructor de la clase Proveedor
     * @param nombre Nombre del proveedor
     * @param apellido Apellido del proveedor
     * @param direccion Direccion del proveedor
     * @param telefono Telefono del proveedor
     * @param email Email del proveedor
     * @param rut Rut del proveedor
     * @param tipoProveedor Tipo de proveedor (transporte o alojamiento)
     * @param tipoDeVehiculo Tipo de vehiculo (van, bus, automovil, etc)
     * @param infraestructura Infraestructura (hotel, camping, hostal, cabañas, etc)
     */
    private Proveedor(String nombre, String apellido, Direccion direccion, 
                    String telefono, String email, Rut rut, String tipoProveedor, 
                    String tipoDeVehiculo, String infraestructura) {
        super(nombre, apellido, direccion, telefono, email, rut);
        this.tipoProveedor = tipoProveedor;
        this.tipoDeVehiculo = tipoDeVehiculo;
        this.infraestructura = infraestructura;
    }
    
    // creamos dos métodos difeerentes para crear segun el tipo de proveedor
    public static Proveedor crearTransporte(String nombre, String apellido, Direccion direccion,
                    String telefono, String email, Rut rut, String tipoDeVehiculo) {
        return new Proveedor(nombre, apellido, direccion, telefono, email, rut, "transporte", tipoDeVehiculo, null);
    }

    public static Proveedor crearAlojamiento(String nombre, String apellido, Direccion direccion,
                    String telefono, String email, Rut rut, String infraestructura) {
        return new Proveedor(nombre, apellido, direccion, telefono, email, rut, "alojamiento", null, infraestructura);
    }

    // getters
    public String getTipoProveedor() {
        return tipoProveedor;
    }
    
    public String getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }
    
    public String getInfraestructura() {
        return infraestructura;
    }
    
    // setters  
    public void setTipoProveedor(String tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }
    
    public void setTipoDeVehiculo(String tipoDeVehiculo) {
        this.tipoDeVehiculo = tipoDeVehiculo;
    }
    
    public void setInfraestructura(String infraestructura) {
        this.infraestructura = infraestructura;
    }

    // overrides
    @Override
    public String toString() {
        return "Proveedor [tipo proveedor: " + tipoProveedor + ", tipo de vehiculo: " + tipoDeVehiculo + ", infraestructura: "
                + infraestructura + "]";
    }

    @Override
    public void registrar() {
        System.out.println("Registrando proveedor: " + getNombre() + " " + getApellido() + " | Tipo: " + tipoProveedor);
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Proveedor: " + getNombre() + " " + getApellido());
        System.out.println("RUT: " + getRut());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Email: " + getEmail());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Tipo de proveedor: " + tipoProveedor);
        if (tipoProveedor.equals("transporte")) {
            System.out.println("Tipo de vehiculo: " + tipoDeVehiculo);
        } else {
            System.out.println("Infraestructura: " + infraestructura);
        }
    }
}
