package de.telran.surf.repository;

import de.telran.surf.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, String> {

    // select * from surf.category c order by c.name
    List<Category> findByOrderByName();

}
