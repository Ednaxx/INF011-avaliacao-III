package br.ifba.edu.aval.model.apuracao;

import java.time.Duration;

public class ResultadoRegra {
    public enum TipoResultado {
        SUCESSO,
        PENALIZACAO,
        ERRO_FATAL
    }
    
    private final TipoResultado tipo;
    private final Duration tempoAdicional;
    private final String mensagem;
    private final boolean continuarCadeia;
    
    private ResultadoRegra(TipoResultado tipo, Duration tempoAdicional, String mensagem, boolean continuarCadeia) {
        this.tipo = tipo;
        this.tempoAdicional = tempoAdicional;
        this.mensagem = mensagem;
        this.continuarCadeia = continuarCadeia;
    }
    
    public static ResultadoRegra sucesso() {
        return new ResultadoRegra(TipoResultado.SUCESSO, Duration.ZERO, null, true);
    }
    
    public static ResultadoRegra sucesso(String mensagem) {
        return new ResultadoRegra(TipoResultado.SUCESSO, Duration.ZERO, mensagem, true);
    }
    
    public static ResultadoRegra penalizacao(Duration tempoAdicional, String mensagem) {
        return new ResultadoRegra(TipoResultado.PENALIZACAO, tempoAdicional, mensagem, true);
    }
    
    public static ResultadoRegra erroFatal(String mensagem) {
        return new ResultadoRegra(TipoResultado.ERRO_FATAL, Duration.ZERO, mensagem, false);
    }
    
    public TipoResultado getTipo() {
        return tipo;
    }
    
    public Duration getTempoAdicional() {
        return tempoAdicional;
    }
    
    public String getMensagem() {
        return mensagem;
    }
    
    public boolean deveContinuarCadeia() {
        return continuarCadeia;
    }
}
