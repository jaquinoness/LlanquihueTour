package model.servicios;

import model.Registrable;

/**
 * Clase que representa el servicio de paseo en lago
 */
public class PaseoLacustre extends ServicioTuristico implements Registrable {
    private String tipoEmbarcacion;
    private String horaPartida;
    private int valor;      
    
    /**
     * Constructor de la clase PaseoLacustre
     * @param nombre nombre del paseo
     * @param duracionHoras duración del paseo en horas
     * @param tipoEmbarcacion tipo de embarcación del paseo
     * @param horaPartida hora de partida del paseo
     * @param valor valor del servicio
     */
    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion, String horaPartida, int valor) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
        this.horaPartida = horaPartida;
        this.valor = valor;
    }
    
    // getters
    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }
    
    public int getValor() {
        return valor;
    }
   
    public String getHoraPartida() {
        return horaPartida;
    }
    
    // setters
    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }
    
    // overrides
    @Override
    public String toString() {
        return "Paseo Lacustre [tipo de embarcacion:" + tipoEmbarcacion + ", hora de partida:" + horaPartida + ", valor:" + valor + "]";
    }
    
    @Override
    public void mostrarResumen() {
        System.out.println("Paseo Lacustre: " + getNombre());
        System.out.println("Duración: " + getDuracionHoras() + " horas");
        System.out.println("Tipo de embarcación: " + tipoEmbarcacion);
        System.out.println("Hora de partida: " + horaPartida);
        System.out.println("Valor: " + valor);
    }
}
