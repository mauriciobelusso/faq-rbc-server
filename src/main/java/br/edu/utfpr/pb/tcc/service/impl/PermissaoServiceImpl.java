package br.edu.utfpr.pb.tcc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.tcc.model.Permissao;
import br.edu.utfpr.pb.tcc.repository.PermissaoRepository;
import br.edu.utfpr.pb.tcc.service.PermissaoService;

public class PermissaoServiceImpl extends CrudServiceImpl<Permissao, Long> implements PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Override
	protected JpaRepository<Permissao, Long> getRepository() {
		return permissaoRepository;
	}

}
