package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PaymentResult;

public interface PaymentInterface {
    // DIP로 머니어뎁터와 카드 어뎁터가 의존하도록 interface를 만듦
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);

    PayMethodType getPayMethodType();
}
