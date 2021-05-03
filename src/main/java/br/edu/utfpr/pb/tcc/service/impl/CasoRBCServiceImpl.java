package br.edu.utfpr.pb.tcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc.model.Atributo;
import br.edu.utfpr.pb.tcc.model.Caso;
import br.edu.utfpr.pb.tcc.model.CasoRBC;
import br.edu.utfpr.pb.tcc.model.CasoSimilaridade;
import br.edu.utfpr.pb.tcc.repository.CasoRepository;
import br.edu.utfpr.pb.tcc.service.CasoRBCService;

@Service
public class CasoRBCServiceImpl implements CasoRBCService {
	
	@Autowired
	private CasoRepository casoRepository;
	
	@Override
	public List<CasoSimilaridade> findBySearch(String search) {
		CasoRBC casoRBC = new CasoRBC();
		
		Caso novoCaso = new Caso();
		novoCaso.setTitulo(search);
		
		String[] atributos = search.split(" ");

		for (int i = 0; i < atributos.length; i++) {
			Atributo atributo = new Atributo();
			atributo.setDescricao(atributos[i]);
			novoCaso.addAtributo(atributo);
		}
		
		casoRBC.processar(casoRepository.findAll(), novoCaso);
		
		return casoRBC.getCasosSimilares();
	}
}
