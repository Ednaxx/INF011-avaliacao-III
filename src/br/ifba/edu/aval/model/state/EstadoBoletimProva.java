package br.ifba.edu.aval.model.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public interface EstadoBoletimProva {
    
    void apresentarPraLargada(BoletimProva contexto) throws AtividadeNaoPermitidaException;
    
    void registrarLargada(BoletimProva contexto) throws AtividadeNaoPermitidaException;
    
    void registrarAtrasoPartida(BoletimProva contexto, Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException;
    
    Long getMinutosAtraso(BoletimProva contexto) throws AtividadeNaoPermitidaException;
    
    void registrar(BoletimProva contexto, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException;
    
    void registrarChegada(BoletimProva contexto, Duration tempo) throws AtividadeNaoPermitidaException;
}
