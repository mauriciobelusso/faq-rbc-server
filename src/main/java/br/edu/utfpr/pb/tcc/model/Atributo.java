package br.edu.utfpr.pb.tcc.model;

public class Atributo {

	private String descricao;
	private Double peso;
	private Double pesoMaximo;
	private Double pesoMinimo;
	
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
