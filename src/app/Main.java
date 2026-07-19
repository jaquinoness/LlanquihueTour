package app;

import data.GestorEntidades;
import model.Direccion;
import model.Registrable;
import model.Rut;
import model.colaboradores.Cliente;
import model.colaboradores.GuiaTuristico;
import model.colaboradores.OperadorLocal;
import model.colaboradores.Proveedor;
import model.servicios.ExcursionCultural;
import model.servicios.PaseoLacustre;
import model.servicios.RutaGastronomica;
import util.LectorDatos;
import util.RutInvalidoException;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static final GestorEntidades gestor = new GestorEntidades();

    public static void main(String[] args) {
        cargarDatosIniciales();
        SwingUtilities.invokeLater(Main::mostrarVentanaPrincipal);
    }

    private static void cargarDatosIniciales() {
        for (model.colaboradores.Cliente c : LectorDatos.cargarClientes("recursos/clientes.txt")) {
            gestor.agregarEntidad(c);
        }
        for (Registrable s : LectorDatos.cargarServicios("recursos/servicios.txt")) {
            gestor.agregarEntidad(s);
        }
    }

    private static void mostrarVentanaPrincipal() {
        JFrame frame = new JFrame("LlanquihueTour - Gestión de Entidades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(540, 360);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("LlanquihueTour - Gestión de Entidades", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setBorder(BorderFactory.createEmptyBorder(12, 10, 5, 10));
        frame.add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(5, 2, 8, 8));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(5, 30, 15, 30));

        JButton btnPaseo     = new JButton("Crear Paseo Lacustre");
        JButton btnExcursion = new JButton("Crear Excursión Cultural");
        JButton btnRuta      = new JButton("Crear Ruta Gastronómica");
        JButton btnGuia      = new JButton("Crear Guía Turístico");
        JButton btnOperador  = new JButton("Crear Operador Local");
        JButton btnProveedor = new JButton("Crear Proveedor");
        JButton btnCliente   = new JButton("Crear Cliente");
        JButton btnBuscar    = new JButton("Buscar Cliente por RUT");
        JButton btnResumen   = new JButton("Ver Resumen de Entidades");
        JButton btnSalir     = new JButton("Salir");

        btnPaseo.addActionListener(e -> crearPaseoLacustre(frame));
        btnExcursion.addActionListener(e -> crearExcursionCultural(frame));
        btnRuta.addActionListener(e -> crearRutaGastronomica(frame));
        btnGuia.addActionListener(e -> crearGuiaTuristico(frame));
        btnOperador.addActionListener(e -> crearOperadorLocal(frame));
        btnProveedor.addActionListener(e -> crearProveedor(frame));
        btnCliente.addActionListener(e -> crearCliente(frame));
        btnBuscar.addActionListener(e -> buscarClientePorRut(frame));
        btnResumen.addActionListener(e -> mostrarResumen(frame));
        btnSalir.addActionListener(e -> System.exit(0));

        panelBotones.add(btnPaseo);     panelBotones.add(btnExcursion);
        panelBotones.add(btnRuta);      panelBotones.add(btnGuia);
        panelBotones.add(btnOperador);  panelBotones.add(btnProveedor);
        panelBotones.add(btnCliente);   panelBotones.add(btnBuscar);
        panelBotones.add(btnResumen);   panelBotones.add(btnSalir);
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

    private static void crearExcursionCultural(JFrame frame) {
        JTextField txtNombre  = new JTextField(15);
        JTextField txtDuracion = new JTextField(5);
        JTextField txtLugar   = new JTextField(15);
        JTextField txtHora    = new JTextField(8);
        JTextField txtValor   = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 8));
        panel.add(new JLabel("Nombre de la excursión:")); panel.add(txtNombre);
        panel.add(new JLabel("Duración (horas):"));       panel.add(txtDuracion);
        panel.add(new JLabel("Lugar histórico:"));         panel.add(txtLugar);
        panel.add(new JLabel("Hora de partida:"));         panel.add(txtHora);
        panel.add(new JLabel("Valor ($):"));               panel.add(txtValor);

        int result = JOptionPane.showConfirmDialog(frame, panel,
            "Crear Excursión Cultural", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) return;

        try {
            String nombre = txtNombre.getText().trim();
            String lugar  = txtLugar.getText().trim();
            String hora   = txtHora.getText().trim();
            if (nombre.isBlank() || lugar.isBlank() || hora.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int duracion = Integer.parseInt(txtDuracion.getText().trim());
            int valor    = Integer.parseInt(txtValor.getText().trim());
            ExcursionCultural excursion = new ExcursionCultural(nombre, duracion, lugar, hora, valor);
            gestor.agregarEntidad(excursion);
            JOptionPane.showMessageDialog(frame, gestor.getMensajeCreacion(excursion),
                "Entidad Registrada", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Duración y valor deben ser números enteros.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void crearRutaGastronomica(JFrame frame) {
        JTextField txtNombre   = new JTextField(15);
        JTextField txtDuracion = new JTextField(5);
        JTextField txtParadas  = new JTextField(5);
        JTextField txtHora     = new JTextField(8);
        JTextField txtValor    = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 8));
        panel.add(new JLabel("Nombre de la ruta:"));    panel.add(txtNombre);
        panel.add(new JLabel("Duración (horas):"));     panel.add(txtDuracion);
        panel.add(new JLabel("Número de paradas:"));    panel.add(txtParadas);
        panel.add(new JLabel("Hora de partida:"));      panel.add(txtHora);
        panel.add(new JLabel("Valor ($):"));            panel.add(txtValor);

        int result = JOptionPane.showConfirmDialog(frame, panel,
            "Crear Ruta Gastronómica", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) return;

        try {
            String nombre = txtNombre.getText().trim();
            String hora   = txtHora.getText().trim();
            if (nombre.isBlank() || hora.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int duracion = Integer.parseInt(txtDuracion.getText().trim());
            int paradas  = Integer.parseInt(txtParadas.getText().trim());
            int valor    = Integer.parseInt(txtValor.getText().trim());
            RutaGastronomica ruta = new RutaGastronomica(nombre, duracion, paradas, hora, valor);
            gestor.agregarEntidad(ruta);
            JOptionPane.showMessageDialog(frame, gestor.getMensajeCreacion(ruta),
                "Entidad Registrada", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Duración, paradas y valor deben ser números enteros.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void crearCliente(JFrame frame) {
        JTextField txtNombre      = new JTextField(15);
        JTextField txtApellido    = new JTextField(15);
        JTextField txtRut         = new JTextField(12);
        JTextField txtTelefono    = new JTextField(12);
        JTextField txtEmail       = new JTextField(18);
        JTextField txtCalle       = new JTextField(15);
        JTextField txtNumero      = new JTextField(5);
        JTextField txtComuna      = new JTextField(12);
        JTextField txtCiudad      = new JTextField(12);
        JTextField txtRegion      = new JTextField(12);
        JTextField txtNacionalidad = new JTextField(15);
        JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"nacional", "extranjero"});

        JPanel panel = new JPanel(new GridLayout(12, 2, 5, 6));
        panel.add(new JLabel("Nombre:"));              panel.add(txtNombre);
        panel.add(new JLabel("Apellido:"));            panel.add(txtApellido);
        panel.add(new JLabel("RUT (12345678-9):"));    panel.add(txtRut);
        panel.add(new JLabel("Teléfono:"));            panel.add(txtTelefono);
        panel.add(new JLabel("Email:"));               panel.add(txtEmail);
        panel.add(new JLabel("Dirección - Calle:"));   panel.add(txtCalle);
        panel.add(new JLabel("Dirección - Número:"));  panel.add(txtNumero);
        panel.add(new JLabel("Dirección - Comuna:"));  panel.add(txtComuna);
        panel.add(new JLabel("Dirección - Ciudad:"));  panel.add(txtCiudad);
        panel.add(new JLabel("Dirección - Región:"));  panel.add(txtRegion);
        panel.add(new JLabel("Nacionalidad:"));        panel.add(txtNacionalidad);
        panel.add(new JLabel("Tipo de cliente:"));     panel.add(cmbTipo);

        int result = JOptionPane.showConfirmDialog(frame, panel,
            "Crear Cliente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) return;

        try {
            String nombre       = txtNombre.getText().trim();
            String apellido     = txtApellido.getText().trim();
            String rutStr       = txtRut.getText().trim();
            String telefono     = txtTelefono.getText().trim();
            String email        = txtEmail.getText().trim();
            String calle        = txtCalle.getText().trim();
            String comuna       = txtComuna.getText().trim();
            String ciudad       = txtCiudad.getText().trim();
            String region       = txtRegion.getText().trim();
            String nacionalidad = txtNacionalidad.getText().trim();
            String tipoCliente  = (String) cmbTipo.getSelectedItem();

            if (nombre.isBlank() || apellido.isBlank() || rutStr.isBlank()
                    || telefono.isBlank() || email.isBlank() || calle.isBlank()
                    || comuna.isBlank() || ciudad.isBlank() || region.isBlank()
                    || nacionalidad.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int numero = Integer.parseInt(txtNumero.getText().trim());
            Rut rut = new Rut(rutStr);
            Direccion dir = new Direccion(calle, numero, comuna, ciudad, region);
            Cliente cliente = new Cliente(nombre, apellido, dir, telefono, email, rut, nacionalidad, tipoCliente);
            gestor.agregarEntidad(cliente);
            JOptionPane.showMessageDialog(frame, gestor.getMensajeCreacion(cliente),
                "Entidad Registrada", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "El número de dirección debe ser un entero.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (RutInvalidoException e) {
            JOptionPane.showMessageDialog(frame, "RUT inválido: " + e.getMessage(),
                "Error de RUT", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void crearOperadorLocal(JFrame frame) {
        JTextField txtNombre   = new JTextField(15);
        JTextField txtApellido = new JTextField(15);
        JTextField txtRut      = new JTextField(12);
        JTextField txtTelefono = new JTextField(12);
        JTextField txtEmail    = new JTextField(18);
        JTextField txtCalle    = new JTextField(15);
        JTextField txtNumero   = new JTextField(5);
        JTextField txtComuna   = new JTextField(12);
        JTextField txtCiudad   = new JTextField(12);
        JTextField txtRegion   = new JTextField(12);
        JTextField txtSucursal = new JTextField(15);
        JTextField txtCargo    = new JTextField(15);

        JPanel panel = new JPanel(new GridLayout(12, 2, 5, 6));
        panel.add(new JLabel("Nombre:"));              panel.add(txtNombre);
        panel.add(new JLabel("Apellido:"));            panel.add(txtApellido);
        panel.add(new JLabel("RUT (12345678-9):"));    panel.add(txtRut);
        panel.add(new JLabel("Teléfono:"));            panel.add(txtTelefono);
        panel.add(new JLabel("Email:"));               panel.add(txtEmail);
        panel.add(new JLabel("Dirección - Calle:"));   panel.add(txtCalle);
        panel.add(new JLabel("Dirección - Número:"));  panel.add(txtNumero);
        panel.add(new JLabel("Dirección - Comuna:"));  panel.add(txtComuna);
        panel.add(new JLabel("Dirección - Ciudad:"));  panel.add(txtCiudad);
        panel.add(new JLabel("Dirección - Región:"));  panel.add(txtRegion);
        panel.add(new JLabel("Sucursal:"));            panel.add(txtSucursal);
        panel.add(new JLabel("Cargo:"));               panel.add(txtCargo);

        int result = JOptionPane.showConfirmDialog(frame, panel,
            "Crear Operador Local", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) return;

        try {
            String nombre   = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String rutStr   = txtRut.getText().trim();
            String telefono = txtTelefono.getText().trim();
            String email    = txtEmail.getText().trim();
            String calle    = txtCalle.getText().trim();
            String comuna   = txtComuna.getText().trim();
            String ciudad   = txtCiudad.getText().trim();
            String region   = txtRegion.getText().trim();
            String sucursal = txtSucursal.getText().trim();
            String cargo    = txtCargo.getText().trim();

            if (nombre.isBlank() || apellido.isBlank() || rutStr.isBlank()
                    || telefono.isBlank() || email.isBlank() || calle.isBlank()
                    || comuna.isBlank() || ciudad.isBlank() || region.isBlank()
                    || sucursal.isBlank() || cargo.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int numero = Integer.parseInt(txtNumero.getText().trim());
            Rut rut = new Rut(rutStr);
            Direccion dir = new Direccion(calle, numero, comuna, ciudad, region);
            OperadorLocal operador = new OperadorLocal(nombre, apellido, dir, telefono, email, rut, sucursal, cargo);
            gestor.agregarEntidad(operador);
            JOptionPane.showMessageDialog(frame, gestor.getMensajeCreacion(operador),
                "Entidad Registrada", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "El número de dirección debe ser un entero.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (RutInvalidoException e) {
            JOptionPane.showMessageDialog(frame, "RUT inválido: " + e.getMessage(),
                "Error de RUT", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void crearProveedor(JFrame frame) {
        JTextField txtNombre   = new JTextField(15);
        JTextField txtApellido = new JTextField(15);
        JTextField txtRut      = new JTextField(12);
        JTextField txtTelefono = new JTextField(12);
        JTextField txtEmail    = new JTextField(18);
        JTextField txtCalle    = new JTextField(15);
        JTextField txtNumero   = new JTextField(5);
        JTextField txtComuna   = new JTextField(12);
        JTextField txtCiudad   = new JTextField(12);
        JTextField txtRegion   = new JTextField(12);
        JComboBox<String> cmbTipo   = new JComboBox<>(new String[]{"transporte", "alojamiento"});
        JTextField txtEspecifico    = new JTextField(15);

        JPanel panel = new JPanel(new GridLayout(12, 2, 5, 6));
        panel.add(new JLabel("Nombre:"));                      panel.add(txtNombre);
        panel.add(new JLabel("Apellido:"));                    panel.add(txtApellido);
        panel.add(new JLabel("RUT (12345678-9):"));            panel.add(txtRut);
        panel.add(new JLabel("Teléfono:"));                    panel.add(txtTelefono);
        panel.add(new JLabel("Email:"));                       panel.add(txtEmail);
        panel.add(new JLabel("Dirección - Calle:"));           panel.add(txtCalle);
        panel.add(new JLabel("Dirección - Número:"));          panel.add(txtNumero);
        panel.add(new JLabel("Dirección - Comuna:"));          panel.add(txtComuna);
        panel.add(new JLabel("Dirección - Ciudad:"));          panel.add(txtCiudad);
        panel.add(new JLabel("Dirección - Región:"));          panel.add(txtRegion);
        panel.add(new JLabel("Tipo de proveedor:"));           panel.add(cmbTipo);
        panel.add(new JLabel("Vehículo / Infraestructura:")); panel.add(txtEspecifico);

        int result = JOptionPane.showConfirmDialog(frame, panel,
            "Crear Proveedor", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) return;

        try {
            String nombre     = txtNombre.getText().trim();
            String apellido   = txtApellido.getText().trim();
            String rutStr     = txtRut.getText().trim();
            String telefono   = txtTelefono.getText().trim();
            String email      = txtEmail.getText().trim();
            String calle      = txtCalle.getText().trim();
            String comuna     = txtComuna.getText().trim();
            String ciudad     = txtCiudad.getText().trim();
            String region     = txtRegion.getText().trim();
            String tipo       = (String) cmbTipo.getSelectedItem();
            String especifico = txtEspecifico.getText().trim();

            if (nombre.isBlank() || apellido.isBlank() || rutStr.isBlank()
                    || telefono.isBlank() || email.isBlank() || calle.isBlank()
                    || comuna.isBlank() || ciudad.isBlank() || region.isBlank()
                    || especifico.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int numero = Integer.parseInt(txtNumero.getText().trim());
            Rut rut = new Rut(rutStr);
            Direccion dir = new Direccion(calle, numero, comuna, ciudad, region);
            Proveedor proveedor;
            if ("transporte".equals(tipo)) {
                proveedor = Proveedor.crearTransporte(nombre, apellido, dir, telefono, email, rut, especifico);
            } else {
                proveedor = Proveedor.crearAlojamiento(nombre, apellido, dir, telefono, email, rut, especifico);
            }
            gestor.agregarEntidad(proveedor);
            JOptionPane.showMessageDialog(frame, gestor.getMensajeCreacion(proveedor),
                "Entidad Registrada", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "El número de dirección debe ser un entero.",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (RutInvalidoException e) {
            JOptionPane.showMessageDialog(frame, "RUT inválido: " + e.getMessage(),
                "Error de RUT", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void buscarClientePorRut(JFrame frame) {
        String rut = JOptionPane.showInputDialog(frame, "Ingrese el RUT del cliente (ej: 12345678-9):",
            "Buscar Cliente", JOptionPane.QUESTION_MESSAGE);
        if (rut == null || rut.isBlank()) return;
        Cliente c = gestor.buscarClientePorRut(rut.trim());
        if (c == null) {
            JOptionPane.showMessageDialog(frame, "No se encontró ningún cliente con RUT: " + rut,
                "Cliente no encontrado", JOptionPane.WARNING_MESSAGE);
        } else {
            String info = "Nombre: " + c.getNombre() + " " + c.getApellido() + "\n"
                + "RUT: " + c.getRut().getRut() + "\n"
                + "Teléfono: " + c.getTelefono() + "\n"
                + "Email: " + c.getEmail() + "\n"
                + "Dirección: " + c.getDireccion() + "\n"
                + "Nacionalidad: " + c.getNacionalidad() + "\n"
                + "Tipo: " + c.getTipoCliente();
            JOptionPane.showMessageDialog(frame, info, "Cliente Encontrado", JOptionPane.INFORMATION_MESSAGE);
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