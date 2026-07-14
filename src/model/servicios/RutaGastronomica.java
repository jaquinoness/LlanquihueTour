package model.servicios;

import model.Registrable;

/**
 * Clase que representa el servicio de ruta gastronómica
 */
public class RutaGastronomica extends ServicioTuristico implements Registrable{
    private int numeroDeParadas;
    private String horaPartida;
    private int valor;

    /**
     * Constructor de la clase RutaGastronomica
     * @param nombre nombre de la ruta gastronómica
     * @param duracionHoras duración de la ruta gastronómica en horas
     * @param numeroDeParadas número de paradas de la ruta gastronómica
     * @param horaPartida hora de partida de la ruta gastronómica
     * @param valor valor del servicio
     */
    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas, String horaPartida, int valor) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
        this.horaPartida = horaPartida;
        this.valor = valor;
    }
    
    // getters
    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }
    
    public String getHoraPartida() {
        return horaPartida;
    }
    
    public int getValor() {
        return valor;
    }
    
    // setters
    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }
    
    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    // overrides
    @Override
    public String toString() {
        return "Ruta Gastronómica [numero de paradas: " + numeroDeParadas + ", hora de partida: " + horaPartida + ", valor: " + valor + "]";
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Ruta Gastronómica: " + getNombre());
        System.out.println("Duración: " + getDuracionHoras() + " horas");
        System.out.println("Número de paradas: " + numeroDeParadas);
        System.out.println("Hora de partida: " + horaPartida);
        System.out.println("Valor: " + valor);
    }
}
