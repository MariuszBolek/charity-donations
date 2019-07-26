package pl.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.charity.entity.Category;
import pl.charity.service.CategoryService;

public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    CategoryService categoryService;

    @Override
    public Category convert(String s) {
        return categoryService.findById(Long.parseLong(s));
    }
}
