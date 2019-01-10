package com.meriame.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.meriame.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	public Admin findByUsername(String username);
	public Admin findAdminById(long id);
	
}
