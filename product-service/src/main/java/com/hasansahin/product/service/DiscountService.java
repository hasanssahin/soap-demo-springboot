package com.hasansahin.product.service;

import com.hasansahin.product.client.DiscountClient;
import com.hasansahin.product.model.Product;
import com.hasansahin.soap.ws.client.DiscountRequest;
import com.hasansahin.soap.ws.client.DiscountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final ProductService productService;
    private final DiscountClient client;

    public DiscountResponse getDiscount(Long productId, String discountCode) {
        Product product = productService.getById(productId);
        DiscountRequest discountRequest=new DiscountRequest();
        discountRequest.setDiscountCode(discountCode);
        discountRequest.setExternalCategoryId(product.getCategory().getId().intValue());
        discountRequest.setPrice(product.getPrice().floatValue());
        return client.discount(discountRequest);
    }
}
