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

import br.edu.utfpr.pb.tcc.model.Pessoa;
import br.edu.utfpr.pb.tcc.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping(value = { "/", "" })
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Pessoa buscar(@PathVariable Long id) {
		return pessoaRepository.findOne(id);
	}

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable Long id) {
		pessoaRepository.delete(id);
	}
}
