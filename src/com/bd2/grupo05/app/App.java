package com.bd2.grupo05.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bd2.grupo05.models.Fruteira;


public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(Fruteira.builder()
				.nome("Bruh")
				.build());
		em.getTransaction().commit();
	}

}