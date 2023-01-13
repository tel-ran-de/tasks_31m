package de.telran.surf.controller;

import de.telran.surf.entity.Category;
import de.telran.surf.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryRepository repository;

    @Autowired
    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {
        return new ResponseEntity<>(repository.save(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String id) {
        Optional<Category> categoryOpt = repository.findById(id);
        if (categoryOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.delete(categoryOpt.get());
        return ResponseEntity.noContent().build();
    }

}
