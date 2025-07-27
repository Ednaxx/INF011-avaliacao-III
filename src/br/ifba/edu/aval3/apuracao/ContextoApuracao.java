package br.ifba.edu.aval3.apuracao;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ContextoApuracao {
    private Duration tempoMaximo;
    private Duration tempoAcumulado;
    private List<String> observacoes;
    
    public ContextoApuracao() {
        this.tempoAcumulado = Duration.ZERO;
        this.observacoes = new ArrayList<>();
    }
    
    public ContextoApuracao(Duration tempoMaximo) {
        this();
        this.tempoMaximo = tempoMaximo;
    }
    
    public Duration getTempoMaximo() {
        return tempoMaximo;
    }
    
    public void setTempoMaximo(Duration tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }
    
    public Duration getTempoAcumulado() {
        return tempoAcumulado;
    }
    
    public void setTempoAcumulado(Duration tempoAcumulado) {
        this.tempoAcumulado = tempoAcumulado;
    }
    
    public void adicionarTempo(Duration tempo) {
        this.tempoAcumulado = this.tempoAcumulado.plus(tempo);
    }
    
    public List<String> getObservacoes() {
        return observacoes;
    }
    
    public void adicionarObservacao(String observacao) {
        this.observacoes.add(observacao);
    }
}
