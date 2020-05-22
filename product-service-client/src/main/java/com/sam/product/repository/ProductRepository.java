package com.sam.product.repository;

import com.sam.product.entity.Branch;
import com.sam.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContaining(String name, Pageable pageable);
    Page<Product> findByColorContaining(String color, Pageable pageable);
    Page<Product> findByBranchContaining(Branch branch, Pageable pageable);
    Page<Product> findByPriceGreaterThanAndPriceIsLessThan(int from, int to, Pageable pageable);
}
