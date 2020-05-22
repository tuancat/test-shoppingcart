package com.sam.product.service.impl;

import com.sam.product.converter.CategoriesConverter;
import com.sam.product.dto.CategoriesDTO;
import com.sam.product.entity.Categories;
import com.sam.product.exception.ResourceNotFoundException;
import com.sam.product.repository.CategoriesRepository;
import com.sam.product.service.CategoriesService;
import com.sam.product.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("categoriesService")
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CategoriesConverter categoriesConverter;

    @Override
    public CategoriesDTO add(CategoriesDTO dto) {
        Categories categories = categoriesConverter.convertToEntity(dto);
        categories.setId(null);
        return categoriesConverter.convertToDTO(categoriesRepository.save(categories));
    }

    @Override
    public CategoriesDTO findById(long id) {
        Optional<Categories> optional = categoriesRepository.findById(id);
        if (!optional.isPresent())
            throw new ResourceNotFoundException(Constants.CAN_NOT_BE_FOUND_ENTITY_MESSAGE);
        return categoriesConverter.convertToDTO(optional.get());
    }

    @Override
    public boolean delete(long id) {
        Optional<Categories> optional = categoriesRepository.findById(id);
        if (!optional.isPresent())
            throw new ResourceNotFoundException(Constants.CAN_NOT_BE_FOUND_ENTITY_MESSAGE);
        categoriesRepository.deleteById(id);
        return true;
    }

    @Override
    public CategoriesDTO update(long id, CategoriesDTO dto) {
        Optional<Categories> optional = categoriesRepository.findById(id);
        if (!optional.isPresent())
            throw new ResourceNotFoundException(Constants.CAN_NOT_BE_FOUND_ENTITY_MESSAGE);
        Categories categoriesModify = categoriesConverter.convertToEntity(dto);
        categoriesModify.setId(id);
        return categoriesConverter.convertToDTO(categoriesRepository.save(categoriesModify));
    }

    @Override
    public List<CategoriesDTO> findAll() {
        List<Categories> tradings = categoriesRepository.findAll();
        return categoriesConverter.convertEntitiesToDTOs(tradings);
    }
}
