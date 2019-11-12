package pl.charity.service;

import pl.charity.entity.Institution;

import java.util.List;


public interface InstitutionService {

    List<Institution> findAll();

    Institution findById(Long id);

    void delete(Long id);

    void edit (Long id, Institution institution);
}
