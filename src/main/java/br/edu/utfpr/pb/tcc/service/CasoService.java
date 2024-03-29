package br.edu.utfpr.pb.tcc.service;

import java.util.List;

import br.edu.utfpr.pb.tcc.model.Caso;
import br.edu.utfpr.pb.tcc.model.CasoSimilaridade;

public interface CasoService extends CrudService<Caso, Long>{

	List<CasoSimilaridade> findBySearch(String search); 
}
