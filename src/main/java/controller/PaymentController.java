package controller;

import domein.Payment;
import dto.PaymentCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import service.PaymentService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createPayment(PaymentCreateDTO createDTO){
        try {
            return paymentService.createPayment(createDTO).getPaymentId();
        }catch (InputMismatchException e){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"validation input exception");
    }catch (Exception e){
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    }

    @PostMapping("/create_list")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> createPaymentList(List<PaymentCreateDTO> createDTOS){
        try {
            List<Payment> list =paymentService.createPaymentList(createDTOS);

        List<Payment> list1=new ArrayList<>();
        for (Payment payment:
             list) {
            Payment p=new Payment();
            p.setPaymentId(payment.getPaymentId());
            p.setStatus(payment.getStatus());
            list1.add(p);
        }
        return list1;
        }catch (InputMismatchException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"validation input exception");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @GetMapping("/get_by_param")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> getPaymentList(PaymentCreateDTO createDTO){
       try {
           return paymentService.getPaymentListByParam(createDTO);
       }catch (InputMismatchException e){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"validation input exception");
       }catch (Exception e){
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    }

}
