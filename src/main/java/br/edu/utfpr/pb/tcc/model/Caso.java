package br.edu.utfpr.pb.tcc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Caso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 4000)
	private String descricao;
	@Column(length = 4000)
	private String solucao;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Palavra> palavras;

	public Caso() {
	}
	
	public Caso(Long id, String descricao, String solucao, Set<Palavra> palavras) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.solucao = solucao;
		this.palavras = palavras;
	}

	public void addPalavra(Palavra palavra) {
		if (this.palavras == null) {
			this.palavras = new HashSet<>();
		}
		this.palavras.add(palavra);
	}
	
	public Set<Palavra> getPalavras() {
		return palavras;
	}

	public void setPalavras(Set<Palavra> palavras) {
		this.palavras = palavras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caso other = (Caso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
