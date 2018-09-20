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

import br.edu.utfpr.pb.tcc.model.Setor;
import br.edu.utfpr.pb.tcc.repository.SetorRepository;

@RestController
@RequestMapping("/setor")
public class SetorController {

	@Autowired
	private SetorRepository setorRepository;

	@GetMapping(value = { "/", "" })
	public List<Setor> listar() {
		return setorRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Setor buscar(@PathVariable Long id) {
		return setorRepository.findOne(id);
	}

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody Setor setor) {
		setorRepository.save(setor);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody Setor setor) {
		setorRepository.save(setor);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable Long id) {
		setorRepository.delete(id);
	}
}
