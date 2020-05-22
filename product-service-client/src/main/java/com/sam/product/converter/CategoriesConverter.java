package com.sam.product.converter;

import com.sam.product.dto.CategoriesDTO;
import com.sam.product.entity.Categories;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("categories_converter")
public class CategoriesConverter extends SuperConverter<CategoriesDTO, Categories> {


    @Autowired
    ModelMapper mapper;

    @Override
    public CategoriesDTO convertToDTO(Categories entity) {
        return mapper.map(entity, CategoriesDTO.class);
    }

    @Override
    public Categories convertToEntity(CategoriesDTO dto) {
        return mapper.map(dto, Categories.class);
    }

    @Override
    public CategoriesDTO convertEntityToDTOByUserId(String contactId, Categories entity) {
        return null;
    }
}
