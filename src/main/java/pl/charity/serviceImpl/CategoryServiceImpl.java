package pl.charity.serviceImpl;



import org.springframework.stereotype.Service;
import pl.charity.entity.Category;
import pl.charity.repository.CategoryRepository;
import pl.charity.service.CategoryService;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepo;

    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findFirstById(id);
    }
}
