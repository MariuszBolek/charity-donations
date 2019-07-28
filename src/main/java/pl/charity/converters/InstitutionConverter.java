package pl.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.charity.entity.Institution;
import pl.charity.service.InstitutionService;

import org.springframework.core.convert.converter.Converter;

@Component
public class InstitutionConverter implements Converter<String, Institution> {


    private InstitutionService institutionService;

    @Autowired
    public InstitutionConverter(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @Override
    public Institution convert(String s) {
        return institutionService.findById(Long.parseLong(s));
    }
}
