package com.zerobase.convpay.service;


import com.zerobase.convpay.dto.PayRequest;

public interface DiscountInterface {
    //할인 된 금액
    Integer getDiscountedAmount(PayRequest payRequest);
}
