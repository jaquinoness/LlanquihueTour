package model;

import util.RutInvalidoException;

/**
 * Clase que representa un RUT chileno. Contiene validacion del formato.
 */
public class Rut {

    private String rut;
    
    /**
     * Constructor de la clase Rut.
     * @param rut El RUT a validar.
     * @throws RutInvalidoException Si el RUT no es válido.
     */
    public Rut(String rut) throws RutInvalidoException {
        // validamos rut
        validarRut(rut);
        this.rut = rut;
    }
    
    /**
     * Getter del RUT.
     * @return El RUT.
     */
    public String getRut() {
        return rut;
    }
    
    /**
     * Setter del RUT.
     * @param rut El RUT a establecer.
     * @throws RutInvalidoException Si el RUT no es válido.
     */
    public void setRut(String rut) throws RutInvalidoException {
        // validamos rut
        validarRut(rut);
        this.rut = rut;
    }

    // creamos una funcion para reutilizarla dentro del constructor y el setter
    /**
     * Valida el formato del RUT.
     * @param rut El RUT a validar.
     * @throws RutInvalidoException Si el RUT no es válido.
     */
    private void validarRut(String rut) throws RutInvalidoException {
        if (!rut.matches("[0-9]+-[0-9kK]")) {
            throw new RutInvalidoException("Formato de RUT no válido.");
        }
    }

    /**
     * Método para mostrar la información del RUT.
     * @return La información del RUT.
     */
    @Override
    public String toString() {
        return "Rut: " + rut;
    }
}
