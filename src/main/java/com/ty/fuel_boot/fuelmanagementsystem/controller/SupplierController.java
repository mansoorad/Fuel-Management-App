package com.ty.fuel_boot.fuelmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fuel_boot.fuelmanagementsystem.dto.Supplier;
import com.ty.fuel_boot.fuelmanagementsystem.service.SupplierService;
import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@ApiOperation(value = "Save Supplier", notes = "It is used to save Supplier")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server Error"),
			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 405, message = "Method Not Allowed") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ResponseStructure<Supplier>> saveSupplier(@Valid @RequestBody Supplier supplier) {
		return supplierService.saveSupplier(supplier);
	}

	@ApiOperation(value = "Update Supplier", notes = "Staff to update Supplier")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 405, message = "Method Not Allowed") })
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	ResponseEntity<ResponseStructure<Supplier>> updateSupplier(@Valid @RequestBody Supplier supplier,
			@RequestParam int id) {
		return supplierService.updateSupplier(supplier, id);
	}

	@ApiOperation(value = "Get Supplier", notes = "Get Supplier by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 405, message = "Method Not Allowed") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ResponseStructure<Supplier>> getSupplierById(@Valid @RequestParam int id) {
		return supplierService.getSupplierById(id);
	}

	@ApiOperation(value = "Delete Supplier", notes = "Use to delete Supplier By given Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 403, message = "Method Not Allowed") })
	@DeleteMapping(value={"/id"},produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ResponseStructure<Supplier>> deleteSupplierById(@Valid @PathVariable int id) {
		return supplierService.deleteSupplierById(id);
	}
}
