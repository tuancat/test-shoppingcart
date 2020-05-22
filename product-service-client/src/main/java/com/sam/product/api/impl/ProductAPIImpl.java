package com.sam.product.api.impl;

import com.sam.product.api.ProductAPI;
import com.sam.product.common.ResponseModel;
import com.sam.product.dto.FilterObject;
import com.sam.product.dto.FilterRangePrice;
import com.sam.product.dto.ProductDTO;
import com.sam.product.service.ProductService;
import com.sam.product.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAPIImpl implements ProductAPI {
    @Autowired
    private ProductService productService;

    @Override
    public ResponseModel add(ProductDTO dto) {
        return new ResponseModel();
    }

    @Override
    public ResponseModel update(Long id, ProductDTO dto) {
        return new ResponseModel();
    }

    @Override
    public ResponseModel findById(Long id) {
        return new ResponseModel(productService.findById(id));
    }

    @Override
    public ResponseModel delete(Long id) {
        return new ResponseModel();
    }

    @Override
    public ResponseModel findByName(FilterObject filterObject) {
        return new ResponseModel(productService.searchByName(filterObject.getName()));
    }

    @Override
    public ResponseModel findByColor(FilterObject filterObject) {
        return new ResponseModel(productService.searchByColor(filterObject.getColor()));
    }

    @Override
    public ResponseModel findByBrandId(FilterObject filterObject) {
        return new ResponseModel(productService.searchByBranch(filterObject.getBranchId()));
    }

    @Override
    public ResponseModel findByPrice(FilterRangePrice filterRangePrice) {
        return new ResponseModel(productService.filterByPrice(filterRangePrice.getFromPrice(), filterRangePrice.getToPrice()));
    }


}
