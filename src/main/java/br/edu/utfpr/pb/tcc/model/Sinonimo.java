package br.edu.utfpr.pb.tcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sinonimo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 250, nullable = false)
	private String sinonimo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Palavra palavra;

	public Sinonimo(Long id, String sinonimo, Palavra palavra) {
		super();
		this.id = id;
		this.sinonimo = sinonimo;
		this.palavra = palavra;
	}
	
	

	public Sinonimo(String sinonimo) {
		super();
		this.sinonimo = sinonimo;
	}



	public Sinonimo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSinonimo() {
		return sinonimo;
	}

	public void setSinonimo(String sinonimo) {
		this.sinonimo = sinonimo;
	}

	public Palavra getPalavra() {
		return palavra;
	}

	public void setPalavra(Palavra palavra) {
		this.palavra = palavra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sinonimo == null) ? 0 : sinonimo.hashCode());
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
		Sinonimo other = (Sinonimo) obj;
		if (sinonimo == null) {
			if (other.sinonimo != null)
				return false;
		} else if (!sinonimo.equalsIgnoreCase(other.sinonimo))
			return false;
		return true;
	}
	
	
}
