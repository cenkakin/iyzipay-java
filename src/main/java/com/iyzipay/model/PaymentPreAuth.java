package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.CreatePaymentAuthRequest;

public class PaymentPreAuth extends Payment {

    public static PaymentPreAuth create(CreatePaymentAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/preauth/ecom",
                getHttpHeaders(request, options),
                request,
                PaymentPreAuth.class)
                .getBody();
    }
}