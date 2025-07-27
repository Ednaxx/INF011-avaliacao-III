package br.ifba.edu.aval3.apuracao;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public class RegraPenalizacaoAtraso implements RegraApuracao {

    @Override
    public ResultadoRegra aplicar(BoletimProva boletim, ContextoApuracao contexto) 
            throws DNFException, AtividadeNaoPermitidaException {
        
        Long minutosAtraso = boletim.getMinutosAtraso();
        
        if (minutosAtraso > 0) {
            Duration penalizacao = Duration.ofMinutes(minutosAtraso);
            contexto.adicionarTempo(penalizacao);
            contexto.adicionarObservacao("Penalização por atraso: " + minutosAtraso + " minuto(s)");
            
            return ResultadoRegra.penalizacao(penalizacao, 
                "Penalização aplicada: " + minutosAtraso + " minuto(s) de atraso");
        }
        
        return ResultadoRegra.sucesso("Sem atraso na partida");
    }
}
