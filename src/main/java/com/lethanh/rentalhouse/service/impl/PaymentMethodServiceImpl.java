package com.lethanh.rentalhouse.service.impl;

import com.lethanh.rentalhouse.model.PaymentMethodModel;
import com.lethanh.rentalhouse.repository.PaymentMethodRepository;
import com.lethanh.rentalhouse.service.PaymentMethodService;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {
    PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public PaymentMethodModel save(PaymentMethodModel paymentMethodModel) {
        return paymentMethodRepository.save(paymentMethodModel);
    }
}
