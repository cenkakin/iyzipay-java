package com.iyzipay.model.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreateBKMInitializeRequest;
import com.iyzipay.request.RetrieveBKMAuthRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BKMSample extends Sample {

    @Test
    public void should_initialize_bkm_express() {
        CreateBKMInitializeRequest request = new CreateBKMInitializeRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("1"));
        request.setBasketId("B67832");
        request.setPaymentGroup(PaymentGroup.PRODUCT.name());
        request.setBuyer(newBuyer());
        request.setShippingAddress(newShippingAddress());
        request.setBillingAddress(newBillingAddress());
        request.setBasketItems(newBasketItems());
        request.setCallbackUrl("https://www.merchant.com/callbackUrl");

        BKMInitialize bkmInitialize = BKMInitialize.create(request, options);

        System.out.println(bkmInitialize);

        assertNotNull(bkmInitialize.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), bkmInitialize.getStatus());
        assertEquals(Locale.TR.getValue(), bkmInitialize.getLocale());
        assertEquals("123456789", bkmInitialize.getConversationId());

        assertNotNull(bkmInitialize.getHtmlContent());
    }

    @Test
    public void should_retrieve_bkm_auth() {
        RetrieveBKMAuthRequest request = new RetrieveBKMAuthRequest();
        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setToken("mockToken1453382198111");

        BKMAuth bkmAuth = BKMAuth.retrieve(request, options);

        System.out.println(bkmAuth);

        assertNotNull(bkmAuth.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), bkmAuth.getStatus());
        assertEquals(Locale.TR.getValue(), bkmAuth.getLocale());
        assertEquals("123456", bkmAuth.getConversationId());
    }

    private Buyer newBuyer() {
        Buyer buyer = new Buyer();
        buyer.setId("100");
        buyer.setName("Hakan");
        buyer.setSurname("Erdoğan");
        buyer.setIdentityNumber("16045258606");
        buyer.setEmail("email@email.com");
        buyer.setGsmNumber("05553456789");
        buyer.setRegistrationDate("2011-02-17 12:00:00");
        buyer.setLastLoginDate("2015-04-20 12:00:00");
        buyer.setRegistrationAddress("Maltepe");
        buyer.setCity("Istanbul");
        buyer.setCountry("Turkiye");
        buyer.setZipCode("34840");
        buyer.setIp("192.168.123.102");
        return buyer;
    }

    private Address newShippingAddress() {
        Address address = new Address();
        address.setAddress("Malte Plaza No:56");
        address.setZipCode("34840");
        address.setContactName("Hakan");
        address.setCity("Istanbul");
        address.setCountry("Turkiye");
        return address;
    }

    private Address newBillingAddress() {
        Address address = new Address();
        address.setAddress("Malte Plaza No:56");
        address.setZipCode("34840");
        address.setContactName("Hakan");
        address.setCity("Istanbul");
        address.setCountry("Turkiye");
        return address;
    }

    private List<BasketItem> newBasketItems() {
        List<BasketItem> paymentBasketItemDtoList = new ArrayList<BasketItem>();

        BasketItem firstBasketItem = new BasketItem();
        firstBasketItem.setId("BI101");
        firstBasketItem.setName("ABC Marka Kolye");
        firstBasketItem.setCategory1("Giyim");
        firstBasketItem.setCategory2("Aksesuar");
        firstBasketItem.setItemType(BasketItemType.PHYSICAL.name());
        firstBasketItem.setPrice(new BigDecimal("0.3"));
        firstBasketItem.setSubMerchantKey("subMerchantKey");
        firstBasketItem.setSubMerchantPrice(new BigDecimal("0.27"));

        BasketItem secondBasketItem = new BasketItem();
        secondBasketItem.setId("BI102");
        secondBasketItem.setName("XYZ Oyun Kodu");
        secondBasketItem.setCategory1("Oyun");
        secondBasketItem.setCategory2("Online Oyun Kodlari");
        secondBasketItem.setItemType(BasketItemType.VIRTUAL.name());
        secondBasketItem.setPrice(new BigDecimal("0.5"));
        secondBasketItem.setSubMerchantKey("subMerchantKey");
        secondBasketItem.setSubMerchantPrice(new BigDecimal("0.42"));

        BasketItem thirdBasketItem = new BasketItem();
        thirdBasketItem.setId("BI103");
        thirdBasketItem.setName("EDC Marka Usb");
        thirdBasketItem.setCategory1("Elektronik");
        thirdBasketItem.setCategory2("Usb / Cable");
        thirdBasketItem.setItemType(BasketItemType.PHYSICAL.name());
        thirdBasketItem.setPrice(new BigDecimal("0.2"));
        thirdBasketItem.setSubMerchantKey("subMerchantKey");
        thirdBasketItem.setSubMerchantPrice(new BigDecimal("0.18"));

        paymentBasketItemDtoList.add(firstBasketItem);
        paymentBasketItemDtoList.add(secondBasketItem);
        paymentBasketItemDtoList.add(thirdBasketItem);
        return paymentBasketItemDtoList;
    }
}
