package com.meriame.service;

import java.util.List;

import javax.jws.WebService;

import com.meriame.dao.AdminRepository;
import com.meriame.dto.AdminDTO;
import com.meriame.model.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp  implements AdminService{

	@Autowired
	private AdminRepository adminRepository;

	
	@Override
	public List<Admin> ListAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}



	@Override
	public Admin SaveAdmin(AdminDTO admin) {
		Admin a=new Admin(admin);
		try {
			return adminRepository.save(a);
		}
		catch(Exception e) {
			System.out.println("*******************************************************************");
			System.out.println(e.toString());
			System.out.println("*******************************************************************");
			return null;
		}
	}
	
	

}
