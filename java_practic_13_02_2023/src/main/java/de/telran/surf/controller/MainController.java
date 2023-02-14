package de.telran.surf.controller;

import de.telran.surf.entity.Category;
import de.telran.surf.entity.Product;
import de.telran.surf.entity.User;
import de.telran.surf.service.CategoryService;
import de.telran.surf.service.ProductService;
import de.telran.surf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final CategoryService categoryService;

    private final ProductService productService;

    private final UserService userService;

    @Autowired
    public MainController(
            CategoryService categoryService,
            ProductService productService,
            UserService userService
    ) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Map<Category, List<Product>> productsByCategories = new HashMap<>();
        for (Category category : categoryService.getAllCategories()) {
            productsByCategories.put(category, productService.getProductsInCategory(category));

        }
        model.addAttribute("map", productsByCategories);
        return "index";
    }

    @GetMapping("/login")
    public String admin(Model model) {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user) {
        userService.saveUser(user);
        // Как войти в админку уже авторизованным пользователем?
        return "login";
    }

}
