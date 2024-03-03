package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PaymentDTO;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<?> addNewPayment(@RequestBody  PaymentDTO dto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.addNewPayment(dto));
	}
	
	
	@PutMapping("/{pId}")
	public ResponseEntity<?> updatePayment(@PathVariable Long pId, @RequestBody  PaymentDTO dto) {
		
		return ResponseEntity.ok(paymentService.updatePayment(pId, dto));
	}
	
	@GetMapping("/{pId}")
	public ResponseEntity<?> getPaymentDetails(@PathVariable Long pId) {
		
		return ResponseEntity
				.ok(paymentService.getPaymentDetails(pId));
	}
	
	@DeleteMapping("/{pId}")
	public ResponseEntity<?> deletePayment(@PathVariable Long pId) {
		
		return ResponseEntity.ok(paymentService.deletePaymentDetails(pId));
	}
	
}
