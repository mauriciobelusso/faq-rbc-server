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

import br.edu.utfpr.pb.tcc.model.Similaridade;
import br.edu.utfpr.pb.tcc.repository.SimilaridadeRepository;

@RestController
@RequestMapping("/similaridade")
public class SimilaridadeController {

	@Autowired
	private SimilaridadeRepository similaridadeRepository;

	@GetMapping(value = { "/", "" })
	public List<Similaridade> listar() {
		return similaridadeRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Similaridade buscar(@PathVariable Long id) {
		return similaridadeRepository.findOne(id);
	}

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody Similaridade similaridade) {
		similaridadeRepository.save(similaridade);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody Similaridade similaridade) {
		similaridadeRepository.save(similaridade);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable Long id) {
		similaridadeRepository.delete(id);
	}
}
