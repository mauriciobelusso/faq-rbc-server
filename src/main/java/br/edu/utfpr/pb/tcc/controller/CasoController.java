package br.edu.utfpr.pb.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc.model.Caso;
import br.edu.utfpr.pb.tcc.service.CasoService;
import br.edu.utfpr.pb.tcc.service.CrudService;

@RestController
@RequestMapping("caso")
public class CasoController extends CrudController<Caso, Long>{

	@Autowired
	private CasoService casoService;

	@Override
	protected CrudService<Caso, Long> getService() {
		return casoService;
	}
}
