package br.edu.utfpr.pb.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc.model.Usuario;
import br.edu.utfpr.pb.tcc.service.CrudService;
import br.edu.utfpr.pb.tcc.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends CrudController<Usuario, Long> {

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserir(@RequestBody Usuario usuario) {
		usuario.setPassword(usuario.getEncodedPassword(usuario.getPassword()));
		usuarioService.save(usuario);
	}

	@PutMapping("/")
	@ResponseStatus(value = HttpStatus.OK)
	public void atualizar(@RequestBody Usuario usuario) {
		usuario.setPassword(usuario.getEncodedPassword(usuario.getPassword()));
		usuarioService.save(usuario);
	}

	@Override
	protected CrudService<Usuario, Long> getService() {
		return usuarioService;
	}
}
