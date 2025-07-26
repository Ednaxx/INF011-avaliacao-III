package br.ifba.edu.aval.model.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public class EstadoMomentoLargada implements EstadoBoletimProva {

    @Override
    public void apresentarPraLargada(BoletimProva contexto) throws AtividadeNaoPermitidaException {
        // Já está na fase de momento da largada, operação redundante mas permitida
        // Não há mudança de estado
    }

    @Override
    public void registrarLargada(BoletimProva contexto) throws AtividadeNaoPermitidaException {
        contexto.alterarEstado(new EstadoPista());
    }

    @Override
    public void registrarAtrasoPartida(BoletimProva contexto, Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
        contexto.minutoPartidaEfetivo = minutoPartidaEfetivo;
    }

    @Override
    public Long getMinutosAtraso(BoletimProva contexto) throws AtividadeNaoPermitidaException {
        return contexto.minutoPartidaEfetivo - contexto.minutoPartidaPrevisto;
    }

    @Override
    public void registrar(BoletimProva contexto, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Não pode registrar prisma");
    }

    @Override
    public void registrarChegada(BoletimProva contexto, Duration tempo) throws AtividadeNaoPermitidaException {
        throw new AtividadeNaoPermitidaException("Fase não permite registro de chegada.");
    }
}
