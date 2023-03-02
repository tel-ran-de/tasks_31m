package de.telran.surf.controller;

import de.telran.surf.entity.Category;
import de.telran.surf.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

    private final CategoryRepository repository;

    @Autowired
    public CategoryRestController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/categories")
    @PreAuthorize("authenticated")
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<>(repository.findByOrderByName(), HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = {RequestMethod.POST, RequestMethod.PUT})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {
        return new ResponseEntity<>(repository.save(category), HttpStatus.CREATED);
    }

    @DeleteMapping("/category/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteCategory(@PathVariable String id) {
        Optional<Category> categoryOpt = repository.findById(id);
        if (categoryOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.delete(categoryOpt.get());
        return ResponseEntity.noContent().build();
    }

}
