package br.edu.utfpr.pb.tcc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.utfpr.pb.tcc.utils.StringUtils;

public class CasoRBC {
	
	private List<Caso> casos;
    private List<CasoSimilaridade> casosSimilares = new ArrayList<>();
    private StringUtils stringUtils = new StringUtils(); 
	
	public void processar(List<Caso> casos, Caso novoCaso) {
		this.casos = casos;
        List<CasoSimilaridade> casosSimilares = new ArrayList<>();
                
        this.casos
        	.forEach(
        		caso -> 
        		casosSimilares.add(
        				similaridade(novoCaso, caso)
        		)
        	);
        
        this.casosSimilares.addAll(
	    	casosSimilares
	        	.stream()
	        	.sorted(
	        			(caso1, caso2) -> 
	        				caso1.getSimilaridade() >= caso2.getSimilaridade() ? -1 : 1
	        	)
	        	.filter(caso -> caso.getSimilaridade() > 0)
	        	.collect(Collectors.toList())
        );
	}
	
	private CasoSimilaridade similaridade(Caso novoCaso, Caso caso) {        
		SomaSimilaridade somaSimilaridade = new SomaSimilaridade();
		
        caso.getAtributos().forEach(atributo -> {
        	if (novoCaso
        			.getAtributos()
        			.stream()
        			.anyMatch(a -> 
        				stringUtils
        				.removerAcentos(
        						a.getDescricao()
        						)
        				.equalsIgnoreCase(
        						stringUtils.removerAcentos(
        								atributo.getDescricao()
        								)
        						)
        				)
        			) {
        		somaSimilaridade.add(atributo.getPeso());
        	}
    	});

        CasoAtributoPeso peso = new CasoAtributoPeso();
        
        peso.setAtributos(caso.getAtributos());

        if (peso.getTotal() > 0) {
            return new CasoSimilaridade(caso, somaSimilaridade.value() / peso.getTotal());	
        } else {
        	return new CasoSimilaridade(caso, 0D);
        }
    }

	public List<CasoSimilaridade> getCasosSimilares() {
		return casosSimilares;
	}
	
	private class SomaSimilaridade {
		private Double soma = 0D;
		
		public void add(Double value) {
			soma += value;
		}
		
		public Double value() {
			return soma;
		}
	}
}
