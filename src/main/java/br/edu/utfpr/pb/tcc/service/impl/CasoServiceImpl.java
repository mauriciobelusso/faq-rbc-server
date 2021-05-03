package br.edu.utfpr.pb.tcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.tcc.model.Caso;
import br.edu.utfpr.pb.tcc.model.CasoSimilaridade;
import br.edu.utfpr.pb.tcc.repository.CasoRepository;
import br.edu.utfpr.pb.tcc.service.CasoRBCService;
import br.edu.utfpr.pb.tcc.service.CasoService;

@Service
public class CasoServiceImpl extends CrudServiceImpl<Caso, Long> implements CasoService{

	@Autowired
	private CasoRepository casoRepository;
	
	@Autowired
	private CasoRBCService casoRBCService;
	
	@Override
	protected JpaRepository<Caso, Long> getRepository() {
		return casoRepository;
	}

	@Override
	public List<CasoSimilaridade> findBySearch(String search) {
		return casoRBCService.findBySearch(search);
	}
}
