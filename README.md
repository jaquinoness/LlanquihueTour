![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Actividad 8: Interfaces e integración con colecciones genéricas

## 👤 Autor del proyecto
- **Nombre completo:** Javiera Quiñones Sandoval
- **Sección:** 
- **Carrera:** Analista Programador Computacional
- **Sede:** Campus Online

---

## 📘 Descripción general del sistema

**LlanquihueTour** es un sistema de gestión turística desarrollado en Java que modela una agencia de turismo de la región de Los Lagos. Permite registrar y visualizar dos tipos de entidades del dominio: servicios turísticos y colaboradores.

El sistema ha sido actualizado para incorporar:
- Una **interfaz gráfica** (GUI) construida con `JFrame` y `JOptionPane` de Java Swing.
- Una **colección polimórfica** gestionada por la clase `GestorEntidades`, que almacena objetos de distintas clases bajo el tipo común `Registrable`.
- Uso del operador `instanceof` para identificar el tipo concreto de cada objeto y aplicar lógica diferenciada.
- Captura del método `mostrarResumen()` de la interfaz para visualizar los datos en un panel de resumen dentro de la GUI.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 src/
├── app/
│   └── Main.java                        # Clase principal — punto de entrada y GUI
├── data/
│   └── GestorEntidades.java             # Gestión de la colección ArrayList<Registrable>
├── model/
│   ├── Registrable.java                 # Interfaz con mostrarResumen()
│   ├── Rut.java                         # Clase con validación de RUT chileno
│   ├── Direccion.java                   # Clase de composición para direcciones
│   ├── colaboradores/
│   │   ├── Persona.java                 # Clase base de colaboradores
│   │   ├── GuiaTuristico.java           # Implementa Registrable
│   │   ├── OperadorLocal.java           # Implementa Registrable
│   │   └── Proveedor.java               # Implementa Registrable
│   └── servicios/
│       ├── ServicioTuristico.java        # Clase base de servicios
│       ├── PaseoLacustre.java            # Implementa Registrable
│       ├── ExcursionCultural.java        # Implementa Registrable
│       └── RutaGastronomica.java         # Implementa Registrable
└── util/
    └── RutInvalidoException.java         # Excepción personalizada para RUT inválido
```

---

## 🔷 Clases e interfaces utilizadas

| Elemento | Tipo | Descripción |
|---|---|---|
| `Registrable` | Interfaz | Define el contrato `mostrarResumen()` para todas las entidades |
| `GestorEntidades` | Clase | Administra `ArrayList<Registrable>`, usa `for-each` e `instanceof` |
| `ServicioTuristico` | Clase abstracta base | Superclase de los servicios turísticos |
| `PaseoLacustre` | Clase | Servicio de paseo en lago, implementa `Registrable` |
| `ExcursionCultural` | Clase | Servicio de excursión cultural, implementa `Registrable` |
| `RutaGastronomica` | Clase | Servicio de ruta gastronómica, implementa `Registrable` |
| `Persona` | Clase base | Superclase de los colaboradores |
| `GuiaTuristico` | Clase | Colaborador guía turístico, implementa `Registrable` |
| `OperadorLocal` | Clase | Colaborador operador de planta, implementa `Registrable` |
| `Proveedor` | Clase | Colaborador proveedor, implementa `Registrable` |
| `Rut` | Clase | Encapsula y valida el RUT chileno con `RutInvalidoException` |
| `Direccion` | Clase | Composición utilizada por las personas |
| `RutInvalidoException` | Excepción personalizada | Lanzada cuando el formato del RUT es inválido |

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/jaquinoness/LlanquihueTour.git
```

2. Abre el proyecto en **IntelliJ IDEA** (o cualquier IDE compatible con Java).

3. Verifica que el JDK configurado sea **Java 11 o superior** (se usa `String.isBlank()`).

4. Ejecuta la clase principal desde la ruta:

```
src/app/Main.java
```

5. Se abrirá una ventana gráfica con las siguientes opciones:
   - **Crear Paseo Lacustre** → completa el formulario en panel único y confirma.
   - **Crear Guía Turístico** → completa el formulario con datos personales y dirección.
   - **Ver Resumen de Entidades** → muestra todas las entidades registradas con su `mostrarResumen()`.
   - **Salir** → cierra la aplicación.

> **Nota:** El RUT debe ingresarse en formato `12345678-9` (dígitos, guión, dígito verificador). Cualquier otro formato mostrará un error.

---

**Repositorio GitHub:** https://github.com/jaquinoness/LlanquihueTour.git
**Fecha de entrega:** 08/06/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Evaluación Final Transversal EFT




