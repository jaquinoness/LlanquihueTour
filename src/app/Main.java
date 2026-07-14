package app;

import data.GestorEntidades;
import model.Direccion;
import model.Rut;
import model.colaboradores.GuiaTuristico;
import model.servicios.PaseoLacustre;
import util.RutInvalidoException;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static final GestorEntidades gestor = new GestorEntidades();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::mostrarVentanaPrincipal);
    }

    private static void mostrarVentanaPrincipal() {
        JFrame frame = new JFrame("LlanquihueTour - Gestión de Entidades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 280);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("LlanquihueTour - Gestión de Entidades", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setBorder(BorderFactory.createEmptyBorder(12, 10, 5, 10));
        frame.add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 8, 8));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(5, 60, 15, 60));

        JButton btnPaseo   = new JButton("Crear Paseo Lacustre");
        JButton btnGuia    = new JButton("Crear Guía Turístico");
        JButton btnResumen = new JButton("Ver Resumen de Entidades");
        JButton btnSalir   = new JButton("Salir");

        btnPaseo.addActionListener(e -> crearPaseoLacustre(frame));
        btnGuia.addActionListener(e -> crearGuiaTuristico(frame));
        btnResumen.addActionListener(e -> mostrarResumen(frame));
        btnSalir.addActionListener(e -> System.exit(0));

        panelBotones.add(btnPaseo);
        panelBotones.add(btnGuia);
        panelBotones.add(btnResumen);
        panelBotones.add(btnSalir);
        frame.add(panelBotones, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void crearPaseoLacustre(JFrame frame) {
        JTextField txtNombre     = new JTextField(15);
        JTextField txtDuracion   = new JTextField(5);
        JTextField txtEmbarcacion = new JTextField(15);
        JTextField txtHora       = new JTextField(8);
        JTextField txtValor      = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 8));
        panel.add(new JLabel("Nombre del paseo:"));    panel.add(txtNombre);
        panel.add(new JLabel("Duración (horas):"));    panel.add(txtDuracion);
        panel.add(new JLabel("Tipo de embarcación:")); panel.add(txtEmbarcacion);
        panel.add(new JLabel("Hora de partida:"));     panel.add(txtHora);
        panel.add(new JLabel("Valor ($):"));           panel.add(txtValor);

        int result = JOptionPane.showConfirmDialog(frame, panel,
            "Crear Paseo Lacustre", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) return;

        try {
            String nombre     = txtNombre.getText().trim();
            String embarcacion = txtEmbarcacion.getText().trim();
            String hora       = txtHora.getText().trim();
            if (nombre.isBlank() || embarcacion.isBlank() || hora.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int duracion = Integer.parseInt(txtDuracion.getText().trim());
            int valor    = Integer.parseInt(txtValor.getText().trim());

            PaseoLacustre paseo = new PaseoLacustre(nombre, duracion, embarcacion, hora, valor);
            gestor.agregarEntidad(paseo);
            JOptionPane.showMessageDialog(frame, gestor.getMensajeCreacion(paseo),
                "Entidad Registrada", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Duración y valor deben ser números enteros.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void crearGuiaTuristico(JFrame frame) {
        JTextField txtNombre      = new JTextField(15);
        JTextField txtApellido    = new JTextField(15);
        JTextField txtRut         = new JTextField(12);
        JTextField txtTelefono    = new JTextField(12);
        JTextField txtEmail       = new JTextField(18);
        JTextField txtZona        = new JTextField(15);
        JTextField txtEspecialidad = new JTextField(15);
        JTextField txtCalle       = new JTextField(15);
        JTextField txtNumero      = new JTextField(5);
        JTextField txtComuna      = new JTextField(12);
        JTextField txtCiudad      = new JTextField(12);
        JTextField txtRegion      = new JTextField(12);

        JPanel panel = new JPanel(new GridLayout(12, 2, 5, 6));
        panel.add(new JLabel("Nombre:"));            panel.add(txtNombre);
        panel.add(new JLabel("Apellido:"));          panel.add(txtApellido);
        panel.add(new JLabel("RUT (12345678-9):"));  panel.add(txtRut);
        panel.add(new JLabel("Teléfono:"));          panel.add(txtTelefono);
        panel.add(new JLabel("Email:"));             panel.add(txtEmail);
        panel.add(new JLabel("Zona asignada:"));     panel.add(txtZona);
        panel.add(new JLabel("Especialidad:"));      panel.add(txtEspecialidad);
        panel.add(new JLabel("Dirección - Calle:")); panel.add(txtCalle);
        panel.add(new JLabel("Dirección - Número:")); panel.add(txtNumero);
        panel.add(new JLabel("Dirección - Comuna:")); panel.add(txtComuna);
        panel.add(new JLabel("Dirección - Ciudad:")); panel.add(txtCiudad);
        panel.add(new JLabel("Dirección - Región:")); panel.add(txtRegion);

        int result = JOptionPane.showConfirmDialog(frame, panel,
            "Crear Guía Turístico", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) return;

        try {
            String nombre       = txtNombre.getText().trim();
            String apellido     = txtApellido.getText().trim();
            String rutStr       = txtRut.getText().trim();
            String telefono     = txtTelefono.getText().trim();
            String email        = txtEmail.getText().trim();
            String zona         = txtZona.getText().trim();
            String especialidad = txtEspecialidad.getText().trim();
            String calle        = txtCalle.getText().trim();
            String comuna       = txtComuna.getText().trim();
            String ciudad       = txtCiudad.getText().trim();
            String region       = txtRegion.getText().trim();

            if (nombre.isBlank() || apellido.isBlank() || rutStr.isBlank()
                    || telefono.isBlank() || email.isBlank() || zona.isBlank()
                    || especialidad.isBlank() || calle.isBlank() || comuna.isBlank()
                    || ciudad.isBlank() || region.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int numero = Integer.parseInt(txtNumero.getText().trim());
            Rut rut    = new Rut(rutStr);
            Direccion dir = new Direccion(calle, numero, comuna, ciudad, region);
            GuiaTuristico guia = new GuiaTuristico(nombre, apellido, dir, telefono, email, rut, zona, especialidad);
            gestor.agregarEntidad(guia);
            JOptionPane.showMessageDialog(frame, gestor.getMensajeCreacion(guia),
                "Entidad Registrada", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "El número de dirección debe ser un entero.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (RutInvalidoException e) {
            JOptionPane.showMessageDialog(frame, "RUT inválido: " + e.getMessage(),
                "Error de RUT", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void mostrarResumen(JFrame frame) {
        if (gestor.getEntidades().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay entidades registradas aún.",
                "Resumen", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JTextArea textArea = new JTextArea(gestor.generarResumenCompleto());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(440, 320));

        JOptionPane.showMessageDialog(frame, scroll, "Resumen de Entidades Registradas", JOptionPane.PLAIN_MESSAGE);
    }
}