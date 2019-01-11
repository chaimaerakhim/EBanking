package com.meriame.metier;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;

import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.meriame.dao.ClientRepository;
import com.meriame.model.Client;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ClientMetierImlTest {

	@MockBean
	ClientRepository clientRepository;
	
	@MockBean
	private BCryptPasswordEncoder bcp;
	
	@Autowired
	ClientMetier clientMetier;
	
	Client client;
	List<Client> clients;
	
	@Before
	public void setUp() {
	  client = new Client();
	  client.setPassword("password");
	  clients=new Vector <Client>();
	  
	  Mockito.when(clientRepository.save(client)).thenReturn(client);
	  Mockito.when(clientRepository.findAll()).thenReturn(clients);
	  Mockito.when(clientRepository.findById(anyLong())).thenReturn(client);
	  
	  Mockito.when(bcp.encode(anyString())).thenReturn("password");
	  
	  doNothing().when(clientRepository).delete(client);
	  
	}
	
	@Test
	public void SaveClientTest() throws Exception{
		
		Client c=clientMetier.SaveClient(client);
		assertEquals(c.getPassword(), "password");
		
	}
	
	@Test 
	public void editClientTest() throws Exception{
		Client c=clientMetier.editClient(client);
		assertEquals(c.getPassword(), "password");
		
	}
	
	@Test
	public void getAllClientsTest() throws Exception{
		List<Client> listClient=clientMetier.getAllClients();
		assertEquals(clients.size(), listClient.size());
	}
	
	@Test
	public void getClientbyIdTest() throws Exception{
		
		Client c=clientMetier.getClientbyId(1);
		assertEquals(c, client);
		
	}
	
	@Test
	public void deleteClientbyIdTest() throws Exception{
//		clientMetier.deleteClientbyId(1);
	}
	
}
