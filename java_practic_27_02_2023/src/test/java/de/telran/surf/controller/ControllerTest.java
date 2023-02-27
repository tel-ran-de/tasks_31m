package de.telran.surf.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ControllerTest {

    @Autowired
    CategoryController categoryController;

    @Autowired
    CategoryRestController categoryRestController;

    @Autowired
    MainController mainController;

    @Autowired
    ProductController productController;

    @Autowired
    ProductRestController productRestController;

    @Test
    public void categoryControllerTest() {
        Assertions.assertNotEquals(categoryController, null);
    }

    @Test
    public void categoryRestControllerTest() {
        Assertions.assertNotEquals(categoryRestController, null);
    }

    @Test
    public void mainControllerTest() {
        Assertions.assertNotEquals(mainController, null);
    }

    @Test
    public void productControllerTest() {
        Assertions.assertNotEquals(productController, null);
    }

    @Test
    public void productRestControllerTest() {
        Assertions.assertNotEquals(productRestController, null);
    }

}
