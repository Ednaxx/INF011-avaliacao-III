package br.ifba.edu.aval.model.apuracao;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public interface RegraApuracao {
    ResultadoRegra aplicar(BoletimProva boletim, ContextoApuracao contexto) 
        throws DNFException, AtividadeNaoPermitidaException;
}
