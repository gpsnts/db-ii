package com.bd2.grupo05.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Campeonato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_campeonato")
	@SequenceGenerator(name = "seq_campeonato", sequenceName = "seq_campeonato", allocationSize = 1)
	@Column(name = "id_campeonato", length = 50, nullable = false)
	private Long id;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 4, nullable = false)
	private Integer ano;

	@Column(length = 2, nullable = false)
	private Integer nroClubes;
}
