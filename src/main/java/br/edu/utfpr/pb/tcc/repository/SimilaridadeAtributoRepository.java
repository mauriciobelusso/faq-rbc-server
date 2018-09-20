package br.edu.utfpr.pb.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.tcc.model.SimilaridadeAtributo;
import br.edu.utfpr.pb.tcc.model.compositeKey.SimilaridadeAtributoId;

public interface SimilaridadeAtributoRepository extends JpaRepository<SimilaridadeAtributo, SimilaridadeAtributoId> {

}
