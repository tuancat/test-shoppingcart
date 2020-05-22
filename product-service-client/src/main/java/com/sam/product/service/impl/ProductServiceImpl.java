package com.sam.product.service.impl;

import com.sam.product.common.PagedResult;
import com.sam.product.converter.ProductConverter;
import com.sam.product.dto.ProductDTO;
import com.sam.product.entity.Branch;
import com.sam.product.entity.Product;
import com.sam.product.repository.BranchRepository;
import com.sam.product.repository.ProductRepository;
import com.sam.product.service.ProductService;
import com.sam.product.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    ProductConverter productConverter;


    @Override
    public List findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Product findById(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return null;
    }

    @Override
    public List filterByBranch(String branch) {
        return null;
    }

    @Override
    public List listProductByCategoryId(Long categoryId) {
        return null;
    }

    @Override
    public PagedResult<ProductDTO> searchByName(String name, int page, int size, String order) {
        if (StringUtils.isEmpty(name))
            name = Constants.BLANK;
        if (StringUtils.isEmpty(order))
            order = Constants.ASC_SORT;
        Sort sortable = Sort.by(Sort.Direction.fromString(order), "name");
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<Product> pageResult = productRepository.findByNameContaining(name, pageable);
        return new PagedResult<>(
                productConverter.convertEntitiesToDTOs(pageResult.getContent()), pageResult.getTotalPages(),
                pageResult.getTotalElements(), page, size);
    }

    @Override
    public PagedResult<ProductDTO> searchByColor(String color, int page, int size, String order) {
        if (StringUtils.isEmpty(color))
            color = Constants.BLANK;
        if (StringUtils.isEmpty(order))
            order = Constants.ASC_SORT;
        Sort sortable = Sort.by(Sort.Direction.fromString(order), "name");
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<Product> pageResult = productRepository.findByColorContaining(color, pageable);
        return new PagedResult<>(
                productConverter.convertEntitiesToDTOs(pageResult.getContent()), pageResult.getTotalPages(),
                pageResult.getTotalElements(), page, size);
    }

    @Override
    public PagedResult<ProductDTO> searchByBranch(Long branchId, int page, int size, String order) {
        Optional<Branch> currBranch = branchRepository.findById(branchId);

        if (StringUtils.isEmpty(order))
            order = Constants.ASC_SORT;
        Sort sortable = Sort.by(Sort.Direction.fromString(order), "name");
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<Product> pageResult = productRepository.findByBranchContaining(currBranch.get(), pageable);
        return new PagedResult<>(
                productConverter.convertEntitiesToDTOs(pageResult.getContent()), pageResult.getTotalPages(),
                pageResult.getTotalElements(), page, size);
    }

    @Override
    public PagedResult<ProductDTO> filterByPrice(int fromPrice, int toPrice, int page, int size, String order) {
        if (StringUtils.isEmpty(order))
            order = Constants.ASC_SORT;
        Sort sortable = Sort.by(Sort.Direction.fromString(order), "name");
        Pageable pageable = PageRequest.of(page, size, sortable);
        Page<Product> pageResult = productRepository.findByPriceGreaterThanAndPriceIsLessThan(fromPrice, toPrice, pageable);
        return new PagedResult<>(
                productConverter.convertEntitiesToDTOs(pageResult.getContent()), pageResult.getTotalPages(),
                pageResult.getTotalElements(), page, size);
    }


}
