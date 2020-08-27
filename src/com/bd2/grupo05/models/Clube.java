package com.bd2.grupo05.models;

import java.io.Serializable;
import java.sql.Date;

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
public class Clube implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_clube")
	@SequenceGenerator(name = "seq_clube", sequenceName = "seq_clube", allocationSize = 1)
	private Long id;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(nullable = false)
	private Date dtFundacao;
}
