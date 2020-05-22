package com.sam.product.service;

import com.sam.product.common.PagedResult;
import com.sam.product.dto.ProductDTO;
import com.sam.product.entity.Categories;
import com.sam.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public List findAll();



    public void delete(Long id);

    public Product findById(Long id);

    public Product saveOrUpdate(Product product);

    public List filterByBranch(String branch);

    public List listProductByCategoryId(Long categoryId);

    public PagedResult<ProductDTO> searchByName(String name, int page, int size, String order);
    public PagedResult<ProductDTO> searchByColor(String color, int page, int size, String order);

    public PagedResult<ProductDTO> searchByBranch(Long branchId, int page, int size, String order);

    public PagedResult<ProductDTO> filterByPrice(int fromPrice, int toPrice, int page, int size, String order);
}
