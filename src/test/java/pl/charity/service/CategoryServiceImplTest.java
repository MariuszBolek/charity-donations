package pl.charity.service;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pl.charity.entity.Category;
import pl.charity.repository.CategoryRepository;



import static org.junit.Assert.*;

@RunWith(SpringRunner.class)


public class CategoryServiceImplTest {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void findById() {
        //given
        Category category = new Category();
        category.setName("test");
        categoryRepository.save(category);
        //when
        Category categoryFromDB = categoryService.findById(1L);
        //then
        assertEquals(category, categoryFromDB);


    }

    @Test
    public void findByName() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void saveCategory() {
    }

    @Test
    public void deleteById() {
    }
}