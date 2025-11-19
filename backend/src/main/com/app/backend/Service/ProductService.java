package com.app.backend.Service;

import com.app.backend.model.Product;
import com.app.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByCategoryId(Long categoryId) {
        return productRepository.findByCategory_Id(categoryId);
    }

    public List<Product> findBySubcategoryId(Long subcategoryId) {
        return productRepository.findBySubcategory_Id(subcategoryId);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Product create(Product product) {
        // if (product.getSubcategoryId() != null) {
        //     com.app.backend.model.Subcategory subcategory = subcategoryRepository.findById(product.getSubcategoryId())
        //         .orElseThrow(() -> new RuntimeException("Subcategoría no encontrada"));
        //     product.setSubcategory(subcategory);
        //     product.setCategory(subcategory.getCategory());
        // }
        return productRepository.save(product);
    }

    public Product update(Long id, Product productDetails) {
        Product product = findById(id);
        product.setName(productDetails.getName());
        product.setDescripcion(productDetails.getDescripcion());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        product.setActive(productDetails.getActive());
        product.setCategory(productDetails.getCategory());
        product.setSubcategory(productDetails.getSubcategory());
        // Si se envía subcategoryId en el body, actualiza la subcategoría y la categoría
        // if (productDetails.getSubcategoryId() != null) {
        //     com.app.backend.model.Subcategory subcategory = subcategoryRepository.findById(productDetails.getSubcategoryId())
        //         .orElseThrow(() -> new RuntimeException("Subcategoría no encontrada"));
        //     product.setSubcategory(subcategory);
        //     product.setCategory(subcategory.getCategory());
        // } else if (productDetails.getSubcategory() != null) {
        //     product.setSubcategory(productDetails.getSubcategory());
        //     product.setCategory(productDetails.getSubcategory().getCategory());
        // } else if (productDetails.getCategory() != null) {
        //     product.setCategory(productDetails.getCategory());
        // }
        return productRepository.save(product);
    }

    public void delete(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
    }
}