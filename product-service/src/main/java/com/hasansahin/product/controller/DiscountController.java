package com.hasansahin.product.controller;


import com.hasansahin.product.service.DiscountService;
import com.hasansahin.soap.ws.client.DiscountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discounts")
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService discountService;
    @GetMapping
    public ResponseEntity<DiscountResponse> getDiscount(@RequestParam Long productId, @RequestParam String discountCode) {
        return ResponseEntity.ok(discountService.getDiscount(productId, discountCode));
    }
}