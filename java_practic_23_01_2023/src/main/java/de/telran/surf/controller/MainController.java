package de.telran.surf.controller;

import de.telran.surf.entity.Category;
import de.telran.surf.entity.Product;
import de.telran.surf.repository.CategoryRepository;
import de.telran.surf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/addCategory")
    public String addCategory(Category category, Model model) {
        categoryRepository.save(category);
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin";
    }

}
