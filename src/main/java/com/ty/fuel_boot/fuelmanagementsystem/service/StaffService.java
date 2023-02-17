package com.ty.fuel_boot.fuelmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.fuel_boot.fuelmanagementsystem.dao.StaffDao;
import com.ty.fuel_boot.fuelmanagementsystem.dto.Staff;
import com.ty.fuel_boot.fuelmanagementsystem.exception.NoSuchIdFoundException;
import com.ty.fuel_boot.fuelmanagementsystem.exception.UnableToUpdateException;
import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;

@Service
public class StaffService {

	@Autowired
	private StaffDao staffDao;

	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff) {
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Staff details saved successfully");
		responseStructure.setData(staffDao.saveStaff(staff));
		ResponseEntity<ResponseStructure<Staff>> responseEntity = new ResponseEntity<ResponseStructure<Staff>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(Staff staff, int id) {
		Optional<Staff> staff2 = staffDao.getStaffById(id);
		ResponseStructure<Staff> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Staff>> responseEntity = new ResponseEntity<ResponseStructure<Staff>>(
				responseStructure, HttpStatus.OK);
		if (staff2.isPresent()) {
			staff.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Staff details updated successfully");
			responseStructure.setData(staffDao.updateStaff(staff));
			return responseEntity;
		} else {
			throw new UnableToUpdateException("Unable to update staff as no staff found");
		}
	}

	public ResponseEntity<ResponseStructure<Staff>> getStaffById(int id) {
		Optional<Staff> optional = staffDao.getStaffById(id);
		ResponseStructure<Staff> responseStructure = new ResponseStructure<Staff>();
		ResponseEntity<ResponseStructure<Staff>> responseEntity = new ResponseEntity<ResponseStructure<Staff>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Staff Found");
			responseStructure.setData(staffDao.getStaffById(id).get());
			return responseEntity;

		} else {
			throw new NoSuchIdFoundException("Unable to find staff for given id");

		}
	}

	public ResponseEntity<ResponseStructure<List<Staff>>> getAllStaff() {
		ResponseStructure<List<Staff>> responseStructure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<List<Staff>>> responseEntity = new ResponseEntity<ResponseStructure<List<Staff>>>(
				responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("All staff details found successfully");
		responseStructure.setData(staffDao.getAllStaff());
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(int id) {
		Optional<Staff> optional = staffDao.getStaffById(id);
		ResponseStructure<Staff> responseStructure = new ResponseStructure<Staff>();
		ResponseEntity<ResponseStructure<Staff>> responseEntity = new ResponseEntity<ResponseStructure<Staff>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			staffDao.deleteStaff(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Staff Deleted as per Given Id");
			responseStructure.setData(optional.get());
			return responseEntity;
		} else {
			throw new NoSuchIdFoundException("No Staff found to delete for given id");
		}
	}
}