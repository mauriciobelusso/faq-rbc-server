package br.edu.utfpr.pb.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.tcc.model.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{

}
