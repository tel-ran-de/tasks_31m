package de.telran.surf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.surf.config.SpringSecurityTestConfig;
import de.telran.surf.entity.Category;
import de.telran.surf.repository.CategoryRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringSecurityTestConfig.class
)
@AutoConfigureMockMvc
public class CategoryRestControllerTest {

    @MockBean
    CategoryRepository categoryRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithUserDetails("admin")
//    @WithAnonymousUser
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

    @Test
    @WithUserDetails("admin")
//    @WithUserDetails("user")
//    @WithAnonymousUser
    public void createCategory() throws Exception {
        Category category = new Category();
        category.setName("Test category");

        Category category2 = new Category();
        category2.setId("1");
        category2.setName("Test category");

        Mockito.when(categoryRepository.save(any(Category.class))).thenReturn(category2);

        mockMvc.perform(post("/api/category")
                        .with(csrf())
                        .content(asJsonString(category))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Test category"));
    }

    private String asJsonString(Category category) {
        try {
            return new ObjectMapper().writeValueAsString(category);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @WithUserDetails("admin")
//    @WithUserDetails("user")
//    @WithAnonymousUser
    public void updateCategory() throws Exception {
        Category category = new Category();
        category.setId("1");
        category.setName("Test category");

        Category category2 = new Category();
        category2.setId("1");
        category2.setName("Test category2");

        Mockito.when(categoryRepository.save(any(Category.class))).thenReturn(category2);

        mockMvc.perform(put("/api/category")
                        .with(csrf())
                        .content(asJsonString(category))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Test category2"));
    }

    @Test
//    @WithUserDetails("admin")
//    @WithUserDetails("user")
    @WithAnonymousUser
    public void deleteCategory() throws Exception {
        Category category = new Category();
        category.setId("1");
        category.setName("Test category");
        Mockito.when(categoryRepository.findById(anyString())).thenReturn(Optional.of(category));

        categoryRepository.delete(category);

        Mockito.verify(categoryRepository, Mockito.times(1)).delete(category);

        // TODO переделать на mockMvc.perform(delete(...
    }


}
