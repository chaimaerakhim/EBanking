package com.meriame.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.meriame.dto.AdminDTO;
import com.meriame.model.Admin;

@WebService(name = "Admin", serviceName = "AdminService")
public interface AdminService {
	
	public Admin SaveAdmin(@WebParam(name = "admin")AdminDTO admin);
	public List<Admin> ListAdmin();

}
