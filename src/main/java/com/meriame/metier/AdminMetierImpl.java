package com.meriame.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meriame.dao.AdminRepository;
import com.meriame.model.Admin;


@Service
public class AdminMetierImpl implements AdminMetier{
	@Autowired
	private AdminRepository adminRepository;
	
	
	@Override
	public Admin findAdminByUsername(String username) {
		// TODO Auto-generated method stub
		return adminRepository.findByUsername(username);
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

}
