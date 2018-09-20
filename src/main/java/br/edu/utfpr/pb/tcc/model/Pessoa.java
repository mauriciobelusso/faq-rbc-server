package br.edu.utfpr.pb.tcc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pessoa")
@Data
@EqualsAndHashCode(of = "id")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100)
	private String nome;
	
	@Column(length=100)
	private String apelido;
	
	@Column(length=15)
	private String inscricao;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
}
