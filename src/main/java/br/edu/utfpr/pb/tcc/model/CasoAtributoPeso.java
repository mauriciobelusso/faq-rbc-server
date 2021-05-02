package br.edu.utfpr.pb.tcc.model;

import java.util.Set;

public class CasoAtributoPeso {
	
	private Set<Atributo> atributos;

	public Set<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(Set<Atributo> atributos) {
		this.atributos = atributos;
	}
	
	public void addAtributo(Atributo atributo) {
		this.atributos.add(atributo);
	}
	
	public Double getTotal() {
		Double total = 0D;
		
		for (Atributo atributo : atributos) {
			total += atributo.getPeso();
		}
		
		return total;
	}
}
