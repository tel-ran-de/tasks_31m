package de.telran.surf.controller;

import de.telran.surf.entity.Category;
import de.telran.surf.entity.Product;
import de.telran.surf.service.CategoryService;
import de.telran.surf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    private final ProductService productService;

    @Autowired
    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @PostMapping("/addCategory")
    public String addCategory(@Valid Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "category";
        }
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories")
    public String categoryTable(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "category";
    }

    @GetMapping("/editCategory/{id}")           //editCategory/4f773be3-b70a-43c2-8f3a-96856623e229
    public String editCategory(@PathVariable String id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable String id, Model model) {
//        // Проверить, есть ли в данной категории товары
//        // Если товары есть, то их вначале удалить их
//        Category category = categoryService.getCategoryById(id);
//        List<Product> products = productService.getProductsInCategory(category);
//        if (!products.isEmpty()) {
//            products.forEach(product -> productService.delProductById(product.getId()));
//        }
        categoryService.delCategoryById(id);
        model.addAttribute("category", categoryService.getAllCategories());
        return "redirect:/categories";
    }

}
