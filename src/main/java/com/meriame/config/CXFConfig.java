package com.meriame.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.meriame.interceptor.AppInboundInterceptor;
import com.meriame.interceptor.AppOutboundInterceptor;
import com.meriame.service.AdminServiceImp;


@Configuration
public class CXFConfig {

	@Autowired
	AdminServiceImp adminServiceImp;
	
	
	
    @Bean(name=Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {    
    	SpringBus springBus = new SpringBus();
       	springBus.getInInterceptors().add(new AppInboundInterceptor());
    	springBus.getOutInterceptors().add(new AppOutboundInterceptor());
    	return springBus;
    }	
    
    @Bean
    public Endpoint endpoint() {
    		
        EndpointImpl endpoint = new EndpointImpl(springBus(), adminServiceImp);
        endpoint.getFeatures().add(new LoggingFeature());
        endpoint.publish("/AdminService");
        return endpoint;
    }
    
    
}
