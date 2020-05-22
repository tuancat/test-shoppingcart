package com.sam.product.api.impl;

import com.sam.product.api.CategoriesAPI;
import com.sam.product.common.ResponseModel;
import com.sam.product.dto.CategoriesDTO;
import com.sam.product.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesAPIImpl implements CategoriesAPI {

    @Autowired
    CategoriesService categoriesService;

    @Override
    public ResponseModel add(CategoriesDTO dto) {
        return new ResponseModel(categoriesService.add(dto));
    }

    @Override
    public ResponseModel update(long id, CategoriesDTO dto) {
        return new ResponseModel(categoriesService.update(id, dto));
    }

    @Override
    public ResponseModel findById(long id) {
        return new ResponseModel(categoriesService.findById(id));
    }

    @Override
    public ResponseModel delete(long id) {
        return new ResponseModel(categoriesService.delete(id));
    }

    @Override
    public ResponseModel findAll() {
        return new ResponseModel(categoriesService.findAll());
    }
}
