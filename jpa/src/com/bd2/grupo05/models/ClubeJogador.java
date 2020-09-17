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
@Table(uniqueConstraints = @UniqueConstraint(name = "uk_clubeJogador", columnNames = { "id_clube", "id_jogador" }))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubeJogador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_clubeJogador")
	@SequenceGenerator(name = "seq_clubeJogador", sequenceName = "seq_clubeJogador", allocationSize = 1)
	@Column(name = "id_clubeJogador", length = 50, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_clube", foreignKey = @ForeignKey(name = "fk_clubeJogador_clube"))
	private Clube clube;

	@ManyToOne
	@JoinColumn(name = "id_jogador", foreignKey = @ForeignKey(name = "fk_clubeJogador_jogador"))
	private Jogador jogador;
}
