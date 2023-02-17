package com.ty.fuel_boot.fuelmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fuel_boot.fuelmanagementsystem.dto.Admin;
import com.ty.fuel_boot.fuelmanagementsystem.repo.AdminReposiratory;

@Repository
public class AdminDao {
	@Autowired
	AdminReposiratory adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	public Optional<Admin> getAdminById(int id) {
		return adminRepository.findById(id);
	}

	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public void deleteAdmin(Admin admin) {
		adminRepository.delete(admin);

	}
}
