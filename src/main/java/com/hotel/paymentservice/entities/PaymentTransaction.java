package com.hotel.paymentservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "payment_transactions")
public class PaymentTransaction {
    @Id
    @Column(name = "payment_id", nullable = false, length = 10)
    private String paymentId;

    @Column(name = "reservation_id", length = 10)
    private String reservationId;

    @Column(name = "payment_date", length = 10)
    private String paymentDate;

    @Column(name = "payment_amount", precision = 10, scale = 2)
    private BigDecimal paymentAmount;

    @Column(name = "payment_method", length = 10)
    private String paymentMethod;

    @Column(name = "status", length = 10)
    private String status;

}