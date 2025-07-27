package br.ifba.edu.aval.model.apuracao;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.aval.model.Apurador;

public class ConfiguradorApurador {
    private List<RegraApuracao> regras;
    private Duration tempoMaximo;
    
    public ConfiguradorApurador() {
        this.regras = new ArrayList<>();
    }
    
    public ConfiguradorApurador comVerificacaoChegada() {
        regras.add(new RegraVerificarChegada());
        return this;
    }
    
    public ConfiguradorApurador comVerificacaoTempoMaximo(Duration tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
        regras.add(new RegraVerificarTempoMaximo());
        return this;
    }
    
    public ConfiguradorApurador comVerificacaoOrdem() {
        regras.add(new RegraVerificarOrdemPrismas());
        return this;
    }
    
    public ConfiguradorApurador comVerificacaoTodosPrismas() {
        regras.add(new RegraVerificarTodosPrismas());
        return this;
    }
    
    public ConfiguradorApurador comPenalizacaoAtraso() {
        regras.add(new RegraPenalizacaoAtraso());
        return this;
    }
    
    public ConfiguradorApurador comRegra(RegraApuracao regra) {
        regras.add(regra);
        return this;
    }
    
    public Apurador construir() {
        CadeiaApuracao cadeia = new CadeiaApuracao(regras);
        ContextoApuracao contextoBase = new ContextoApuracao(tempoMaximo);
        return new Apurador(cadeia, contextoBase);
    }
    
    public ConfiguradorApurador reiniciar() {
        this.regras.clear();
        this.tempoMaximo = null;
        return this;
    }
}
