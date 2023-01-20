package de.telran.surf.controller;

import de.telran.surf.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final CategoryRepository repository;

    @Autowired
    public MainController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/surf")
    public String index(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "index";
    }

}
