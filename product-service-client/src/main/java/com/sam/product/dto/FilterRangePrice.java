package com.sam.product.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FilterRangePrice implements Serializable {

    private int fromPrice;
    private int toPrice;
}
