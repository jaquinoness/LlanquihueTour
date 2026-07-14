package model.servicios;

import model.Registrable;

/**
 * Clase que representa el servicio de excursión hacia algún lugar histórico de interés
 */
public class ExcursionCultural extends ServicioTuristico implements Registrable {
    private String lugarHistorico;
    private String horaPartida;
    private int valor;
    
    
    /**
     * Constructor de la clase ExcursionCultural
     * @param nombre nombre de la excursión
     * @param duracionHoras duración de la excursión en horas
     * @param lugarHistorico lugar histórico de la excursión
     * @param horaPartida hora de partida de la excursión
     * @param valor valor del servicio
     */
    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico, String horaPartida, int valor) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
        this.horaPartida = horaPartida;
        this.valor = valor;
    }
    
    // getters
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public String getHoraPartida() {
        return horaPartida;
    }
    
    public int getValor() {
        return valor;
    }
    
    // setters
    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
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
        return "ExcursionCultural [lugar historico:" + lugarHistorico + ", hora de partida:" + horaPartida + ", valor:" + valor + "]";
    }
    
    @Override
    public void mostrarResumen() {
        System.out.println("Excursión Cultural: " + getNombre());
        System.out.println("Duración: " + getDuracionHoras() + " horas");
        System.out.println("Lugar histórico: " + lugarHistorico);
        System.out.println("Hora de partida: " + horaPartida);
        System.out.println("Valor: " + valor);
    }
}
