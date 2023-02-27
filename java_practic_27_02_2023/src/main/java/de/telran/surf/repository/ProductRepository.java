package de.telran.surf.repository;

import de.telran.surf.entity.Category;
import de.telran.surf.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    // select * from surf.product p where p.name = :name
    Product findByName(String name);

    // select * from surf.product p where p.category = :category
    List<Product> findByCategory(Category category);

}
