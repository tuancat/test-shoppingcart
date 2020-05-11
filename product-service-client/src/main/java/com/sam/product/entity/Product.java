package com.sam.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {


    private static final long serialVersionUID = -1085813353116364106L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "branch", nullable = false, length = 255)
    private String branch;
    @Column(name = "color", nullable = false, length = 255)
    private String color;
    @ManyToOne
    @JoinColumn(name = "categories-id")
    private Categories categories;


    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
