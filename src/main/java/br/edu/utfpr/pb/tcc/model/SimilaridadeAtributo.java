package br.edu.utfpr.pb.tcc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.utfpr.pb.tcc.model.compositeKey.SimilaridadeAtributoId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "similaridade_atributo")
@Data
@EqualsAndHashCode(of = "id")
public class SimilaridadeAtributo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SimilaridadeAtributoId id;

	@ManyToOne
	@JoinColumn(name = "idSimilaridade", referencedColumnName = "id", insertable = false, updatable = false)
	private Similaridade similaridade;

	@ManyToOne
	@JoinColumn(name = "idAtributo", referencedColumnName = "id", insertable = false, updatable = false)
	private Atributo atributo;

	@Column(precision = 2, scale = 1)
	private Double peso;
}
