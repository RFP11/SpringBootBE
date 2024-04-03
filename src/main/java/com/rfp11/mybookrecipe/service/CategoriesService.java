package com.rfp11.mybookrecipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rfp11.mybookrecipe.model.Categories;
import com.rfp11.mybookrecipe.repositories.CategoriesRepository;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }
}
