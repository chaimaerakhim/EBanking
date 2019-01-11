package com.meriame.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.meriame.dto.VersementDTO;
import com.meriame.exception.BankTransactionException;
import com.meriame.metier.ClientMetier;
import com.meriame.metier.CompteMetier;
import com.meriame.metier.VersementMetier;
import com.meriame.model.Client;
import com.meriame.model.Compte;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ClientControllerTest {
	
	
	private MockMvc mockMvc;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@MockBean
	private ClientMetier clientMetier;
	@MockBean
	private CompteMetier compteMetier;
	@MockBean
	private VersementMetier versementmetier;
	
	@Autowired
    private WebApplicationContext context;
	
	List<Compte> comptes;
	Client client;
	
	@Before
	public void setUp() {
	    comptes=new Vector<Compte>();
	    comptes.add(new Compte(1, 100, "etat1", null));
	    client=new Client();
	    
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	 
	    Mockito.when(
				compteMetier.getComptesByClientId(Mockito.anyLong()))
	    		.thenReturn(comptes);
	    
	    //clientmetier.getClientbyId(idClient)
	    Mockito.when(
	    		clientMetier.getClientbyId(Mockito.anyLong()))
	    		.thenReturn(client);
	    //versementmetier.verse(virement);
	    
	}
	
	@Test
	public void myComptesTest() throws Exception{
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/clients/1/mycomptes").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		String expected ="[{\"idCompte\":1,\"solde\":100.0,\"etat\":\"etat1\",\"versementsour\":null,\"versementdest\":null,\"versementDest\":null}]";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void profilTest() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/clients/1/profil").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		
		String expected="{\"cin\":null,\"nom\":null,\"prenom\":null,\"adresse\":null,\"telephone\":null,\"email\":null,\"username\":null,\"password\":null,\"datedenaissance\":null,\"adhesionDate\":null,\"comptes\":null}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	
	
	}
	
	@Test
	public void mesVirementsTest() throws Exception{
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/clients/1/mes-virements").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse()
				.getContentAsString());
		
		String expected="[]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}
	
	
	
	@Test
	public void virementTestDone() throws Exception{
		VersementDTO versement=new VersementDTO();
		versement.setId(1);
		versement.setCmptDestination(2);
		versement.setCmptSource(1);
		versement.setDateTransaction(null);
		versement.setMontant(10);
		doNothing().when(versementmetier).verse(versement);
		
		String exampleCourseJson="{\"id\":1,\"cmptSource\":1,\"cmptDestination\":2,\"dateTransaction\":null,\"montant\":10}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/clients/verser")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());

		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
		
	}
	
	@Test
	public void virementTestThrowException() throws Exception{
		
		//BankTransactionException.class
//		thrown.expect(BankTransactionException.class);
		VersementDTO versement=new VersementDTO();
		versement.setId(1);
		versement.setCmptDestination(2);
		versement.setCmptSource(1);
		versement.setDateTransaction(null);
		versement.setMontant(10);
		doThrow(BankTransactionException.class).when(versementmetier).verse(versement);
		
		String exampleCourseJson="{\"id\":1,\"cmptSource\":1,\"cmptDestination\":2,\"dateTransaction\":null,\"montant\":10}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/clients/verser")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("*******************************");
		System.out.println(result.getResponse().getContentAsString());
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
		/*	MockHttpServletResponse response = result.getResponse();
		
		System.out.println(HttpStatus.CREATED.value());
		System.out.println("**********************************");
		System.out.println(response.getStatus());
		*/
	//	assertEquals(HttpStatus.CREATED.value(), response.getStatus(), false);
		//assertEquals(200, response.getStatus());
		
	}
	

}
