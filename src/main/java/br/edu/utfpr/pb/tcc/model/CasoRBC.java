package br.edu.utfpr.pb.tcc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CasoRBC {
	
	private List<Caso> casos = new ArrayList<Caso>();
    private List<CasoSimilaridade> casosSimilares = new ArrayList<>();
	
	public void processar(Caso novoCaso, CasoAtributoPeso peso) {

        final List<CasoSimilaridade> casosSimilares = new ArrayList<>();
        
        casos.forEach(
        		caso -> 
        		casosSimilares.add(
        				similaridade(novoCaso, caso, peso)
        		)
        );
        
        this.casosSimilares =
	        casosSimilares
	        	.stream()
	        	.sorted(
	        			(caso1, caso2) -> 
	        				caso1.getSimilaridade() >= caso2.getSimilaridade() ? -1 : 1
	        	)
	        	.collect(Collectors.toList());
	}
	
	private Double SimilaridadeNumerica(Double a1, Double a2, Double max, Double min) {
        return (1.0 - (Math.abs(a2 - a1) / (max - min)));
    }
	
	private CasoSimilaridade similaridade(Caso novoCaso, Caso caso, CasoAtributoPeso peso) {
        Double somaSimilaridade = 0D;
        for (Atributo atributo : peso.getAtributos()) {
        	try {
				somaSimilaridade +=
					atributo.getPeso() *
				    	SimilaridadeNumerica(
				    			caso.getAtributo(atributo.getDescricao()).getPeso() ,
				    			novoCaso.getAtributo(atributo.getDescricao()).getPeso(),
				        		atributo.getPesoMaximo(),
				        		atributo.getPesoMinimo()
				        );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        
        return new CasoSimilaridade(caso, somaSimilaridade / peso.getTotal());
    }

	public List<CasoSimilaridade> getCasosSimilares() {
		return casosSimilares;
	}
}
