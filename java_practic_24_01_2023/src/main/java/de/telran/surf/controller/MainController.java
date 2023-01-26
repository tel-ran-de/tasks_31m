package de.telran.surf.controller;

import de.telran.surf.entity.Category;
import de.telran.surf.entity.Product;
import de.telran.surf.repository.CategoryRepository;
import de.telran.surf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Value("${images.dir}")
    private String imagesDir;

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    @Autowired
    public MainController(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        Map<Category, List<Product>> productsByCategories = new HashMap<>();
        for (Category category : categoryRepository.findAll()) {
            productsByCategories.put(category, productRepository.findByCategory(category));

        }
        model.addAttribute("map", productsByCategories);
        return "index";
    }

    @GetMapping("/image/{filename}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String filename) throws IOException {
        byte[] image = Files.readAllBytes(new File(imagesDir + "\\" + filename).toPath());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }

    @PostMapping("/addCategory")
    public String addCategory(Category category, Model model) {
        categoryRepository.save(category);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "admin";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category";
    }

    @GetMapping("/editCategory/{id}")           //editCategory/4f773be3-b70a-43c2-8f3a-96856623e229
    public String editCategory(@PathVariable String id, Model model) {
        Category category = categoryRepository.findById(id).get();
        model.addAttribute("category", category);
        return "category";
    }

    @GetMapping("/deleteCategory/{id}")           //deleteCategory/4f773be3-b70a-43c2-8f3a-96856623e229
    public String deleteCategory(@PathVariable String id, Model model) {
        categoryRepository.deleteById(id);
        model.addAttribute("category", categoryRepository.findAll());
        return "redirect:/admin";
    }

}
