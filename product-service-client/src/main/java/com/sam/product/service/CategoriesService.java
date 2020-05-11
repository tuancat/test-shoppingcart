package com.sam.product.service;

import com.sam.product.entity.Categories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriesService {
    public Categories saveOrUpdate(Categories ca);

    public List findAll();

    public void delete(Long id);

    public Categories findById(Long id);
}
