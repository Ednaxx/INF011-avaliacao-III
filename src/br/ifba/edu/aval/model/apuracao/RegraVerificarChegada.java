package br.ifba.edu.aval.model.apuracao;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class RegraVerificarChegada implements RegraApuracao {

    @Override
    public ResultadoRegra aplicar(BoletimProva boletim, ContextoApuracao contexto) 
            throws DNFException, AtividadeNaoPermitidaException {
        
        Duration tempoChegada = boletim.getTempo(Prisma.CHEGADA);
        
        if (tempoChegada == null) {
            throw new DNFException("Atleta não registrou chegada");
        }
        
        contexto.setTempoAcumulado(tempoChegada);
        contexto.adicionarObservacao("Chegada registrada em " + tempoChegada);
        
        return ResultadoRegra.sucesso("Chegada verificada");
    }
}
