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

    public List<ProductDTO> searchByName(String name);
    public List<ProductDTO> searchByColor(String color);

    public List<ProductDTO> searchByBranch(Long branchId);

    public List<ProductDTO> filterByPrice(int fromPrice, int toPrice);
}
