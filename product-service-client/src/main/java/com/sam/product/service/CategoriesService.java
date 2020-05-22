package com.sam.product.service;

import com.sam.product.dto.CategoriesDTO;
import com.sam.product.entity.Categories;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoriesService {
    CategoriesDTO add(CategoriesDTO dto);

    CategoriesDTO findById(long id);

    boolean delete(long id);

    CategoriesDTO update(long id, CategoriesDTO dto);

    List<CategoriesDTO> findAll();
}
