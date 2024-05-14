package com.hasansahin.discount.service;

import com.hasansahin.discount.model.Category;
import com.hasansahin.discount.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public Category getById(String externalId){
        return categoryRepository.findByExternalId(externalId).orElse(null);
    }
}
