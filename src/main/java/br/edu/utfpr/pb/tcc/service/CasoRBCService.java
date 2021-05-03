package br.edu.utfpr.pb.tcc.service;

import java.util.List;

import br.edu.utfpr.pb.tcc.model.CasoSimilaridade;

public interface CasoRBCService {

	List<CasoSimilaridade> findBySearch(String search); 
}
