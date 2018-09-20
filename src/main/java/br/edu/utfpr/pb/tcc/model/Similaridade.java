package br.edu.utfpr.pb.tcc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "similaridade")
@Data
@EqualsAndHashCode(of = "id")
public class Similaridade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	private String medida;

	private Integer tipo;
 
    @OneToMany
    @JoinColumn(name = "similaridade_id")
    private List<SimilaridadeAtributo> similaridadeAtributos;
}
