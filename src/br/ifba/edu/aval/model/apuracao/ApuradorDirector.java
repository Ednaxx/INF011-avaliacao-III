package br.ifba.edu.aval.model.apuracao;

import java.time.Duration;

import br.ifba.edu.aval.model.Apurador;

public class ApuradorDirector {
    private ConfiguradorApurador builder;
    
    public ApuradorDirector(ConfiguradorApurador builder) {
        this.builder = builder;
    }
    
    public Apurador construirApuradorCompleto(Duration tempoMaximo) {
        return builder.reiniciar()
                .comVerificacaoChegada()
                .comVerificacaoTempoMaximo(tempoMaximo)
                .comVerificacaoOrdem()
                .comVerificacaoTodosPrismas()
                .comPenalizacaoAtraso()
                .construir();
    }
}
