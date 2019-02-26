package br.edu.utfpr.pb.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.tcc.model.Palavra;

public interface PalavraRepository extends JpaRepository<Palavra, Long> {

}
