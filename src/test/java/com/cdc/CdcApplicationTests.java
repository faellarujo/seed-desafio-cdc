package com.cdc;

import com.cdc.service.PaisService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CdcApplicationTests {

	@Autowired
	private PaisService paisService;


	@PersistenceContext
	EntityManager entityManager;




}
