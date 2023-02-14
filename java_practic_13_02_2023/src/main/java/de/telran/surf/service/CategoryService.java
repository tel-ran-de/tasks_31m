package de.telran.surf.service;

import de.telran.surf.entity.Category;
import de.telran.surf.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategoryById(String id) {
        return categoryRepository.findById(id).get();
    }

    public void delCategoryById(String id) {
        categoryRepository.deleteById(id);
    }

}
