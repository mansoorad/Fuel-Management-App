package com.ty.fuel_boot.fuelmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.fuel_boot.fuelmanagementsystem.dto.Payment;
import com.ty.fuel_boot.fuelmanagementsystem.repo.PaymentReposiratory;

@Repository
public class PaymentDao {
	@Autowired
	private PaymentReposiratory reposiratory;
	
	public Payment saveAdmin(Payment payment) {
		return reposiratory.save(payment);
	}
	
	public Payment updatePayment(Payment payment){
		return reposiratory.save(payment);
	}
	
	public Optional<Payment> getPaymentById(int id){
		return reposiratory.findById(id);
	}
	
	public void deletePayment(Payment payment) {
		reposiratory.delete(payment);
	}
	
	public List<Payment> getAllPayment(){
		return reposiratory.findAll();
	}
}
