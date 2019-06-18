package com.spring.step;

import java.util.Random;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.spring.model.Utilisateur;


public class Processor implements ItemProcessor<Utilisateur, Utilisateur> {

	private static final Logger log = LoggerFactory.getLogger(Processor.class);

	@Override
	public Utilisateur process(Utilisateur customer) throws Exception {
		Random r = new Random();
		
		final String name = customer.getName().toUpperCase();

		final Utilisateur fixedCustomer = new Utilisateur(r.nextInt(),name);

		log.info("Converting (" + customer + ") into (" + fixedCustomer + ")");

		return fixedCustomer;
	}
}
