package com.hotel.paymentservice.controller;

import com.hotel.paymentservice.entities.PaymentTransaction;
import com.hotel.paymentservice.entities.PaymentTransactionRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1")
public class PaymentServiceController {
    Logger logger = LoggerFactory.getLogger(PaymentServiceController.class);

    @Autowired
    PaymentTransactionRepository paymentTransactionRepository;


    @PostMapping("/make/payment/{username}/{reservationId}/{totalCost}/{paymentType}")
    public ResponseEntity<String> makePayment(@PathVariable("username") String userName
                                             ,@PathVariable("reservationId") String reservationId,
                                              @PathVariable("totalCost") String totalCost,
                                              @PathVariable("paymentType") String paymentType) {

        PaymentTransaction pay = new PaymentTransaction();

        pay.setPaymentId(String.valueOf((int)(Math.random()*100000)));
        pay.setReservationId(reservationId);
        pay.setPaymentAmount(new BigDecimal(totalCost));
        pay.setPaymentMethod(paymentType);
        pay.setStatus("COMPLETED");
        LocalDate date = LocalDate.now();
        date.format(DateTimeFormatter.ofPattern("d/MM/uuuu"));
        pay.setPaymentDate(String.valueOf(date));

        paymentTransactionRepository.save(pay);

        return new ResponseEntity<>("Payment Done", HttpStatus.ACCEPTED);
    }


}
