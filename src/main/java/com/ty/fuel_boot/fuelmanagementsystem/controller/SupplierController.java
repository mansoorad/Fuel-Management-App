package com.ty.fuel_boot.fuelmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fuel_boot.fuelmanagementsystem.dto.Supplier;
import com.ty.fuel_boot.fuelmanagementsystem.service.SupplierService;
import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;

@RestController
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping
	ResponseEntity<ResponseStructure<Supplier>> saveSupplier(@Valid @RequestBody Supplier supplier) {
		return supplierService.saveSupplier(supplier);
	}

	@PutMapping
	ResponseEntity<ResponseStructure<Supplier>> updateSupplier(@Valid @RequestBody Supplier supplier,
			@RequestParam int id) {
		return supplierService.updateSupplier(supplier, id);
	}

	@GetMapping
	ResponseEntity<ResponseStructure<Supplier>> getSupplierById(@Valid @RequestParam int id) {
		return supplierService.getSupplierById(id);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<ResponseStructure<Supplier>> deleteSupplierById(@Valid @PathVariable int id) {
		return supplierService.deleteSupplierById(id);
	}
}
