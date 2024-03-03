package com.app.service;

import com.app.dto.PaymentDTO;
import com.app.dto.PaymentsDTO;

public interface PaymentService {

	PaymentDTO updatePayment(Long pId, PaymentDTO dto);

	PaymentDTO getPaymentDetails(Long pId);

	String deletePaymentDetails(Long pId);

	PaymentsDTO addNewPayment(PaymentDTO dto);

}
