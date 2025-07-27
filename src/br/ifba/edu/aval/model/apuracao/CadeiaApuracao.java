package br.ifba.edu.aval.model.apuracao;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public class CadeiaApuracao {
    private final List<RegraApuracao> regras;
    
    public CadeiaApuracao() {
        this.regras = new ArrayList<>();
    }
    
    public CadeiaApuracao(List<RegraApuracao> regras) {
        this.regras = new ArrayList<>(regras);
    }
    
    public void adicionarRegra(RegraApuracao regra) {
        this.regras.add(regra);
    }
    
    public Duration processar(BoletimProva boletim, ContextoApuracao contexto) 
            throws DNFException, AtividadeNaoPermitidaException {
        
        for (RegraApuracao regra : regras) {
            ResultadoRegra resultado = regra.aplicar(boletim, contexto);
            
            if (!resultado.deveContinuarCadeia()) {
                throw new DNFException(resultado.getMensagem());
            }
        }
        
        return contexto.getTempoAcumulado();
    }
    
    public List<RegraApuracao> getRegras() {
        return new ArrayList<>(regras);
    }
}
