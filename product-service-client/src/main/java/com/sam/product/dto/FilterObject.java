package com.sam.product.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FilterObject implements Serializable {

    private static final long serialVersionUID = 7028895678894078075L;

    private String name;
    private String color;
    private int fromPrice;
    private int toPrice;
    private int branch;

}
