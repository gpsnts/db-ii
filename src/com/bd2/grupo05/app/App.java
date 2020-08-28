package com.bd2.grupo05.app;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bd2.grupo05.models.Campeonato;
import com.bd2.grupo05.models.ClassificacaoRodada;
import com.bd2.grupo05.models.Clube;
import com.bd2.grupo05.models.ClubeJogador;
import com.bd2.grupo05.models.ClubeTecnico;
import com.bd2.grupo05.models.Jogador;
import com.bd2.grupo05.models.Jogo;
import com.bd2.grupo05.models.Posicao;
import com.bd2.grupo05.models.Rodada;
import com.bd2.grupo05.models.Tecnico;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd2");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		var clube1 = em.merge(Clube.builder()
				.nome("Grêmio")
				.dtFundacao(Date.valueOf(LocalDate.now()))
				.build());
		
		var clube2 = em.merge(Clube.builder()
				.nome("Inter")
				.dtFundacao(Date.valueOf(LocalDate.now()))
				.build());
		
		var posicao = em.merge(Posicao.builder()
				.nome("meio pra frente")
				.build());
		
		em.persist(ClubeTecnico.builder()
				.clube(clube1)
				.tecnico(em.merge(Tecnico.builder()
						.nome("tecnico1")
						.build()))
				.build());
		
		em.persist(ClubeTecnico.builder()
				.clube(clube1)
				.tecnico(em.merge(Tecnico.builder()
						.nome("tecnico2")
						.build()))
				.build());
		
		em.persist(ClubeTecnico.builder()
				.clube(clube2)
				.tecnico(em.merge(Tecnico.builder()
						.nome("tecnico3")
						.build()))
				.build());
		
		em.persist(ClubeJogador.builder()
				.clube(clube1)
				.jogador(em.merge(Jogador.builder()
						.nome("jogador1")
						.posicao(posicao)
						.build()))
				.build());
		
		em.persist(ClubeJogador.builder()
				.clube(clube1)
				.jogador(em.merge(Jogador.builder()
						.nome("jogador2")
						.posicao(posicao)
						.build()))
				.build());
		
		em.persist(ClubeJogador.builder()
				.clube(clube1)
				.jogador(em.merge(Jogador.builder()
						.nome("jogador3")
						.posicao(posicao)
						.build()))
				.build());
		
		em.persist(ClubeJogador.builder()
				.clube(clube2)
				.jogador(em.merge(Jogador.builder()
						.nome("jogador4")
						.posicao(posicao)
						.build()))
				.build());
		
		em.persist(ClubeJogador.builder()
				.clube(clube2)
				.jogador(em.merge(Jogador.builder()
						.nome("jogador5")
						.posicao(posicao)
						.build()))
				.build());
		
		em.persist(ClubeJogador.builder()
				.clube(clube2)
				.jogador(em.merge(Jogador.builder()
						.nome("jogador6")
						.posicao(posicao)
						.build()))
				.build());
		
		var campeonato = em.merge(Campeonato.builder()
			.ano(2020)
			.nome("Gauchão")
			.nroClubes(32)
			.build());
		
		var rodada = em.merge(Rodada.builder()
				.campeonato(campeonato)
				.totalJogos(1)
				.totalAmarelos(1)
				.totalVermelhos(1)
				.totalGols(1)
				.build());
		
		var jogo = em.merge(Jogo.builder()
				.rodada(rodada)
				.clube1(clube1)
				.clube2(clube2)
				.build());
		
		var classificacao1 = em.merge(ClassificacaoRodada.builder()
				.rodada(rodada)
				.clube(clube1)
				.posicao(1)
				.build());
		
		var classificacao2 = em.merge(ClassificacaoRodada.builder()
				.rodada(rodada)
				.clube(clube2)
				.posicao(2)
				.build());
		
		
		em.getTransaction().commit();
		em.clear();
	}

}