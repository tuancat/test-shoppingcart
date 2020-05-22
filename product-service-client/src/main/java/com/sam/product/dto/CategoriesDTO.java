package com.sam.product.dto;

import com.sam.product.entity.Product;

import java.util.List;

public class CategoriesDTO {
    private Long id;
    private String name;
    private List<Product> listProduct;

    public CategoriesDTO(Long id, String name, List<Product> listProduct) {
        this.id = id;
        this.name = name;
        this.listProduct = listProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }
}
