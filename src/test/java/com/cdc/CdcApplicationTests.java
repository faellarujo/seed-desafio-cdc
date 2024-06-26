package com.cdc;

import com.cdc.model.Estado;
import com.cdc.model.Pais;
import com.cdc.service.VerificaPaisService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CdcApplicationTests {

	@Autowired
	private VerificaPaisService verificaPaisService;


	@PersistenceContext
	EntityManager entityManager;


	@Test
	void contextLoads() {

		final VerificaPaisService verificaPaisService = new VerificaPaisService(entityManager);
		final List<Pais> portugal = verificaPaisService.veririfaPais(	"Portugal");
		final List<Estado> braga = verificaPaisService.verificaEstadoExist("Braga");

		System.out.println(portugal);






	}

}
