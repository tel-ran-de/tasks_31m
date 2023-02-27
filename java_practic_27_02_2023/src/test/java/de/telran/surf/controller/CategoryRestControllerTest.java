package de.telran.surf.controller;

import de.telran.surf.entity.Category;
import de.telran.surf.repository.CategoryRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CategoryRestController.class)
public class CategoryRestControllerTest {

    @MockBean
    CategoryRepository categoryRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetAllCategories() throws Exception {
        Category category = new Category();
        category.setName("Test category");
        Mockito.when(categoryRepository.findByOrderByName()).thenReturn(List.of(category));
        mockMvc.perform(get("/api/categories")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Test category")));
    }

}
