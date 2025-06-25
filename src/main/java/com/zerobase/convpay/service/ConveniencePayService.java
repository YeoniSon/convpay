package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.type.PayResult;

public class ConveniencePayService { //편결이

    private static final MoneyAdapter moneyAdapter = new MoneyAdapter();

    public static PayResponse pay(PayRequest payRequest) {
        MoneyUseResult moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());


        //fail fast

        // Method()

        //Exception case 5
        //Exception case4
        //Exception case1
        //Exception case2
        //Exception case3

        //Success Case(Only one)

        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        //Success Case(Only one)
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());
    }
}
