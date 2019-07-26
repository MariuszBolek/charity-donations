package pl.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import pl.charity.entity.Institution;
import pl.charity.service.InstitutionService;

import org.springframework.core.convert.converter.Converter;


public class InstitutionConverter implements Converter<String, Institution> {

    @Autowired
    private InstitutionService institutionService;


    @Override
    public Institution convert(String s) {
        return institutionService.findById(Long.parseLong(s));
    }
}
