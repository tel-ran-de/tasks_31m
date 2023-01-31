package de.telran.surf.controller;

import de.telran.surf.entity.Category;
import de.telran.surf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public String addCategory(Category category, Model model) {
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
        categoryService.delCategoryById(id);
        model.addAttribute("category", categoryService.getAllCategories());
        return "redirect:/categories";
    }

}
