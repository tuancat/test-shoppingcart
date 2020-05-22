package com.sam.product.controller;

import com.sam.product.common.ResponseModel;
import com.sam.product.service.CategoriesService;
import com.sam.product.utils.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ApiConstants.API_VERSION_1)
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping(path = ApiConstants.CATEGORIES_END_POINT)
    public ResponseModel list() {
        List listCategories = categoriesService.findAll();
        ResponseModel result = new ResponseModel(listCategories);

        return result;
    }
}
