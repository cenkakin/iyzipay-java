package com.iyzipay.model.sample;

import com.iyzipay.model.*;
import com.iyzipay.request.CreatePaymentRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PaymentPreAuthSample extends Sample {

    @Test
    public void should_create_market_place_non_threeds_physical_and_virtual_product_payment() {
        CreatePaymentRequest request = new CreatePaymentRequest();

        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("1"));
        request.setPaidPrice(new BigDecimal("1.1"));
        request.setInstallment(1);
        request.setBasketId("B67832");
        request.setPaymentChannel(PaymentChannel.WEB.name());
        request.setPaymentGroup(PaymentGroup.PRODUCT.name());

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardHolderName("John Doe");
        paymentCard.setCardNumber("5528790000000008");
        paymentCard.setExpireMonth("12");
        paymentCard.setExpireYear("2030");
        paymentCard.setCvc("123");
        paymentCard.setRegisterCard(0);
        request.setPaymentCard(paymentCard);

        Buyer buyer = new Buyer();
        buyer.setId("BY789");
        buyer.setName("Sabri Onur");
        buyer.setSurname("Tüzün");
        buyer.setGsmNumber("+905350000000");
        buyer.setEmail("email@email.com");
        buyer.setIdentityNumber("74300864791");
        buyer.setLastLoginDate("2015-10-05 12:43:35");
        buyer.setRegistrationDate("2013-04-21 15:12:09");
        buyer.setRegistrationAddress("Nidakule Göztepe İş Merkezi Merdivenköy Mah. Bora Sok. No:1 Kat:19 Bağımsız 70/73 Göztepe Kadıköy");
        buyer.setIp("85.34.78.112");
        buyer.setCity("İstanbul");
        buyer.setCountry("Türkiye");
        buyer.setZipCode("34732");
        request.setBuyer(buyer);

        Address shippingAddress = new Address();
        shippingAddress.setContactName("Hakan Erdoğan");
        shippingAddress.setCity("İstanbul");
        shippingAddress.setCountry("Türkiye");
        shippingAddress.setAddress("19 Mayıs Mah. İnönü Cad. No:45 Kozyatağı");
        shippingAddress.setZipCode("34742");
        request.setShippingAddress(shippingAddress);

        Address billingAddress = new Address();
        billingAddress.setContactName("Hakan Erdoğan");
        billingAddress.setCity("İstanbul");
        billingAddress.setCountry("Türkiye");
        billingAddress.setAddress("19 Mayıs Mah. İnönü Cad. No:45 Kozyatağı");
        billingAddress.setZipCode("34742");
        request.setBillingAddress(billingAddress);

        List<BasketItem> basketItems = new ArrayList<BasketItem>();
        BasketItem basketItem1 = new BasketItem();
        basketItem1.setId("BI101");
        basketItem1.setName("ABC Marka Kolye");
        basketItem1.setCategory1("Giyim");
        basketItem1.setCategory2("Aksesuar");
        basketItem1.setItemType(BasketItemType.PHYSICAL.name());
        basketItem1.setPrice(new BigDecimal("0.3"));
        basketItem1.setSubMerchantKey("subMerchantKey");
        basketItem1.setSubMerchantPrice(new BigDecimal("0.27"));
        basketItems.add(basketItem1);

        BasketItem basketItem2 = new BasketItem();
        basketItem2.setId("BI102");
        basketItem2.setName("XYZ Oyun Kodu");
        basketItem2.setCategory1("Oyun");
        basketItem2.setCategory2("Online Oyun Kodları");
        basketItem2.setItemType(BasketItemType.VIRTUAL.name());
        basketItem2.setPrice(new BigDecimal("0.5"));
        basketItem2.setSubMerchantKey("subMerchantKey");
        basketItem2.setSubMerchantPrice(new BigDecimal("0.42"));
        basketItems.add(basketItem2);

        BasketItem basketItem3 = new BasketItem();
        basketItem3.setId("BI103");
        basketItem3.setName("EDC Marka Usb");
        basketItem3.setCategory1("Elektronik");
        basketItem3.setCategory2("Usb / Cable");
        basketItem3.setItemType(BasketItemType.PHYSICAL.name());
        basketItem3.setPrice(new BigDecimal("0.2"));
        basketItem3.setSubMerchantKey("subMerchantKey");
        basketItem3.setSubMerchantPrice(new BigDecimal("0.18"));
        basketItems.add(basketItem3);
        request.setBasketItems(basketItems);

        PaymentPreAuth paymentPreAuth = PaymentPreAuth.create(request, options);

        System.out.println(paymentPreAuth);

        assertNotNull(paymentPreAuth.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), paymentPreAuth.getStatus());
        assertEquals(Locale.TR.getValue(), paymentPreAuth.getLocale());
        assertEquals("123456789", paymentPreAuth.getConversationId());
    }

    @Test
    public void should_create_physical_and_virtual_listing_or_subscription_payment() {
        CreatePaymentRequest request = new CreatePaymentRequest();

        request.setLocale(Locale.TR.getValue());
        request.setConversationId("123456789");
        request.setPrice(new BigDecimal("1"));
        request.setPaidPrice(new BigDecimal("1.1"));
        request.setInstallment(3);
        request.setBasketId("B67832");
        request.setPaymentChannel(PaymentChannel.WEB.name());
        request.setPaymentGroup(PaymentGroup.SUBSCRIPTION.name());

        PaymentCard paymentCard = new PaymentCard();
        paymentCard.setCardHolderName("John Doe");
        paymentCard.setCardNumber("5528790000000008");
        paymentCard.setExpireMonth("12");
        paymentCard.setExpireYear("2030");
        paymentCard.setCvc("123");
        paymentCard.setRegisterCard(0);
        request.setPaymentCard(paymentCard);

        Buyer buyer = new Buyer();
        buyer.setId("BY789");
        buyer.setName("Sabri Onur");
        buyer.setSurname("Tüzün");
        buyer.setGsmNumber("+905350000000");
        buyer.setEmail("onur.tuzun@iyzico.com");
        buyer.setIdentityNumber("74300864791");
        buyer.setLastLoginDate("2015-10-05 12:43:35");
        buyer.setRegistrationDate("2013-04-21 15:12:09");
        buyer.setRegistrationAddress("Nidakule Göztepe İş Merkezi Merdivenköy Mah. Bora Sok. No:1 Kat:19 Bağımsız 70/73 Göztepe Kadıköy");
        buyer.setIp("85.34.78.112");
        buyer.setCity("İstanbul");
        buyer.setCountry("Türkiye");
        buyer.setZipCode("34732");
        request.setBuyer(buyer);

        Address shippingAddress = new Address();
        shippingAddress.setContactName("Hakan Erdoğan");
        shippingAddress.setCity("İstanbul");
        shippingAddress.setCountry("Türkiye");
        shippingAddress.setAddress("19 Mayıs Mah. İnönü Cad. No:45 Kozyatağı");
        shippingAddress.setZipCode("34742");
        request.setShippingAddress(shippingAddress);

        Address billingAddress = new Address();
        billingAddress.setContactName("Hakan Erdoğan");
        billingAddress.setCity("İstanbul");
        billingAddress.setCountry("Türkiye");
        billingAddress.setAddress("19 Mayıs Mah. İnönü Cad. No:45 Kozyatağı");
        billingAddress.setZipCode("34742");
        request.setBillingAddress(billingAddress);

        List<BasketItem> basketItems = new ArrayList<BasketItem>();
        BasketItem basketItem1 = new BasketItem();
        basketItem1.setId("BI101");
        basketItem1.setName("Dükkan aboneliği ve katalog");
        basketItem1.setCategory1("Abonelik");
        basketItem1.setCategory2("Dükkan");
        basketItem1.setItemType(BasketItemType.PHYSICAL.name());
        basketItem1.setPrice(new BigDecimal("0.3"));
        basketItems.add(basketItem1);

        BasketItem basketItem2 = new BasketItem();
        basketItem2.setId("BI102");
        basketItem2.setName("Listeleme aboneliği");
        basketItem2.setCategory1("Abonelik");
        basketItem2.setCategory2("Listeleme");
        basketItem2.setItemType(BasketItemType.VIRTUAL.name());
        basketItem2.setPrice(new BigDecimal("0.5"));
        basketItems.add(basketItem2);

        BasketItem basketItem3 = new BasketItem();
        basketItem3.setId("BI103");
        basketItem3.setName("Servis aboneliği");
        basketItem3.setCategory1("Abonelik");
        basketItem3.setCategory2("Servis");
        basketItem3.setItemType(BasketItemType.VIRTUAL.name());
        basketItem3.setPrice(new BigDecimal("0.2"));
        basketItems.add(basketItem3);
        request.setBasketItems(basketItems);

        PaymentPreAuth paymentPreAuth = PaymentPreAuth.create(request, options);

        System.out.println(paymentPreAuth);

        assertNotNull(paymentPreAuth.getSystemTime());
        assertEquals(Status.SUCCESS.getValue(), paymentPreAuth.getStatus());
        assertEquals(Locale.TR.getValue(), paymentPreAuth.getLocale());
        assertEquals("123456789", paymentPreAuth.getConversationId());
    }
}
