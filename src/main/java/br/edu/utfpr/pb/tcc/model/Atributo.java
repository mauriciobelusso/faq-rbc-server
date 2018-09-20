package br.edu.utfpr.pb.tcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "atributo")
@Data
@EqualsAndHashCode(of = "id")
public class Atributo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 250)
	private String descricao;
	@Column(length = 250)
	private String descricaoFilter;
	@Column(length = 500)
	private String observacao;
}
