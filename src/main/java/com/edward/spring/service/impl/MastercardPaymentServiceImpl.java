package com.edward.spring.service.impl;

import com.edward.spring.annotation.EdwardCustomizQualifier;
import com.edward.spring.enumeration.PaymentType;
import com.edward.spring.service.PaymentService;
import org.springframework.stereotype.Service;


//@Service("mastercardPaymentService")


@Service
@EdwardCustomizQualifier(PaymentType.MASTERCARD)
public class MastercardPaymentServiceImpl implements PaymentService {

    @Override
    public int pay(int amount) {
        System.out.println("Pay by Mastercard");
        return ++amount;
    }
}
