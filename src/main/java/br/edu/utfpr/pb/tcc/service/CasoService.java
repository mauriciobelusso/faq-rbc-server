package br.edu.utfpr.pb.tcc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc.model.Caso;
import br.edu.utfpr.pb.tcc.model.CasoRelevante;
import br.edu.utfpr.pb.tcc.model.Palavra;
import br.edu.utfpr.pb.tcc.model.Sinonimo;
import br.edu.utfpr.pb.tcc.repository.CasoRepository;

@Service
public class CasoService {

	private CasoRepository casoRepository;
	private List<Caso> baseCasos;
	private List<CasoRelevante> casosRelevantes;

	@Autowired
	public CasoService(CasoRepository casoRepository) {
		super();
		this.casoRepository = casoRepository;
		this.casosRelevantes = new ArrayList<>();
	}

	private void carregarBaseCasos() {
		baseCasos = casoRepository.findAll();
	}

	private void calcularSimilaridade(String[] palavras) {
		casosRelevantes.clear();
		carregarBaseCasos();
		for (Caso caso : baseCasos) {
			Integer relevancia = 0;
			CasoRelevante casoRelevante = (CasoRelevante) caso;
			for (int i = 0; i < palavras.length; i++) {
				String palavra = palavras[i];
				if (caso.getPalavras().contains(new Palavra(palavra))) {
					casoRelevante.setRelevancia(++relevancia);
					casosRelevantes.add(casoRelevante);
				} else {
					for (Palavra plv : caso.getPalavras()) {
						if (plv.getSinonimos().contains(new Sinonimo(palavra))) {
							casoRelevante.setRelevancia(++relevancia);
							casosRelevantes.add(casoRelevante);
						}
					}
				}
			}
		}
	}

	public List<CasoRelevante> getCasosRelevantes(String contexto) {
		calcularSimilaridade(contexto.split(" "));
		return casosRelevantes;
	}
}
