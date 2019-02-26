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

import br.edu.utfpr.pb.tcc.model.Palavra;
import br.edu.utfpr.pb.tcc.repository.PalavraRepository;

@RestController
@RequestMapping("/palavra")
public class PalavraController {
	
	@Autowired
	private PalavraRepository palavraRepository;

	@GetMapping(value = { "/", "" })
	public List<Palavra> listar() {
		return palavraRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Palavra buscar(@PathVariable Long id) {
		return palavraRepository.findOne(id);
	}

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody Palavra palavra) {
		palavraRepository.save(palavra);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody Palavra palavra) {
		palavraRepository.save(palavra);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable Long id) {
		palavraRepository.delete(id);
	}
}
