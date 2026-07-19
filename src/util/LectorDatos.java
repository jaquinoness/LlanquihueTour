package util;

import model.Direccion;
import model.Registrable;
import model.Rut;
import model.colaboradores.Cliente;
import model.servicios.ExcursionCultural;
import model.servicios.PaseoLacustre;
import model.servicios.RutaGastronomica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase para leer archivos .txt y convertirlos en objetos
 * Las líneas que comienzan con # son tratadas como comentarios y se omiten
 */
public class LectorDatos {

    /**
     * Carga clientes desde un archivo .txt.
     * Formato esperado por línea:
     * nombre;apellido;rut;telefono;email;calle;numero;comuna;ciudad;region;nacionalidad;tipoCliente
     * @param ruta ruta del archivo .txt
     * @return lista de clientes cargados
     */
    public static ArrayList<Cliente> cargarClientes(String ruta) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank() || linea.startsWith("#")) continue;
                String[] datos = linea.split(";");
                if (datos.length < 12) continue;
                try {
                    String nombre       = datos[0].trim();
                    String apellido     = datos[1].trim();
                    Rut rut             = new Rut(datos[2].trim());
                    String telefono     = datos[3].trim();
                    String email        = datos[4].trim();
                    String calle        = datos[5].trim();
                    int numero          = Integer.parseInt(datos[6].trim());
                    String comuna       = datos[7].trim();
                    String ciudad       = datos[8].trim();
                    String region       = datos[9].trim();
                    String nacionalidad = datos[10].trim();
                    String tipoCliente  = datos[11].trim();
                    Direccion dir = new Direccion(calle, numero, comuna, ciudad, region);
                    clientes.add(new Cliente(nombre, apellido, dir, telefono, email, rut, nacionalidad, tipoCliente));
                } catch (RutInvalidoException | NumberFormatException e) {
                    System.err.println("Error al cargar cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo: " + ruta);
        }
        return clientes;
    }

    /**
     * Carga servicios turísticos desde un archivo .txt de forma polimórfica.
     * Formato esperado por línea según tipo:
     *   PASEO;nombre;duracionHoras;tipoEmbarcacion;horaPartida;valor
     *   EXCURSION;nombre;duracionHoras;lugarHistorico;horaPartida;valor
     *   RUTA;nombre;duracionHoras;numeroParadas;horaPartida;valor
     * @param ruta ruta del archivo .txt
     * @return lista polimórfica de servicios turísticos
     */
    public static ArrayList<Registrable> cargarServicios(String ruta) {
        ArrayList<Registrable> servicios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank() || linea.startsWith("#")) continue;
                String[] datos = linea.split(";");
                if (datos.length < 6) continue;
                try {
                    String tipo           = datos[0].trim().toUpperCase();
                    String nombre         = datos[1].trim();
                    int duracion          = Integer.parseInt(datos[2].trim());
                    String campoPrincipal = datos[3].trim();
                    String horaPartida    = datos[4].trim();
                    int valor             = Integer.parseInt(datos[5].trim());
                    switch (tipo) {
                        case "PASEO":
                            servicios.add(new PaseoLacustre(nombre, duracion, campoPrincipal, horaPartida, valor));
                            break;
                        case "EXCURSION":
                            servicios.add(new ExcursionCultural(nombre, duracion, campoPrincipal, horaPartida, valor));
                            break;
                        case "RUTA":
                            int paradas = Integer.parseInt(campoPrincipal);
                            servicios.add(new RutaGastronomica(nombre, duracion, paradas, horaPartida, valor));
                            break;
                        default:
                            System.err.println("Tipo de servicio desconocido: " + tipo);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error al cargar servicio: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo: " + ruta);
        }
        return servicios;
    }
}
