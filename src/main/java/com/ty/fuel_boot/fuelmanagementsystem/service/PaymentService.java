package com.ty.fuel_boot.fuelmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.fuel_boot.fuelmanagementsystem.dao.PaymentDao;
import com.ty.fuel_boot.fuelmanagementsystem.dto.Payment;
import com.ty.fuel_boot.fuelmanagementsystem.exception.NoSuchIdFoundException;
import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;

@Service
public class PaymentService {
	@Autowired
	private PaymentDao dao;
	
	public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment) {
		ResponseStructure<Payment> responseStructure = new ResponseStructure<Payment>();
		ResponseEntity<ResponseStructure<Payment>> responseEntity = new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Payment saved Successfully");
		responseStructure.setData(dao.saveAdmin(payment));
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<Payment>> updatePayment(Payment payment, int id){
		Optional<Payment> optional = dao.getPaymentById(id);
		ResponseStructure<Payment> responseStructure = new ResponseStructure<Payment>();
		ResponseEntity<ResponseStructure<Payment>> responseEntity = new 
				ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
		if(optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Payment Updated Successfully");
			responseStructure.setData(dao.updatePayment(payment));
			return responseEntity;
		}else {
			throw new NoSuchIdFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Payment>> getPaymentById(int id){
		Optional<Payment> optional = dao.getPaymentById(id);
		ResponseStructure<Payment> responseStructure = new ResponseStructure<Payment>();
		ResponseEntity<ResponseStructure<Payment>> responseEntity = new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
		if(optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Payment Retrieved Successfully");
			responseStructure.setData(optional.get());
			return responseEntity;
		}else {
			throw new NoSuchIdFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Payment>> deletePayment(int id){
		ResponseStructure<Payment> responseStructure = new ResponseStructure<Payment>();
		ResponseEntity<ResponseStructure<Payment>> responseEntity = new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
		Optional<Payment> optional = dao.getPaymentById(id);
		if(optional.isPresent()) {
			dao.deletePayment(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Payment Successfully Deleted");
			responseStructure.setData(optional.get());
			return responseEntity;
		}else {
			throw new NoSuchIdFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Payment>>> getAllPayment(){
		ResponseStructure<List<Payment>> responseStructure = new ResponseStructure<List<Payment>>();
		ResponseEntity<ResponseStructure<List<Payment>>> responseEntity = new ResponseEntity<ResponseStructure<List<Payment>>>(responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("All Payment Details Retrieved Successfully");
		responseStructure.setData(dao.getAllPayment());
		return responseEntity;
	}
}
