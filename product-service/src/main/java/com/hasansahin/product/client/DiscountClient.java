package com.hasansahin.product.client;


import com.hasansahin.soap.ws.client.DiscountRequest;
import com.hasansahin.soap.ws.client.DiscountResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class DiscountClient extends WebServiceGatewaySupport {

    public DiscountResponse discount(DiscountRequest discountRequest){
        return (DiscountResponse) getWebServiceTemplate().marshalSendAndReceive(discountRequest);
    }
}
