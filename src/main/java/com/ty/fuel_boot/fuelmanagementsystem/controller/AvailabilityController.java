package com.ty.fuel_boot.fuelmanagementsystem.controller;

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

import com.ty.fuel_boot.fuelmanagementsystem.dto.Admin;
import com.ty.fuel_boot.fuelmanagementsystem.dto.Availability;
import com.ty.fuel_boot.fuelmanagementsystem.service.AdminService;
import com.ty.fuel_boot.fuelmanagementsystem.service.AvailabilityService;
import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("availability")
public class AvailabilityController {

	@Autowired
	AvailabilityService availabilityService;

	@ApiOperation(value = "Save availability", notes = "Used to save the availability")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Internal Server Error")

	})
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Availability>> saveAvailability(@RequestBody Availability availability) {
		return availabilityService.saveAvailability(availability);
	}

	@ApiOperation(value = "Get The Availability", notes = "Used To Get The Availability")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Availability>> getAvailability(@PathVariable int id) {
		return availabilityService.getAvailabilityById(id);
	}

	@ApiOperation(value = "Update The Availability", notes = "Used To Update The Availability")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Availability>> updateAvailability(@RequestBody Availability availability,
			@RequestParam int id) {
		return availabilityService.updateAvailability(availability, id);
	}

	@ApiOperation(value = "Delete The Availability", notes = "Used To Delete The Availability")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Found"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Availability>> deleteAvailability(@PathVariable int id) {
		return availabilityService.deleteAvailability(id);
	}
}
