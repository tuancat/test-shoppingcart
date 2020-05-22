package com.sam.product.api;

import com.sam.product.common.ResponseModel;
import com.sam.product.dto.FilterObject;
import com.sam.product.dto.FilterRangePrice;
import com.sam.product.dto.ProductDTO;
import com.sam.product.utils.ApiConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api
public interface ProductAPI {
    @ApiOperation(value = "Add product", response = ResponseModel.class)
    @PostMapping(path = ApiConstants.PRODUCT_END_POINT)
    ResponseModel add(@RequestBody ProductDTO dto);

    @ApiOperation(value = "Update product", response = ResponseModel.class)
    @PutMapping(path = ApiConstants.PRODUCT_BY_ID_END_POINT)
    ResponseModel update(@PathVariable Long id, @RequestBody ProductDTO dto);

    @ApiOperation(value = "Find by product id", response = ResponseModel.class)
    @GetMapping(path = ApiConstants.PRODUCT_BY_ID_END_POINT)
    ResponseModel findById(@PathVariable Long id);

    @ApiOperation(value = "Delete product by Id", response = ResponseModel.class)
    @DeleteMapping(path = ApiConstants.PRODUCT_BY_ID_END_POINT)
    ResponseModel delete(@PathVariable Long id);


    @ApiOperation(value = "Search product by name", response = ResponseModel.class)
    @PostMapping(path = ApiConstants.PRODUCT_BY_NAME_END_POINT)
    ResponseModel findByName(@RequestBody FilterObject filterObject);

    @ApiOperation(value = "Search product by color", response = ResponseModel.class)
    @PostMapping(path = ApiConstants.PRODUCT_BY_COLOR_END_POINT)
    ResponseModel findByColor(@RequestBody FilterObject filterObject);

    @ApiOperation(value = "Search product by branch Id", response = ResponseModel.class)
    @PostMapping(path = ApiConstants.PRODUCT_BY_BRANCH_END_POINT)
    ResponseModel findByBrandId(@RequestBody FilterObject filterObject);

    @ApiOperation(value = "Filter product by Price", response = ResponseModel.class)
    @PostMapping(path = ApiConstants.PRODUCT_FILTER_BY_PRICE_END_POINT)
    ResponseModel findByPrice(@RequestBody FilterRangePrice filterRangePrice);


}
