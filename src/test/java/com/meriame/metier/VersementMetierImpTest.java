package com.meriame.metier;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.meriame.dao.CompteRepository;
import com.meriame.dao.VersementRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class VersementMetierImpTest {
	
	@MockBean
	private CompteRepository compteRepository;
	
	@MockBean
	private VersementRepository versementRepository;
}
