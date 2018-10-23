package br.edu.utfpr.pb.tcc.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "caso")
@Data
@EqualsAndHashCode(of = "id")
public class Caso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idSetor")
	private Setor setor;
	
	@Column(length=500)
	private String titulo;
	
	@Column(length=4000)
	private String conteudo;
	
	@Column(length=4000)
	private String diagnostico;
	
	private Boolean ativo;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy="caso")
    private Set<CasoAtributo> casoAtributos;
}
