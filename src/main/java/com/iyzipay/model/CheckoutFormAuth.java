package com.iyzipay.model;

import com.iyzipay.HttpClient;
import com.iyzipay.Options;
import com.iyzipay.request.RetrieveCheckoutFormAuthRequest;

public class CheckoutFormAuth extends Payment {

    private String token;
    private String callbackUrl;
    private String paymentStatus;

    public static CheckoutFormAuth retrieve(RetrieveCheckoutFormAuthRequest request, Options options) {
        return HttpClient.create().post(options.getBaseUrl() + "/payment/iyzipos/checkoutform/auth/ecom/detail",
                getHttpHeaders(request, options),
                request,
                CheckoutFormAuth.class);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
