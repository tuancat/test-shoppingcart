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
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductService productService = new ProductServiceImpl();
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductConverter productConverter;
    @Mock
    private BranchRepository branchRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void searchByName() {

        List<Product> listProduct = new ArrayList<Product>();
        Product product = new Product();
        product.setName("product");
        listProduct.add(product);


        List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Iphone");
        listProductDTO.add(productDTO);


        when(productRepository.findByNameContaining("Iphone")).thenReturn(listProduct);
        when(productConverter.convertEntitiesToDTOs(listProduct)).thenReturn(listProductDTO);

        List<ProductDTO> found = productService.searchByName("Iphone");
////
        assertThat(found.size())
                .isEqualTo(1);
    }

    @Test
    void searchByColor() {
        List<Product> listProduct = new ArrayList<Product>();
        Product product = new Product();
        product.setName("product");
        listProduct.add(product);


        List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Iphone");
        listProductDTO.add(productDTO);


        when(productRepository.findByColorContaining("red")).thenReturn(listProduct);
        when(productConverter.convertEntitiesToDTOs(listProduct)).thenReturn(listProductDTO);

        List<ProductDTO> found = productService.searchByColor("red");
////
        assertThat(found.size())
                .isEqualTo(1);
    }

    @Test
    void searchByBranch() {
        List<Product> listProduct = new ArrayList<Product>();
        Product product = new Product();
        product.setName("product");
        listProduct.add(product);


        List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Iphone");
        listProductDTO.add(productDTO);

        Branch branch = new Branch();
        branch.setId(Long.valueOf(1));
        branch.setName("Apple");



        when(productRepository.findByBranch(branch)).thenReturn(listProduct);
        when(productConverter.convertEntitiesToDTOs(listProduct)).thenReturn(listProductDTO);
        when(branchRepository.getOne(Long.valueOf(1))).thenReturn(branch);

        List<ProductDTO> found = productService.searchByBranch(Long.valueOf(1));
////
        assertThat(found.size())
                .isEqualTo(1);
    }

    @Test
    void filterByPrice() {
        List<Product> listProduct = new ArrayList<Product>();
        Product product = new Product();
        product.setName("product");
        listProduct.add(product);


        List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Iphone");
        listProductDTO.add(productDTO);

        Branch branch = new Branch();
        branch.setId(Long.valueOf(1));
        branch.setName("Apple");



        when(productRepository.findByPriceGreaterThanAndPriceIsLessThan(0, 500)).thenReturn(listProduct);
        when(productConverter.convertEntitiesToDTOs(listProduct)).thenReturn(listProductDTO);

        List<ProductDTO> found = productService.filterByPrice(0, 500);
////
        assertThat(found.size())
                .isEqualTo(1);
    }
}