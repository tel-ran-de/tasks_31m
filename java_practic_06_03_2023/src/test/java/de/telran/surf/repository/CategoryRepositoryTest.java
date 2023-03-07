package de.telran.surf.repository;

import de.telran.surf.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void testCreateReadDelete() {
        Category category = new Category();
        category.setName("Test category");

        categoryRepository.save(category);

        Iterable<Category> categories = categoryRepository.findAll();
        Assertions.assertEquals(categories.iterator().next().getName(), "Test category");

        categoryRepository.deleteAll();
        Assertions.assertFalse(categoryRepository.findAll().iterator().hasNext());

    }

}
