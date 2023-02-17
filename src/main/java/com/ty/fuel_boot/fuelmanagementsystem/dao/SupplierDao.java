package com.ty.fuel_boot.fuelmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fuel_boot.fuelmanagementsystem.dto.Supplier;
import com.ty.fuel_boot.fuelmanagementsystem.repo.SupplierRepository;

@Repository
public class SupplierDao {

	@Autowired
	private SupplierRepository supplierRepository;

	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	public Supplier updateSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	public Optional<Supplier> getSupplierById(int id) {
		return supplierRepository.findById(id);

	}

	public void deleteSupplier(Supplier supplier) {
		supplierRepository.delete(supplier);
	}

}
