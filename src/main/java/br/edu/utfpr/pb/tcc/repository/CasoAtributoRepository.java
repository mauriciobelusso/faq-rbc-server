package br.edu.utfpr.pb.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.tcc.model.CasoAtributo;
import br.edu.utfpr.pb.tcc.model.compositeKey.CasoAtributoId;

public interface CasoAtributoRepository extends JpaRepository<CasoAtributo, CasoAtributoId> {
}
