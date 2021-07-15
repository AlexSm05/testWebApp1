package service;

import domein.Payment;
import dto.PaymentCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PaymentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(PaymentCreateDTO createDTO){
        Payment payment=new Payment();
        payment.setPaymentId(createDTO.getPaymentId());
        payment.setCreatedAt(createDTO.getCreatedAt());
        payment.setDstAccId(createDTO.getDstAccId());
        payment.setSrcAccId(createDTO.getSrcAccId());
        payment.setAmount(createDTO.getAmount());
        payment.setStatus(createDTO.getStatus());
        payment=paymentRepository.save(payment);
        return payment;

    }
    public List<Payment> createPaymentList(List<PaymentCreateDTO> list){
        List<Payment> payments=new ArrayList<>();
        for (PaymentCreateDTO createDTO:
             list) {
            payments.add(createPayment(createDTO));
        }
        return payments;
    }


    public List<Payment> getPaymentListByParam(PaymentCreateDTO createDTO){
        List<Payment> payments=new ArrayList<>();
        paymentRepository.findAll().forEach(payments::add);
        for (Payment payment:
             payments) {
            if (payment.getPayer().equals(createDTO.getPayer())&&
                    payment.getRecipient().equals(createDTO.getRecipient())&&
                    payment.getSrcAccId().equals(createDTO.getSrcAccId())&&
                    payment.getDstAccId().equals((createDTO.getDstAccId()))){
            }else {
                payments.remove(payment);
            }
        }
        return payments;
    }
}
