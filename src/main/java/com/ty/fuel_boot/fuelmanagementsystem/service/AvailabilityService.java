package com.ty.fuel_boot.fuelmanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.fuel_boot.fuelmanagementsystem.dao.AvailabilityDao;
import com.ty.fuel_boot.fuelmanagementsystem.dto.Availability;
import com.ty.fuel_boot.fuelmanagementsystem.exception.NoSuchIdFoundException;
import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;

@Service
public class AvailabilityService {
	@Autowired
	private AvailabilityDao availabilityDao;

	public ResponseEntity<ResponseStructure<Availability>> saveAvailability(Availability availability) {
		ResponseStructure<Availability> responseStructure = new ResponseStructure<Availability>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("created");
		responseStructure.setData(availabilityDao.saveAvailability(availability));
		ResponseEntity<ResponseStructure<Availability>> responseEntity = new ResponseEntity<ResponseStructure<Availability>>(
				responseStructure, HttpStatus.CREATED);

		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Availability>> updateAvailability(Availability availability, int id) {
		ResponseStructure<Availability> responseStructure = new ResponseStructure<Availability>();

		Optional<Availability> availability2 = availabilityDao.getAvailabilityById(id);

		if (availability2.isPresent()) {
			availability.setId(id);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Found & Updated");
			responseStructure.setData(availabilityDao.saveAvailability(availability));
		} else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<Availability>> responseEntity = new ResponseEntity<ResponseStructure<Availability>>(
				responseStructure, HttpStatus.CREATED);

		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Availability>> getAvailabilityById(int id) {

		ResponseStructure<Availability> responseStructure = new ResponseStructure<Availability>();

		Optional<Availability> optional = availabilityDao.getAvailabilityById(id);

		if (optional.isPresent()) {
			Availability availability = optional.get();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(availability);

		} else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<Availability>> responseEntity = new ResponseEntity<ResponseStructure<Availability>>(
				responseStructure, HttpStatus.FOUND);

		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Availability>> deleteAvailability(int id) {
		ResponseStructure<Availability> responseStructure = new ResponseStructure<Availability>();
		Optional<Availability> optional = availabilityDao.getAvailabilityById(id);

		if (optional.isPresent()) {
			availabilityDao.deleteAvailability(optional.get());
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found and Deleted");
			responseStructure.setData(optional.get());
		} else {
			throw new NoSuchIdFoundException();
		}
		ResponseEntity<ResponseStructure<Availability>> responseEntity = new ResponseEntity<ResponseStructure<Availability>>(
				responseStructure, HttpStatus.FOUND);

		return responseEntity;

	}
}
