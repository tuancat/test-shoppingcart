package com.sam.product.service.impl;

import com.sam.product.entity.Categories;
import com.sam.product.repository.CategoriesRepository;
import com.sam.product.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Override
    public Categories saveOrUpdate(Categories ca) {
        return categoriesRepository.save(ca);
    }

    @Override
    public List findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        categoriesRepository.delete(this.findById(id));
    }

    @Override
    public Categories findById(Long id) {
        return categoriesRepository.getOne(id);
    }
}
