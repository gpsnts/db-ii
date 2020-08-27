package com.bd2.grupo05.app;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bd2.grupo05.models.Clube;
import com.bd2.grupo05.models.ClubeJogador;
import com.bd2.grupo05.models.ClubeTecnico;
import com.bd2.grupo05.models.Jogador;
import com.bd2.grupo05.models.Tecnico;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd2");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		var clube = em.merge(Clube.builder()
				.nome("gr�nio")
				.dtFundacao(Date.valueOf(LocalDate.now()))
				.build());
		
		em.persist(ClubeTecnico.builder()
				.clube(clube)
				.tecnico(em.merge(Tecnico.builder()
						.nome("tecnico1")
						.build()))
				.build());
		
		em.persist(ClubeTecnico.builder()
				.clube(clube)
				.tecnico(em.merge(Tecnico.builder()
						.nome("tecnico2")
						.build()))
				.build());
		
		em.persist(ClubeJogador.builder()
				.clube(clube)
				.jogador(em.merge(Jogador.builder()
						.nome("jogador1")
						.build()))
				.build());
		
		em.persist(ClubeJogador.builder()
				.clube(clube)
				.jogador(em.merge(Jogador.builder()
						.nome("jogador2")
						.build()))
				.build());
		
		em.persist(ClubeJogador.builder()
				.clube(clube)
				.jogador(em.merge(Jogador.builder()
						.nome("jogador3")
						.build()))
				.build());
		
		
		em.getTransaction().commit();
		em.clear();
	}

}