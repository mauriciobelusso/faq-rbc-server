package br.edu.utfpr.pb.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.tcc.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
