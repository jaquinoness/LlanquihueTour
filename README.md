![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# Llanquihue Tour App

## 👤 Autor del proyecto
- **Nombre completo:** Javiera Quiñones Sandoval
- **Sección:** 
- **Carrera:** Analista Programador Computacional
- **Sede:** Campus Online

---

## 📘 Propósito del sistema

**LlanquihueTour** es un prototipo de software modular desarrollado en Java para la agencia de turismo **Llanquihue Tour**, ubicada en la región de Los Lagos. Su objetivo es digitalizar la gestión operativa de la agencia: registrar clientes, colaboradores y servicios turísticos de forma estructurada, reemplazando los procesos manuales que generan errores y pérdida de información.

El sistema aplica los principios fundamentales de la **Programación Orientada a Objetos**:
- **Encapsulamiento** — atributos privados con getters y setters en todas las clases.
- **Herencia** — jerarquías `Persona → Cliente / GuiaTuristico / OperadorLocal / Proveedor` y `ServicioTuristico → PaseoLacustre / ExcursionCultural / RutaGastronomica`.
- **Polimorfismo** — lista `ArrayList<Registrable>` que gestiona distintos tipos bajo un contrato común.
- **Composición** — `Persona` contiene `Direccion` y `Rut`.
- **Interfaces** — `Registrable` define `registrar()` y `mostrarDatos()` para todas las entidades.
- **Colecciones** — `ArrayList<Registrable>` para la gestión general y `HashMap<String, Cliente>` para búsqueda eficiente por RUT.
- **Archivos .txt** — datos de prueba cargados al inicio desde `recursos/clientes.txt` y `recursos/servicios.txt`.
- **Excepciones personalizadas** — `RutInvalidoException` valida el formato del RUT chileno.

---

## 🧱 Estructura del proyecto

```plaintext
📁 LlanquihueTour/
├── recursos/
│   ├── clientes.txt                      # Datos de prueba: clientes
│   └── servicios.txt                     # Datos de prueba: servicios turísticos
└── src/
    ├── app/
    │   └── Main.java                     # Punto de entrada y GUI (Java Swing)
    ├── data/
    │   └── GestorEntidades.java          # ArrayList<Registrable> + HashMap<String, Cliente>
    ├── model/
    │   ├── Registrable.java              # Interfaz: registrar() y mostrarDatos()
    │   ├── Rut.java                      # Validación de RUT chileno
    │   ├── Direccion.java                # Clase de composición para direcciones
    │   ├── colaboradores/
    │   │   ├── Persona.java              # Clase base de personas
    │   │   ├── Cliente.java              # Extiende Persona, implementa Registrable
    │   │   ├── GuiaTuristico.java        # Extiende Persona, implementa Registrable
    │   │   ├── OperadorLocal.java        # Extiende Persona, implementa Registrable
    │   │   └── Proveedor.java            # Extiende Persona, implementa Registrable
    │   └── servicios/
    │       ├── ServicioTuristico.java    # Clase base de servicios turísticos
    │       ├── PaseoLacustre.java        # Extiende ServicioTuristico, implementa Registrable
    │       ├── ExcursionCultural.java    # Extiende ServicioTuristico, implementa Registrable
    │       └── RutaGastronomica.java     # Extiende ServicioTuristico, implementa Registrable
    └── util/
        ├── LectorDatos.java              # Lee archivos .txt y los convierte en objetos
        └── RutInvalidoException.java     # Excepción personalizada para RUT inválido
```

---

## 🔷 Clases e interfaces

| Elemento | Tipo | Descripción |
|---|---|---|
| `Registrable` | Interfaz | Contrato común: `registrar()` y `mostrarDatos()` |
| `GestorEntidades` | Clase | Gestiona `ArrayList<Registrable>` y `HashMap<String, Cliente>` |
| `LectorDatos` | Clase utilitaria | Carga clientes y servicios desde archivos `.txt` |
| `Persona` | Clase base | Superclase de todos los colaboradores y clientes |
| `Cliente` | Clase | Extiende `Persona`, incluye nacionalidad y tipo de cliente |
| `GuiaTuristico` | Clase | Extiende `Persona`, incluye zona y especialidad |
| `OperadorLocal` | Clase | Extiende `Persona`, incluye sucursal y cargo |
| `Proveedor` | Clase | Extiende `Persona`, factory methods para transporte/alojamiento |
| `ServicioTuristico` | Clase base | Superclase de los servicios turísticos |
| `PaseoLacustre` | Clase | Servicio de paseo lacustre con embarcación y valor |
| `ExcursionCultural` | Clase | Servicio de excursión a lugar histórico |
| `RutaGastronomica` | Clase | Servicio de ruta con paradas gastronómicas |
| `Rut` | Clase | Encapsula y valida el RUT chileno |
| `Direccion` | Clase | Composición usada en todas las personas |
| `RutInvalidoException` | Excepción | Lanzada cuando el formato del RUT no es válido |

---

## ⚙️ Instrucciones de ejecución

### Requisitos previos
- **Java 11 o superior** (el proyecto usa `String.isBlank()`)
- **IntelliJ IDEA** u otro IDE compatible con Java

### Pasos

1. Clona el repositorio:

```bash
git clone https://github.com/jaquinoness/LlanquihueTour.git
```

2. Abre el proyecto en IntelliJ IDEA como proyecto Java existente.

3. Verifica que el **directorio de trabajo** esté configurado en la raíz del proyecto:
   - Ve a **Run → Edit Configurations**
   - En **Working directory**, asegúrate que apunta a la carpeta `LlanquihueTour/` (donde están `src/` y `recursos/`)

4. Ejecuta la clase `src/app/Main.java`.

5. Al iniciar, el sistema carga automáticamente los datos desde `recursos/clientes.txt` y `recursos/servicios.txt`.

6. La ventana principal presenta las siguientes funciones:

| Botón | Descripción |
|---|---|
| Crear Paseo Lacustre | Registra un nuevo paseo lacustre |
| Crear Excursión Cultural | Registra una nueva excursión cultural |
| Crear Ruta Gastronómica | Registra una nueva ruta gastronómica |
| Crear Guía Turístico | Registra un nuevo guía con datos personales |
| Crear Operador Local | Registra un operador de sucursal |
| Crear Proveedor | Registra un proveedor de transporte o alojamiento |
| Crear Cliente | Registra un cliente nacional o extranjero |
| Buscar Cliente por RUT | Consulta el `HashMap` por RUT ingresado |
| Ver Resumen de Entidades | Muestra todas las entidades registradas |
| Salir | Cierra la aplicación |

> **Nota:** El RUT debe ingresarse en formato `12345678-9` (dígitos, guión, dígito verificador). Cualquier otro formato mostrará un error.

---

**Repositorio GitHub:** https://github.com/jaquinoness/LlanquihueTour.git

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Evaluación Final Transversal EFT




