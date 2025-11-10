package com.app.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String descripcion;

    @Column(nullable = false)
    private Double price;

    private Integer stock;

    @Column(nullable = false)
    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "subcategory_id", nullable = false)
    private Subcategory subcategory;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        this.name = name;
    }

    public String setDescription(String descripcion){
        this.decription = description;
    }

    public getDescription(){
        return description;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Double getPrice(){
        return price;
    }
    
    public void setStock(Integer stock){
        this.stock = stock;
    }

    public Integer getStock(){
        return stock;
    }

    public void setActive(Boolean active){
        this.active = active;
    }

    public Boolean getActive(){
        return active;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public Category getSubcategory(){
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory){
        this.subcategory = subcategory;
    }
}