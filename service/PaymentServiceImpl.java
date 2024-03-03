package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.DonorDao;
import com.app.dao.PaymentDao;
import com.app.dto.PaymentDTO;
import com.app.dto.PaymentsDTO;
import com.app.entities.Donor;
import com.app.entities.Payment;
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDao paymentdao;
	
	@Autowired
	private DonorDao donordao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public PaymentDTO updatePayment(Long pId, PaymentDTO dto) {
		Payment pay =paymentdao.findById(pId).
				orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id !!!!"));
				pay.setTransId(dto.getTransId());
				pay.setAmount(dto.getAmount());
				pay.setPays(dto.getPays());
				pay.setDate(dto.getDate());
				pay.setId(dto.getDonorId());
				return mapper.map(pay, PaymentDTO.class);
		
	}

	@Override
	public PaymentDTO getPaymentDetails(Long pId) {
		Payment payment=paymentdao.findById(pId).orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id !!!!"));
		PaymentDTO p=mapper.map(payment,PaymentDTO.class);
		p.setDonorId(payment.getDonor().getId());
		return p;
		
	}



	@Override
	public String deletePaymentDetails(Long pId) {
		Payment pay = paymentdao.findById(pId).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		paymentdao.delete(pay);
		return ("Pet"+" "+pId+" is deleted");
	}

	@Override
	public PaymentsDTO addNewPayment(PaymentDTO dto) {
//		User user = userdao.findById(dto.getUserId())
//				.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id!!!"));
//		Pets petEntity = mapper.map(dto, Pets.class);
//		user.addPets(petEntity);
//		Pets savedPet =petdao.save(petEntity);
//		System.out.println("emp entity id " + petEntity.getId() + " " + savedPet.getId());
//		return mapper.map(savedPet, PetDTO.class);
		
		Donor dnr = donordao.findById(dto.getDonorId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id!!!"));
		Payment paymentEntity = mapper.map(dto, Payment.class);
		dnr.addPayments(paymentEntity);
		Payment savedPayment =paymentdao.save(paymentEntity);
		System.out.println("emp entity id " + paymentEntity.getId() + " " + savedPayment.getId());
		return mapper.map(savedPayment, PaymentsDTO.class);	
	}

}
