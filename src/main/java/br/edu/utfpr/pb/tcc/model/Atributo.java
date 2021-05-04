package br.edu.utfpr.pb.tcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Atributo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descricao", length = 50)
	private String descricao;
	private Double peso;
	private Double pesoMaximo;
	private Double pesoMinimo;
	
	public Atributo() {
		this.descricao = "";
		this.peso = 0D;
		this.pesoMaximo = 0D;
		this.pesoMinimo = 0D;
	}
	
	public Atributo(String descricao, Double peso, Double pesoMaximo, Double pesoMinimo) {
		this.descricao = descricao;
		this.peso = peso;
		this.pesoMaximo = pesoMaximo;
		this.pesoMinimo = pesoMinimo;
	}
	
	public Double getPesoMaximo() {
		return pesoMaximo;
	}
	public void setPesoMaximo(Double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}
	public Double getPesoMinimo() {
		return pesoMinimo;
	}
	public void setPesoMinimo(Double pesoMinimo) {
		this.pesoMinimo = pesoMinimo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	
}
