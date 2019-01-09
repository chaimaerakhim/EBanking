package com.meriame;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.meriame.dao.ClientRepository;
import com.meriame.metier.ClientMetier;
import com.meriame.model.Client;

@SpringBootApplication
@EnableWebMvc
@ImportResource({ "classpath:webservice-definition-beans.xml" })
@EnableJpaRepositories("com.meriame.dao")
@ComponentScan({"com.meriame","com.meriame.controller"})
public class SoapServerEBankingProjectApplication implements ApplicationRunner {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ClientMetier clientMetier;
	public static void main(String[] args) {
		SpringApplication.run(SoapServerEBankingProjectApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean cxfDispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }
	
	@Bean
	BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}
	
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		clientMetier.SaveClient(new Client("client","1234"));
		
	}
	
	

}

