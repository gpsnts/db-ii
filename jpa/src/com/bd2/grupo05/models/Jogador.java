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
public class Jogador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_jogador")
	@SequenceGenerator(name = "seq_jogador", sequenceName = "seq_jogador", allocationSize = 1)
	@Column(name = "id_jogador", length = 50)
	private Long id;

	@Column(length = 50, nullable = false)
	private String nome;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_posicao", foreignKey = @ForeignKey(name = "fk_jogador_posicao"))
	private Posicao posicao;
}
