package model.servicios;

/*
* Clase que representa un servicio turístico ofrecido por la empresa
*/
public class ServicioTuristico {
    private String nombre;
    private int duracionHoras;
    
    /*
     * Constructor de la clase ServicioTuristico
     * @param nombre nombre del servicio turístico
     * @param duracionHoras duración del servicio turístico en horas
     */
    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }
    
    // getters
    public String getNombre() {
        return nombre;
    }
    
    public int getDuracionHoras() {
        return duracionHoras;
    }
    
    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    // dejamos este metodo comentado ya que tenemos el metodo de la interfaz
    // public void mostrarInformacion(){}

    @Override
    public String toString() {
        return "ServicioTuristico [nombre=" + nombre + ", duracionHoras=" + duracionHoras + "]";
    }
}
