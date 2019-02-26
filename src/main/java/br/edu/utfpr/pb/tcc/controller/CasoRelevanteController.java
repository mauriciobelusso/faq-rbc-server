package br.edu.utfpr.pb.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc.model.CasoRelevante;
import br.edu.utfpr.pb.tcc.service.CasoService;

@RestController
@RequestMapping("/buscar")
public class CasoRelevanteController {

	@Autowired
	private CasoService casoService;

	@GetMapping(value = "/{contexto}")
	public List<CasoRelevante> buscar(@PathVariable String contexto) {
		return casoService.getCasosRelevantes(contexto);
	}
}
