package br.edu.utfpr.pb.tcc.model;

import java.io.Serializable;

public class CasoSimilaridade implements Serializable {

	private static final long serialVersionUID = 1L;

	private Caso caso;
	private Double similaridade;
	
	public CasoSimilaridade(Caso caso, Double similaridade) {
		this.caso = caso;
		this.similaridade = similaridade;
	}

	public Double getSimilaridade() {
		return similaridade;
	}

	public void setSimilaridade(Double similaridade) {
		this.similaridade = similaridade;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}
}
