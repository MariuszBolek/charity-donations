package pl.charity.service;

import pl.charity.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);

    Category findByName(String name);

    List<Category> findAll();

    Category saveCategory(Category category);

    void deleteById(Long id);


}
