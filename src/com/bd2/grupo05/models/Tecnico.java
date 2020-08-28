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
public class Tecnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_tecnico")
	@SequenceGenerator(name = "seq_tecnico", sequenceName = "seq_tecnico", allocationSize = 1)
	@Column(name = "id_tecnico", length = 50, nullable = false)
	private Long id;

	@Column(length = 50, nullable = false)
	private String nome;
}
