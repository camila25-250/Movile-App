package com.app.backend.Service;

import com.app.backend.model.Subcategory;
import com.app.backend.repository.CategoryRepository;
import com.app.backend.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
//import com.app.backend.model.Category;

@Service
public class SubcategoryService {

    // @Autowired
    // private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public List<Subcategory> findAll() {
        return subcategoryRepository.findAll();
    }

    public List<Subcategory> findByCategoryId(Long id) {
        return subcategoryRepository.findByCategoryId(id);
    }

    public Subcategory findById(Long id) {
        return subcategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Subcategoria no encontrada"));
    }

    public Subcategory create(Subcategory subcategory) {
        // if (subcategory.getCategoryId() == null) {
        //     throw new RuntimeException("categoryId es requerido en el body");
        // }
        // Category category = categoryRepository.findById(subcategory.getCategoryId())
        //     .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        // subcategory.setCategory(category);
        return subcategoryRepository.save(subcategory);
    }

    public Subcategory update(Long id, Subcategory subcategoryDetails) {
        Subcategory subcategory = findById(id);
        subcategory.setName(subcategoryDetails.getName());
        subcategory.setDescripcion(subcategoryDetails.getDescripcion());
        subcategory.setActive(subcategoryDetails.getActive());
        subcategory.setCategory(subcategoryDetails.getCategory());
        // Si se envía categoryId en el body, actualiza la categoría
        // if (subcategoryDetails.getCategoryId() != null) {
        //     Category category = categoryRepository.findById(subcategoryDetails.getCategoryId())
        //         .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        //     subcategory.setCategory(category);
        // } else if (subcategoryDetails.getCategory() != null) {
        //     subcategory.setCategory(subcategoryDetails.getCategory());
        // }
        // subcategory.setDescripcion(subcategoryDetails.getDescripcion());
        // return subcategoryRepository.save(subcategory);
        return subcategoryRepository.save(subcategory);
    }

    public void delete(Long id) {
        Subcategory subcategory = findById(id);
        subcategoryRepository.delete(subcategory);
    }
}