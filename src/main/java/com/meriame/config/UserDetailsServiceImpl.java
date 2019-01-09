package com.meriame.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.meriame.dao.AdminRepository;
import com.meriame.dao.AgentRepository;
import com.meriame.dao.ClientRepository;
import com.meriame.model.Admin;
import com.meriame.model.Agent;
import com.meriame.model.Client;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	Collection<GrantedAuthority> authorities = new ArrayList<>();
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AgentRepository agentRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		Client client = clientRepository.findByUsername(username);
		Admin admin = adminRepository.findByUsername(username);
		Agent agent = agentRepository.findByUsername(username);
		
		if(client == null && admin == null && agent==null)
			throw new UsernameNotFoundException("Bad Credentials " + username);
		
		if(admin != null) {
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			System.out.println("------>Admin Username: " + admin.getUsername() + ", pass: " + admin.getPassword() + ", Auth: " + authorities);
			return new User(admin.getUsername(), admin.getPassword(), authorities);
		}
		else if(agent!= null) {
			authorities.add(new SimpleGrantedAuthority("AGENT"));
			System.out.println("------>Admin Username: " + admin.getUsername() + ", pass: " + admin.getPassword() + ", Auth: " + authorities);
			return new User(admin.getUsername(), admin.getPassword(), authorities);
		}
		else {
			authorities.add(new SimpleGrantedAuthority("CLIENT"));
			System.out.println("------> Client Username: " + client.getUsername() + ", pass: " + client.getPassword() + ", Auth: " + authorities);
			return new User(client.getUsername(), client.getPassword(), authorities);
		}
	}

}
