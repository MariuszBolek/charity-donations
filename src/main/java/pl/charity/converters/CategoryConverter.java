package pl.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.charity.entity.Category;
import pl.charity.service.CategoryService;

@Component
public class CategoryConverter implements Converter<String, Category> {

    CategoryService categoryService;

    @Autowired
    public CategoryConverter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category convert(String s) {
        return categoryService.findById(Long.parseLong(s));
    }
}
