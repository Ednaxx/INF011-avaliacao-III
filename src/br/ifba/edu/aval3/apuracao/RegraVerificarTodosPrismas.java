package br.ifba.edu.aval3.apuracao;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;

public class RegraVerificarTodosPrismas implements RegraApuracao {

    @Override
    public ResultadoRegra aplicar(BoletimProva boletim, ContextoApuracao contexto) 
            throws DNFException, AtividadeNaoPermitidaException {
        
        List<Integer> ordemPrismas = boletim.getOrdemPrismas();
        
        for (int i = 0; i < ordemPrismas.size() - 1; i++) {
            Duration tempo = boletim.getTempo(ordemPrismas.get(i));
            if (ordemPrismas.get(i) != Prisma.CHEGADA && tempo == null) {
                throw new DNFException("Atleta não registrou um dos prismas.");
            }
        }
        
        contexto.adicionarObservacao("Todos os prismas obrigatórios foram registrados");
        
        return ResultadoRegra.sucesso("Todos os prismas verificados");
    }
}
