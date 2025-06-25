package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.*;

public class ConveniencePayService { //편결이

    private static final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private static final CardAdapter cardAdapter = new CardAdapter();

    public static PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface;

        if (payRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        PaymentResult payment = paymentInterface.payment(payRequest.getPayAmount());

//        CardUseResult cardUseResult;
//        MoneyUseResult moneyUseResult;
//
//        if (payRequest.getPayMethodType() == PayMethodType.CARD){
//            cardAdapter.authorization();
//            cardAdapter.approval();
//            cardUseResult = cardAdapter.capture(payRequest.getPayAmount());
//        }else {
//            moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());
//        }


        //fail fast

        // Method()

        //Exception case 5
        //Exception case4
        //Exception case1
        //Exception case2
        //Exception case3

        //Success Case(Only one)

        if (payment == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        //Success Case(Only one)
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
    }

    public static PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if (payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
