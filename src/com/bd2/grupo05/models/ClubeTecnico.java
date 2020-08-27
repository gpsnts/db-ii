package com.bd2.grupo05.models;

import java.io.Serializable;

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
@Table(uniqueConstraints = @UniqueConstraint(name = "uk_clubeTecnico", columnNames = { "id_clube", "id_tecnico" }))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubeTecnico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_clubeTecnico")
	@SequenceGenerator(name = "seq_clubeTecnico", sequenceName = "seq_clubeTecnico", allocationSize = 1)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_clube", foreignKey = @ForeignKey(name = "fk_clubeTecnico_clube"))
	private Clube clube;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tecnico", foreignKey = @ForeignKey(name = "fk_clubeTecnico_tecnico"))
	private Tecnico tecnico;
}
