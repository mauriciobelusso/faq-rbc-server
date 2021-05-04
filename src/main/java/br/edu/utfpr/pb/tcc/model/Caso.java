package br.edu.utfpr.pb.tcc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Caso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 4000)
	private String titulo;
	@Column(length = 4000)
	private String conteudo;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Atributo> atributos;

	public Caso() {
	}
	
	public Caso(Long id, String titulo, String conteudo, Set<Atributo> atributos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.atributos = atributos;
	}
	
	public void addAtributo(Atributo atributo) {
		if (this.atributos == null) {
			this.atributos = new HashSet<Atributo>();
		}
		this.atributos.add(atributo);
	}
	
	public Atributo getAtributo(String descricao) {
		List<Atributo> atributos =
			this.atributos
					.stream()
					.filter(filter -> filter.getDescricao().equalsIgnoreCase(descricao))
					.collect(Collectors.toList());
		
		if(atributos.isEmpty()) {
			return new Atributo();
		}
		
		return atributos.get(0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Set<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(Set<Atributo> atributos) {
		this.atributos = atributos;
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
