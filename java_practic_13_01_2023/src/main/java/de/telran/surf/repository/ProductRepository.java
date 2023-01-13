package de.telran.surf.repository;

import de.telran.surf.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    // select * from surf s where s.name = 'qwerty'
    Product findByName(String name);

    // ToDo Исправить!!!
    // List<Product> findAllOrderByName();

}
