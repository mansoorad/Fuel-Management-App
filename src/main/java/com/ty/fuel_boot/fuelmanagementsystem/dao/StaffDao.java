package com.ty.fuel_boot.fuelmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fuel_boot.fuelmanagementsystem.dto.Staff;
import com.ty.fuel_boot.fuelmanagementsystem.repo.StaffRepository;

@Repository
public class StaffDao {

	@Autowired
	private StaffRepository staffRepository;

	public Staff saveStaff(Staff staff) {
		return staffRepository.save(staff);
	}

	public Staff updateStaff(Staff staff) {
		return staffRepository.save(staff);
	}

	public Optional<Staff> getStaffById(int id) {
		return staffRepository.findById(id);
	}

	public List<Staff> getAllStaff() {
		return staffRepository.findAll();
	}

	public void deleteStaff(Staff staff) {
		staffRepository.delete(staff);
	}
}
