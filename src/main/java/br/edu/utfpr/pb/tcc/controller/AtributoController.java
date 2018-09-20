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

import br.edu.utfpr.pb.tcc.model.Atributo;
import br.edu.utfpr.pb.tcc.repository.AtributoRepository;

@RestController
@RequestMapping("/atributo")
public class AtributoController {

	@Autowired
	private AtributoRepository atributoRepository;

	@GetMapping(value = { "/", "" })
	public List<Atributo> listar() {
		return atributoRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Atributo buscar(@PathVariable Long id) {
		return atributoRepository.findOne(id);
	}

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody Atributo atributo) {
		atributoRepository.save(atributo);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody Atributo atributo) {
		atributoRepository.save(atributo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable Long id) {
		atributoRepository.delete(id);
	}
}
