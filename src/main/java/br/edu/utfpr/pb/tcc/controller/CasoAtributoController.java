package br.edu.utfpr.pb.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc.model.CasoAtributo;
import br.edu.utfpr.pb.tcc.model.compositeKey.CasoAtributoId;
import br.edu.utfpr.pb.tcc.repository.CasoAtributoRepository;

@RestController
@RequestMapping("/casoAtributo")
public class CasoAtributoController {

	@Autowired
	private CasoAtributoRepository casoAtributoRepository;

	@GetMapping(value = { "/", "" })
	public List<CasoAtributo> listar() {
		return casoAtributoRepository.findAll();
	}

	@GetMapping(value ="{caso}/{id}")
	public CasoAtributo buscar(@PathVariable("caso") Long idCaso, @PathVariable("id") Long idAtributo) {
		return casoAtributoRepository.findOne(new CasoAtributoId(idCaso, idAtributo));
	}

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody CasoAtributo casoAtributo) {
		casoAtributoRepository.save(casoAtributo);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody CasoAtributo casoAtributo) {
		casoAtributoRepository.save(casoAtributo);
	}

	@DeleteMapping("{caso}/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable("caso") Long idCaso, @PathVariable("id") Long idAtributo) {
		casoAtributoRepository.delete(new CasoAtributoId(idCaso, idAtributo));
	}
}
