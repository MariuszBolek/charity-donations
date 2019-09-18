package pl.charity.service;

import pl.charity.entity.Category;

import java.util.List;



public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
}
