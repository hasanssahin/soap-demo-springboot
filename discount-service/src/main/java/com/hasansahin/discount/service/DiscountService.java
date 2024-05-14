package com.hasansahin.discount.service;

import com.hasansahin.discount.discount.DiscountRequest;
import com.hasansahin.discount.discount.DiscountResponse;
import com.hasansahin.discount.model.Category;
import com.hasansahin.discount.model.Discount;
import com.hasansahin.discount.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final CategoryService categoryService;
    private final DiscountRepository discountRepository;

    public DiscountResponse discount(DiscountRequest discountRequest){
        Category category=categoryService.getById(String.valueOf(discountRequest.getExternalCategoryId()));
        Optional<Discount> discount = discountRepository.findByDiscountCodeAndCategoryId(discountRequest.getDiscountCode(), category.getId());
        DiscountResponse.Response response=new DiscountResponse.Response();
        DiscountResponse discountResponse=new DiscountResponse();
        if (discount.isPresent()) {
            BigDecimal newPrice = discount.get().getDiscountAmount().subtract(BigDecimal.valueOf(discountRequest.getPrice())).multiply(BigDecimal.valueOf(-1));
            response.setStatus(true);
            response.setMessage("Discount applied successfully.");
            discountResponse.setDiscountCode(discountRequest.getDiscountCode());
            discountResponse.setOldPrice(discountRequest.getPrice());
            discountResponse.setNewPrice(newPrice.floatValue());
            discountResponse.setResponse(response);
            return discountResponse;
        }
        else {
            response.setStatus(false);
            response.setMessage("Discount failed.");
            discountResponse.setDiscountCode(discountRequest.getDiscountCode());
            discountResponse.setOldPrice(discountRequest.getPrice());
            discountResponse.setNewPrice(discountRequest.getPrice());
            discountResponse.setResponse(response);
            return discountResponse;
        }

    }
}
