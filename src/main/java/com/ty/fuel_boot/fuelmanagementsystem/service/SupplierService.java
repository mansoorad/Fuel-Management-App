package com.ty.fuel_boot.fuelmanagementsystem.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.fuel_boot.fuelmanagementsystem.dao.SupplierDao;
import com.ty.fuel_boot.fuelmanagementsystem.dto.Supplier;
import com.ty.fuel_boot.fuelmanagementsystem.exception.NoSuchIdFoundException;
import com.ty.fuel_boot.fuelmanagementsystem.exception.NoSuchIdFoundToUpdate;
import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;
 
@Service
public class SupplierService {
	
	private SupplierDao supplierDao;
	
	public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(Supplier supplier){
		ResponseEntity<ResponseStructure<Supplier>>  responseEntity;
		ResponseStructure<Supplier> responseStructure = new ResponseStructure<Supplier>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data saved");
		responseStructure.setData(supplierDao.saveSupplier(supplier));
		return new ResponseEntity<ResponseStructure<Supplier>>(responseStructure, HttpStatus.CREATED);

	}
	
	public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(Supplier supplier, int id) {
		ResponseEntity<ResponseStructure<Supplier>> responseEntity;
		ResponseStructure<Supplier> responseStructure = new ResponseStructure<Supplier>();
		Optional<Supplier> optional = supplierDao.getSupplierById(id);
		if (optional.isPresent()) {
			supplier.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data updated");
			responseStructure.setData(supplierDao.saveSupplier(supplier));
			return new ResponseEntity<ResponseStructure<Supplier>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoSuchIdFoundToUpdate("No Such Id Found To Update");
		}
	}
	
	public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(int id) {
		ResponseEntity<ResponseStructure<Supplier>> responseEntity;
		ResponseStructure<Supplier> responseStructure = new ResponseStructure<Supplier>();
		Optional<Supplier> optional = supplierDao.getSupplierById(id);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data found");
			responseStructure.setData(optional.get());
		} else {
			throw new NoSuchIdFoundException();
		}
		return new ResponseEntity<ResponseStructure<Supplier>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Supplier>> deleteSupplierById(int id) {
		ResponseEntity<ResponseStructure<Supplier>> responseEntity;
		ResponseStructure<Supplier> responseStructure = new ResponseStructure<Supplier>();
		Optional<Supplier> optional = supplierDao.getSupplierById(id);
		if (optional.isPresent()) {
			supplierDao.deleteSupplier(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			return new ResponseEntity<ResponseStructure<Supplier>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoSuchIdFoundException("No Such Id Found To Delete");
		}
	}
}
