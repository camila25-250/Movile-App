package com.app.backend.model;

import jakarta.persistence.*;
import com.app.backend.model.Category;
import com.app.backend.model.Subcategory;
import lombok.*;

@Data
@Entity
@Table(name = "products")
public class Product{
        @Transient
        private Long subcategoryId;

        public Long getSubcategoryId() {
            return subcategoryId;
        }

        public void setSubcategoryId(Long subcategoryId) {
            this.subcategoryId = subcategoryId;
        }
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
        return name;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
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
    
    public void setCategory(Category category){
        this.category = category;
    }

    public Category getCategory(){
        return category;
    }
    
    public void setSubcategory(Subcategory subcategory){
        this.subcategory = subcategory;
    }
    
    public Subcategory getSubcategory(){
        return subcategory;
    }
}