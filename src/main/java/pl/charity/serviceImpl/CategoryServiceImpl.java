package pl.charity.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.charity.entity.Category;
import pl.charity.repository.CategoryRepository;
import pl.charity.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findFirstByName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        Category category1 = categoryRepository.save(category);
        return category1;
    }


    @Override
    public void deleteById(Long id) {
        categoryRepository.delete(categoryRepository.findOne(id));

    }
}
