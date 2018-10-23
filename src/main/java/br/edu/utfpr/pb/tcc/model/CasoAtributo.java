package br.edu.utfpr.pb.tcc.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.utfpr.pb.tcc.model.compositeKey.CasoAtributoId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "caso_atributo")
@Data
@EqualsAndHashCode(of = "id")
public class CasoAtributo implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private CasoAtributoId id;

	@ManyToOne
	private Caso caso;
	@ManyToOne
	private Atributo atributo;
}
