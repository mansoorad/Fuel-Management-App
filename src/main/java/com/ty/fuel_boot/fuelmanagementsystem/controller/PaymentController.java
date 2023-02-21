package com.ty.fuel_boot.fuelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.fuel_boot.fuelmanagementsystem.dto.Payment;
import com.ty.fuel_boot.fuelmanagementsystem.service.PaymentService;
import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	private PaymentService service;
	
	@ApiOperation(value = "SavePayment", notes = "It is used to Save Payment")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Payment>> savePayment(@RequestBody Payment payment){
		return service.savePayment(payment);
	}
	
	@ApiOperation(value = "UpdatePayment", notes = "It is used to Update Payment")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Updated"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Payment>> updatePayment(@RequestBody Payment payment, @RequestParam int id){
		return service.updatePayment(payment, id);
	}
	
	@ApiOperation(value = "GetPayment", notes = "It is used to Get Payment")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Payment>> getPaymentById(@RequestParam int id){
		return service.getPaymentById(id);
	}
	
	@ApiOperation(value = "DeletePayment", notes = "It is used to Delete the Payment")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Payment>> deletePayment(@RequestParam int id){
		return service.deletePayment(id);
	}
	
	@ApiOperation(value = "GetAllPayment", notes = "It is used to Get all the Payments")
	@ApiResponses(value = {@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@PatchMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<List<Payment>>> getAllPayment(){
		return service.getAllPayment();
	}
}
