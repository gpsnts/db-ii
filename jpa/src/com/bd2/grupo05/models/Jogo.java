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
public class Jogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_jogo")
	@SequenceGenerator(name = "seq_jogo", sequenceName = "seq_jogo", allocationSize = 1)
	@Column(name = "id_jogo", length = 50, nullable = false)
	private Long id;

	@Builder.Default
	@Column(length = 2)
	private Integer clube1Gol = 0;

	@Builder.Default
	@Column(length = 2)
	private Integer clube2Gol = 0;

	@Builder.Default
	@Column(length = 2)
	private Integer clube1Amarelo = 0;

	@Builder.Default
	@Column(length = 2)
	private Integer clube2Amarelo = 0;

	@Builder.Default
	@Column(length = 2)
	private Integer clube1Vermelho = 0;

	@Builder.Default
	@Column(length = 2)
	private Integer clube2Vermelho = 0;

	@Builder.Default
	@Column(length = 1)
	private Integer clube1Ponto = 0;

	@Builder.Default
	@Column(length = 1)
	private Integer clube2ponto = 0;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_rodada", foreignKey = @ForeignKey(name = "fk_jogo_rodada"))
	private Rodada rodada;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_clube1", foreignKey = @ForeignKey(name = "fk_jogo_clube1"))
	private Clube clube1;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_clube2", foreignKey = @ForeignKey(name = "fk_jogo_clube2"))
	private Clube clube2;
}
