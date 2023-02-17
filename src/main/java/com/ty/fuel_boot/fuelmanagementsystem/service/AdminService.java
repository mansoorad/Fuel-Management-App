package com.ty.fuel_boot.fuelmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.fuel_boot.fuelmanagementsystem.dao.AdminDao;
import com.ty.fuel_boot.fuelmanagementsystem.dto.Admin;
import com.ty.fuel_boot.fuelmanagementsystem.exception.NoSuchIdFoundException;
import com.ty.fuel_boot.fuelmanagementsystem.exception.WrongEmailIDPasswordException;
import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;


@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin){
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Admin created");
		responseStructure.setData(adminDao.saveAdmin(admin));
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.CREATED);

		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		Optional<Admin> admin2 = adminDao.getAdminById(id);

		if (admin2.isPresent()) {
			admin.setId(id);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Admin Found & Updated");
			responseStructure.setData(adminDao.updateAdmin(admin));
		} else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.CREATED);

		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {

		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		Optional<Admin> optional = adminDao.getAdminById(id);

		if (optional.isPresent()) {
			Admin admin = optional.get();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Admin Found");
			responseStructure.setData(admin);

		} else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.FOUND);

		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int id) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Optional<Admin> optional = adminDao.getAdminById(id);

		if (optional.isPresent()) {
			adminDao.deleteAdmin(optional.get());
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Admin Found and Deleted");
			responseStructure.setData(optional.get());
		} else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.FOUND);

		return responseEntity;

	}
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();

		String password = admin.getPassword();
		List<Admin> alladmin = adminDao.getAllAdmin();

		for (Admin admin2 : alladmin) {
			if (admin2.getPassword().equals(password)) {
				responseStructure.setStatus(HttpStatus.FOUND.value());
				responseStructure.setMessage("Admin Found & Granted Access");
				responseStructure.setData(admin);
				break;
			} else {
				throw new WrongEmailIDPasswordException();
			}
		}

		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.FOUND);
	}

}


