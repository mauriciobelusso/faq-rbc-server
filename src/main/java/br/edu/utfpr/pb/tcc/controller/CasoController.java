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

import br.edu.utfpr.pb.tcc.model.Caso;
import br.edu.utfpr.pb.tcc.repository.CasoRepository;

@RestController
@RequestMapping("/caso")
public class CasoController {

	@Autowired
	private CasoRepository casoRepository;

	@GetMapping(value = { "/", "" })
	public List<Caso> listar() {
		return casoRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Caso buscar(@PathVariable Long id) {
		return casoRepository.findOne(id);
	}

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody Caso caso) {
		casoRepository.save(caso);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody Caso caso) {
		casoRepository.save(caso);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable Long id) {
		casoRepository.delete(id);
	}
}
