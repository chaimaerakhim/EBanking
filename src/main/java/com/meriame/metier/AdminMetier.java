package com.meriame.metier;

import com.meriame.model.Admin;


public interface AdminMetier {
	public Admin findAdminByUsername(String username);
	public Admin saveAdmin(Admin admin);
}
