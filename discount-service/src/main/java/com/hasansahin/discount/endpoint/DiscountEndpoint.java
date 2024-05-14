package com.hasansahin.discount.endpoint;

import com.hasansahin.discount.discount.DiscountRequest;
import com.hasansahin.discount.discount.DiscountResponse;
import com.hasansahin.discount.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class DiscountEndpoint {
    private static final String NAMESPACE_URI = "http://www.hasansahin.com/discount/discount";
    private final DiscountService discountService;
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DiscountRequest")
    @ResponsePayload
    public DiscountResponse discount(@RequestPayload DiscountRequest discountRequest){
        return discountService.discount(discountRequest);
    }
}
