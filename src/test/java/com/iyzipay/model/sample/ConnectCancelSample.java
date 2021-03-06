package com.iyzipay.model.sample;

import com.iyzipay.model.ConnectCancel;
import com.iyzipay.model.Locale;
import com.iyzipay.model.Status;
import com.iyzipay.request.CreateCancelRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConnectCancelSample extends Sample {

    @Test
    public void should_cancel_payment() {
        CreateCancelRequest request = new CreateCancelRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPaymentId("24");
        request.setIp("127.0.0.1");

        ConnectCancel connectCancel = ConnectCancel.create(request, options);

        System.out.println(connectCancel);

        assertNotNull(connectCancel.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), connectCancel.getStatus());
        assertEquals(Locale.TR.getValue(), connectCancel.getLocale());
        assertEquals("123456789", connectCancel.getConversationId());
    }
}
