package com.sam.product.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categories implements Serializable {

    private static final long serialVersionUID = -4275434439199301275L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Product> listProduct;

    public Categories() {
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

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }
}
