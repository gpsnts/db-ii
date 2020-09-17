package com.bd2.grupo05.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rodada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_rodada")
	@SequenceGenerator(name = "seq_rodada", sequenceName = "seq_rodada", allocationSize = 1)
	@Column(name = "id_rodada", length = 50, nullable = false)
	private Long id;

	@Builder.Default
	@Column(length = 2)
	private Integer totalJogos = 0;

	@Builder.Default
	@Column(length = 3)
	private Integer totalAmarelos = 0;

	@Builder.Default
	@Column(length = 3)
	private Integer totalVermelhos = 0;

	@Column(length = 3)
	private Integer totalGols;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_campeonato", foreignKey = @ForeignKey(name = "fk_rodada_campeonato"))
	private Campeonato campeonato;
}
