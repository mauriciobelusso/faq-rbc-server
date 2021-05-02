package br.edu.utfpr.pb.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.tcc.model.Permissao;
import br.edu.utfpr.pb.tcc.service.CrudService;
import br.edu.utfpr.pb.tcc.service.PermissaoService;

@RestController
@RequestMapping("permissao")
public class PermissaoController extends CrudController<Permissao, Long> {

	@Autowired
	private PermissaoService permissaoService; 
	
	@Override
	protected CrudService<Permissao, Long> getService() {
		return permissaoService;
	}
}
