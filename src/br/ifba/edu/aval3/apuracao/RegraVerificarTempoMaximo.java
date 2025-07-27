package br.ifba.edu.aval3.apuracao;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public class RegraVerificarTempoMaximo implements RegraApuracao {

    @Override
    public ResultadoRegra aplicar(BoletimProva boletim, ContextoApuracao contexto) 
            throws DNFException, AtividadeNaoPermitidaException {
        
        if (contexto.getTempoMaximo() == null) {
            return ResultadoRegra.sucesso("Sem limite de tempo configurado");
        }
        
        if (contexto.getTempoAcumulado().compareTo(contexto.getTempoMaximo()) > 0) {
            throw new DNFException("O atleta finalizou a prova, após o tempo limite");
        }
        
        contexto.adicionarObservacao("Tempo dentro do limite: " + contexto.getTempoAcumulado() + 
                                   " <= " + contexto.getTempoMaximo());
        
        return ResultadoRegra.sucesso("Tempo máximo verificado");
    }
}
