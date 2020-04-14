package com.it.springcloud.service;

import com.it.springcloud.entity.Payment;


public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
