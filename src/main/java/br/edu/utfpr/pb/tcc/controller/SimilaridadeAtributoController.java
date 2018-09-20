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

import br.edu.utfpr.pb.tcc.model.SimilaridadeAtributo;
import br.edu.utfpr.pb.tcc.model.compositeKey.SimilaridadeAtributoId;
import br.edu.utfpr.pb.tcc.repository.SimilaridadeAtributoRepository;

@RestController
@RequestMapping("/similaridadeAtributo")
public class SimilaridadeAtributoController {

	@Autowired
	private SimilaridadeAtributoRepository similaridadeAtributoRepository;

	@GetMapping(value = { "/", "" })
	public List<SimilaridadeAtributo> listar() {
		return similaridadeAtributoRepository.findAll();
	}

	@GetMapping(value = "{similaridade}/{id}")
	public SimilaridadeAtributo buscar(@PathVariable("similaridade") Long idSimilaridade, @PathVariable("id") Long idAtributo) {
		return similaridadeAtributoRepository.findOne(new SimilaridadeAtributoId(idSimilaridade, idAtributo));
	}

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody SimilaridadeAtributo similaridadeAtributo) {
		similaridadeAtributoRepository.save(similaridadeAtributo);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody SimilaridadeAtributo similaridadeAtributo) {
		similaridadeAtributoRepository.save(similaridadeAtributo);
	}

	@DeleteMapping("{similaridade}/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable("similaridade") Long idSimilaridade, @PathVariable("id") Long idAtributo) {
		similaridadeAtributoRepository.delete(new SimilaridadeAtributoId(idSimilaridade, idAtributo));
	}
}
