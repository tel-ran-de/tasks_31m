package de.telran.surf.controller;

import de.telran.surf.entity.Product;
import de.telran.surf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) {
        Optional<Product> productOpt = repository.findById(id);
        if (productOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(productOpt.get(), HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<?> getProductByName(@RequestParam String name) {
        Product product = repository.findByName(name);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/product", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(repository.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        Optional<Product> productOpt = repository.findById(id);
        if (productOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.delete(productOpt.get());
        return ResponseEntity.noContent().build();
    }

}
