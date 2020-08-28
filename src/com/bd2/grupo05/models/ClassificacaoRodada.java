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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "uk_classificacaoRodadaTecnico_rodada_posicao", columnNames = { "id_rodada", "posicao" }),
		@UniqueConstraint(name = "uk_classificacaoRodadaTecnico_rodada_clube", columnNames = { "id_rodada", "id_clube" }) })
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassificacaoRodada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_classificacaoRodada")
	@SequenceGenerator(name = "seq_classificacaoRodada", sequenceName = "seq_classificacaoRodada", allocationSize = 1)
	@Column(name = "id_classificacaoRodada", length = 50, nullable = false)
	private Long id;

	@Column(length = 2, nullable = false)
	private Integer posicao;

	@Builder.Default
	@Column(length = 3)
	private Integer totalPontos = 0;

	@Builder.Default
	@Column(length = 2)
	private Integer totalVitorias = 0;

	@Builder.Default
	@Column(length = 2)
	private Integer totalEmpates = 0;

	@Builder.Default
	@Column(length = 2)
	private Integer totalDerrotas = 0;

	@Builder.Default
	@Column(length = 3)
	private Integer totalGolsPro = 0;

	@Builder.Default
	@Column(length = 3)
	private Integer totalGolsContra = 0;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_clube", foreignKey = @ForeignKey(name = "fk_classificacaoRodada_clube"))
	private Clube clube;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_rodada", foreignKey = @ForeignKey(name = "fk_classificacaoRodada_rodada"))
	private Rodada rodada;
}
