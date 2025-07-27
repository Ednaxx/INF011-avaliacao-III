package br.ifba.edu.aval.model;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.apuracao.CadeiaApuracao;
import br.ifba.edu.aval.model.apuracao.ContextoApuracao;

public class Apurador {
	
	private CadeiaApuracao cadeia;
	private ContextoApuracao contextoBase;
	
	public Apurador(CadeiaApuracao cadeia, ContextoApuracao contexto) {
		this.cadeia = cadeia;
		this.contextoBase = contexto;
	}
	
	public Duration apurar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException {
		ContextoApuracao contextoApuracao = new ContextoApuracao(contextoBase.getTempoMaximo());
		return cadeia.processar(boletim, contextoApuracao);
	}	
}
