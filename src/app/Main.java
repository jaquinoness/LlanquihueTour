package app;

import model.Direccion;
import model.Rut;
import model.Cliente;
import model.Sucursal;
import model.Colaborador;
import util.RutInvalidoException;

public class Main {
    public static void main(String[] args) {
        try {
            // DEFINIMOS DIRECCIONES
            // definimos la del cliente
            Direccion dirCliente = new Direccion("Los Alamos", 123, "Puerto Varas", "Puerto Varas", "Los Lagos");
            
            // definimos la del colaborador
            Direccion dirColaborador = new Direccion("Av. Colón", 456, "Puerto Montt", "Puerto Montt", "Los Lagos");
            
            // definimos la de la sucursal
            Direccion dirSucursal = new Direccion("San Francisco", 789, "Puerto Montt", "Puerto Montt", "Los Lagos");

            // definimos la del encargado
            Direccion dirEncargado = new Direccion("Balmaceda", 321, "Puerto Montt", "Puerto Montt", "Los Lagos");

            // DEFINIMOS RUTS
            // el del cliente
            Rut rutCliente = new Rut("12345678-9");

            // el del colaborador
            Rut rutColaborador = new Rut("98765432-1");

            // el del encargado
            Rut rutEncargado = new Rut("11111111-1");


            // DEFINIMOS LA SUCURSAL COMO TAL
            Sucursal sucursal = new Sucursal(1, "Sucursal Puerto Montt", dirSucursal, "+56912345678", "sucursal@llanquihuetour.cl");


            // DEFINIMOS EL CLIENTE COMO TAL
            Cliente cliente = new Cliente("Juan", "Pérez", dirCliente, "+56987654321", "juan@email.com", rutCliente, "Paquete Lago Llanquihue");

            // DEFINIMOS EL COLABORADOR COMO TAL
            Colaborador colaborador = new Colaborador("María", "González", dirColaborador, "+56911223344", "maria@llanquihuetour.cl", rutColaborador, "Administrador", sucursal, "Guia Turistico");


            // DEFINIMOS EL ENCARGADO COMO TAL
            Colaborador encargado = new Colaborador("Carlos", "Soto", dirEncargado, "+56922334455", "carlos@llanquihuetour.cl", rutEncargado, "Administrador", sucursal, "Colaborador de planta");

            // ASIGNAMOS EL ENCARGADO A LA SUCURSAL
            sucursal.setEncargado(encargado);


            // IMPRIMIMOS LA INFORMACIÓN
            System.out.println("=== CLIENTE ===");
            System.out.println(cliente.toString());
            System.out.println();
            System.out.println("=== COLABORADOR ===");
            System.out.println(colaborador.toString());
            System.out.println();
            System.out.println("=== ENCARGADO ===");
            System.out.println(encargado.toString());
            System.out.println();
            System.out.println("=== SUCURSAL ===");
            System.out.println(sucursal.toString());

        } catch (RutInvalidoException e) {
            System.out.println("Error en el proceso de creación de objetos: " + e.getMessage());
        }
    }
}