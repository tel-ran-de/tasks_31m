package de.telran.surf.controller;

import de.telran.surf.entity.Product;
import de.telran.surf.service.CategoryService;
import de.telran.surf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ProductController {

    @Value("${images.dir}")
    private String imagesDir;

    private final CategoryService categoryService;

    private final ProductService productService;

    @Autowired
    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/image/{filename}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String filename) throws IOException {
        byte[] image = Files.readAllBytes(new File(imagesDir + "/" + filename).toPath());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }

    @PostMapping("/addProduct")
    public String addProduct(@Valid Product product,
                             BindingResult bindingResult,
                             @RequestParam("image") MultipartFile file,
                             Model model
    ) throws IOException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "product";
        }
        Product productFromDb = productService.getProductById(product.getId());
        if (file.isEmpty() && productFromDb == null) {
            bindingResult.addError(new FieldError("product", "picture", "Файл не загружен"));
            model.addAttribute("categories", categoryService.getAllCategories());
            return "product";
        }
        if (productFromDb != null) {
            product.setPicture(productFromDb.getPicture());
        }
        productService.saveProduct(file, product);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String productTable(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product";
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable String id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id, Model model) {
        productService.delProductById(id);
        model.addAttribute("products", productService.getAllProducts());
        return "redirect:/products";
    }

}
