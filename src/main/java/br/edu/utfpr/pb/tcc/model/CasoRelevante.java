package br.edu.utfpr.pb.tcc.model;

import java.io.Serializable;
import java.util.Set;

public class CasoRelevante extends Caso implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer relevancia;
	private Double peso;
	
	public CasoRelevante(Long id, String descricao, String solucao, Set<Palavra> tags, Integer relevancia, Double peso) {
		super(id, descricao, solucao, tags);
		this.relevancia = relevancia;
		this.peso = peso;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getRelevancia() {
		return relevancia;
	}

	public void setRelevancia(Integer relevancia) {
		this.relevancia = relevancia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CasoRelevante other = (CasoRelevante) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
