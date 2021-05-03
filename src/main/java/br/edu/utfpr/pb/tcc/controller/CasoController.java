package br.edu.utfpr.pb.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc.model.Caso;
import br.edu.utfpr.pb.tcc.model.CasoSimilaridade;
import br.edu.utfpr.pb.tcc.service.CasoService;

@RestController
@RequestMapping("caso")
public class CasoController extends CrudController<Caso, Long>{

	@Autowired
	private CasoService casoService;
	

	@Override
	protected CasoService getService() {
		return casoService;
	}

	@GetMapping("search")
	public List<CasoSimilaridade> findBySearch(String search){
		return getService().findBySearch(search);
	}
}
