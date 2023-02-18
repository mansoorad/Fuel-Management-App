package com.ty.fuel_boot.fuelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fuel_boot.fuelmanagementsystem.dto.Staff;
import com.ty.fuel_boot.fuelmanagementsystem.service.StaffService;
import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("staff")
public class StaffController {

	@Autowired
	private StaffService staffService;

	@ApiOperation(value = "Save Staff", notes = "It is used to save Staff")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server Error"),
			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 405, message = "Method Not Allowed") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
		return staffService.saveStaff(staff);
	}

	@ApiOperation(value = "Update Staff", notes = "Staff to update Staff")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 405, message = "Method Not Allowed") })
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff, @RequestParam int id) {
		return staffService.updateStaff(staff, id);
	}

	@ApiOperation(value = "Get Staff", notes = "Get Staff by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 405, message = "Method Not Allowed") })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Staff>> getStaffById(@RequestParam int id) {
		return staffService.getStaffById(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<List<Staff>>> getAllStaff() {
		return staffService.getAllStaff();
	}

	@ApiOperation(value = "Delete Staff", notes = "Use to delete Staff By given Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 403, message = "Method Not Allowed") })
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(@RequestParam int id) {
		return staffService.deleteStaff(id);
	}

}
