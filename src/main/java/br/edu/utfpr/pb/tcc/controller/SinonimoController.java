package br.edu.utfpr.pb.tcc.controller;

import java.util.List;

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

import br.edu.utfpr.pb.tcc.model.Sinonimo;
import br.edu.utfpr.pb.tcc.repository.SinonimoRepository;

@RestController
@RequestMapping("/sinonimo")
public class SinonimoController {

	private SinonimoRepository sinonimoRepository;

	@GetMapping(value = { "/", "" })
	public List<Sinonimo> listar() {
		return sinonimoRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Sinonimo buscar(@PathVariable Long id) {
		return sinonimoRepository.findOne(id);
	}

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody Sinonimo sinonimo) {
		sinonimoRepository.save(sinonimo);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody Sinonimo sinonimo) {
		sinonimoRepository.save(sinonimo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable Long id) {
		sinonimoRepository.delete(id);
	}
}
