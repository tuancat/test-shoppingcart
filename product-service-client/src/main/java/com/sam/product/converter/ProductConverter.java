package com.sam.product.converter;

import com.sam.product.dto.ProductDTO;
import com.sam.product.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("product_converter")
public class ProductConverter extends SuperConverter<ProductDTO, Product> {

    @Autowired
    ModelMapper mapper;
    @Override
    public ProductDTO convertToDTO(Product entity) {
        return mapper.map(entity, ProductDTO.class);
    }

    @Override
    public Product convertToEntity(ProductDTO dto) {
        return mapper.map(dto, Product.class);
    }

    @Override
    public ProductDTO convertEntityToDTOByUserId(String contactId, Product entity) {
        return null;
    }
}
