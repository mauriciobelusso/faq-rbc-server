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

import br.edu.utfpr.pb.tcc.model.Permissao;
import br.edu.utfpr.pb.tcc.repository.PermissaoRepository;

@RestController
@RequestMapping("/permissao")
public class PermissaoController {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@GetMapping(value = { "/", "" })
	public List<Permissao> listar() {
		return permissaoRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Permissao buscar(@PathVariable Long id) {
		return permissaoRepository.findOne(id);
	}

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody Permissao permissao) {
		permissaoRepository.save(permissao);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody Permissao permissao) {
		permissaoRepository.save(permissao);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable Long id) {
		permissaoRepository.delete(id);
	}
}
