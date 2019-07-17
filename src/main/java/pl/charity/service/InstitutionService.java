package pl.charity.service;

import pl.charity.entity.Institution;

import java.util.List;


public interface InstitutionService {

    Institution findById(Long id);

    Institution findByName(String name);

    List<Institution> findAll();

    Institution saveinstitution(Institution institution);

    void deleteById(Long id);
}
