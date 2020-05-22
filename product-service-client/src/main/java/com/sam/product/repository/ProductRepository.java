package com.sam.product.repository;

import com.sam.product.entity.Branch;
import com.sam.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);
    List<Product> findByColorContaining(String color);
    List<Product> findByBranch(Branch branch);
    List<Product> findByPriceGreaterThanAndPriceIsLessThan(int from, int to);
}
