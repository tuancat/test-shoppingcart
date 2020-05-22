package com.sam.product.dto;

import com.sam.product.entity.Branch;
import com.sam.product.entity.Categories;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {


    private static final long serialVersionUID = 5282208676459930295L;
    private Long id;
    private String name;
    private int price;
    private Branch branch;
    private String color;
}
