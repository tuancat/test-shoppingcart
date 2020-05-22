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
    public List<ProductDTO> searchByName(String name) {
        if (StringUtils.isEmpty(name))
            name = Constants.BLANK;

        List<Product> list = productRepository.findByNameContaining(name);
        return productConverter.convertEntitiesToDTOs(list);
//        return new PagedResult<>(
//                productConverter.convertEntitiesToDTOs(list), page,
//                list.size(), page, size);
    }

    @Override
    public List<ProductDTO> searchByColor(String color) {
        if (StringUtils.isEmpty(color))
            color = Constants.BLANK;

//        Sort sortable = Sort.by(Sort.Direction.fromString(order), "name");
//        Pageable pageable = PageRequest.of(page, size, sortable);
        List<Product> pageResult = productRepository.findByColorContaining(color);
        return productConverter.convertEntitiesToDTOs(pageResult);
    }

    @Override
    public List<ProductDTO> searchByBranch(Long branchId) {
        Branch currBranch = branchRepository.getOne(branchId);


        List<Product> pageResult = productRepository.findByBranch(currBranch);
        return productConverter.convertEntitiesToDTOs(pageResult);
    }

    @Override
    public List<ProductDTO> filterByPrice(int fromPrice, int toPrice) {

        List<Product> pageResult = productRepository.findByPriceGreaterThanAndPriceIsLessThan(fromPrice, toPrice);
        return productConverter.convertEntitiesToDTOs(pageResult);
    }


}
