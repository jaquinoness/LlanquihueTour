package data;

import model.Registrable;
import model.colaboradores.Cliente;
import model.colaboradores.GuiaTuristico;
import model.colaboradores.OperadorLocal;
import model.colaboradores.Proveedor;
import model.servicios.ExcursionCultural;
import model.servicios.PaseoLacustre;
import model.servicios.RutaGastronomica;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class GestorEntidades {

    private ArrayList<Registrable> entidades = new ArrayList<>();
    private HashMap<String, Cliente> clientesPorRut = new HashMap<>();

    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
        if (entidad instanceof Cliente) {
            Cliente c = (Cliente) entidad;
            clientesPorRut.put(c.getRut().getRut(), c);
        }
    }

    public Cliente buscarClientePorRut(String rut) {
        return clientesPorRut.get(rut);
    }

    public ArrayList<Registrable> getEntidades() {
        return entidades;
    }

    public String getMensajeCreacion(Registrable entidad) {
        String tipo;
        if (entidad instanceof PaseoLacustre) {
            tipo = "Paseo Lacustre";
        } else if (entidad instanceof ExcursionCultural) {
            tipo = "Excursión Cultural";
        } else if (entidad instanceof RutaGastronomica) {
            tipo = "Ruta Gastronómica";
        } else if (entidad instanceof Cliente) {
            tipo = "Cliente";
        } else if (entidad instanceof GuiaTuristico) {
            tipo = "Guía Turístico";
        } else if (entidad instanceof OperadorLocal) {
            tipo = "Operador Local";
        } else if (entidad instanceof Proveedor) {
            tipo = "Proveedor";
        } else {
            tipo = "Entidad";
        }
        return "El servicio de " + tipo + ": " + entidad.toString() + ", ha sido creado.";
    }

    public String generarResumenCompleto() {
        StringBuilder sb = new StringBuilder();
        for (Registrable r : entidades) {
            if (r instanceof PaseoLacustre || r instanceof ExcursionCultural || r instanceof RutaGastronomica) {
                sb.append("[ SERVICIO TURÍSTICO ]\n");
            } else if (r instanceof Cliente) {
                sb.append("[ CLIENTE ]\n");
            } else if (r instanceof GuiaTuristico || r instanceof OperadorLocal || r instanceof Proveedor) {
                sb.append("[ COLABORADOR ]\n");
            }
            sb.append(capturarResumen(r)).append("\n");
        }
        return sb.toString();
    }

    private String capturarResumen(Registrable r) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream original = System.out;
        System.setOut(ps);
        try {
            r.mostrarDatos();
        } finally {
            System.setOut(original);
        }
        return baos.toString();
    }
}
