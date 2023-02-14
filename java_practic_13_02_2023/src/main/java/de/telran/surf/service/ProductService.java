package de.telran.surf.service;

import de.telran.surf.entity.Category;
import de.telran.surf.entity.Order;
import de.telran.surf.entity.Product;
import de.telran.surf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    @Value("${images.dir}")
    private String imagesDir;

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(MultipartFile file, Product product) throws IOException {
        String fileName = file.getOriginalFilename();
        product.setPicture(fileName);
        Path path = Paths.get(imagesDir + "\\" + fileName);
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Product getProductById(String id) {
        Product product = productRepository.findById(id).get();
        List<Order> orders = product.getOrders();   // получение Заказов, где фигурирует данный продукт
        //product.setOrders();  // задание списка заказов, где фигурирует данный продукт (параметр - список заказов)
        return product;
    }

    public void delProductById(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsInCategory(Category category) {
        return productRepository.findByCategory(category);
    }


}
