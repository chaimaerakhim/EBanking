package com.meriame.metier;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.meriame.dao.CompteRepository;
import com.meriame.model.Compte;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CompteMetierImplTest {
	
	@MockBean
	CompteRepository compteRepository;
	
	@Autowired
	CompteMetier comptetMetier;
	
	List<Compte> comptes;
	@Before
	public void setUp() {
		comptes=new Vector<>();
		
		//findByClientId
		Mockito.when(compteRepository.findByClientId(anyLong())).thenReturn(comptes);
	}
	
	@Test
	public void getComptesByClientIdTest() throws Exception{
		List<Compte> cmtps=comptetMetier.getComptesByClientId(1L);
		assertEquals(cmtps, comptes);
		
	}

}
