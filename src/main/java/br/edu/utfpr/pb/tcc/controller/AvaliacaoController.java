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

import br.edu.utfpr.pb.tcc.model.Avaliacao;
import br.edu.utfpr.pb.tcc.repository.AvaliacaoRepository;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	@GetMapping(value = { "/", "" })
	public List<Avaliacao> listar() {
		return avaliacaoRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Avaliacao buscar(@PathVariable Long id) {
		return avaliacaoRepository.findOne(id);
	}

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody Avaliacao avaliacao) {
		avaliacaoRepository.save(avaliacao);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody Avaliacao avaliacao) {
		avaliacaoRepository.save(avaliacao);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable Long id) {
		avaliacaoRepository.delete(id);
	}
}
