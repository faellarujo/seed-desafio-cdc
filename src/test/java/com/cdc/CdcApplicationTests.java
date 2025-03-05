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




}
