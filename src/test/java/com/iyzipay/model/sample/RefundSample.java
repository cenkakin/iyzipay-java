package com.iyzipay.model.sample;

import com.iyzipay.model.Locale;
import com.iyzipay.model.Refund;
import com.iyzipay.model.RefundChargedFromMerchant;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateRefundRequest;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RefundSample extends Sample {

    @Test
    public void should_refund() {
        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("50");
        request.setPrice(new BigDecimal("0.1"));
        request.setIp("127.0.0.1");

        Refund refund = Refund.create(request, options);

        System.out.println(refund);

        assertNotNull(refund.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), refund.getStatus());
        assertEquals(Locale.TR.getValue(), refund.getLocale());
        assertEquals("123456789", refund.getConversationId());
    }

    @Test
    public void should_refund_charged_from_merchant() {
        CreateRefundRequest request = new CreateRefundRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentTransactionId("41");
        request.setPrice(new BigDecimal("0.05"));
        request.setIp("127.0.0.1");

        RefundChargedFromMerchant refundChargedFromMerchant = RefundChargedFromMerchant.create(request, options);

        System.out.println(refundChargedFromMerchant);

        assertNotNull(refundChargedFromMerchant.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), refundChargedFromMerchant.getStatus());
        assertEquals(Locale.TR.getValue(), refundChargedFromMerchant.getLocale());
        assertEquals("123456789", refundChargedFromMerchant.getConversationId());
    }
}
