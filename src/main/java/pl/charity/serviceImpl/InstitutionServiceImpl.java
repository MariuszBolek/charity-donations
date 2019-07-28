package pl.charity.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.charity.entity.Institution;
import pl.charity.repository.InstitutionRepository;
import pl.charity.service.InstitutionService;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    @Autowired
    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public Institution findById(Long id) {
        return institutionRepository.findOne(id);
    }

    @Override
    public Institution findByName(String name) {
        return institutionRepository.findFirstByName(name);
    }

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution saveinstitution(Institution institution) {
        Institution institution1 = institutionRepository.save(institution);
        return institution1;
    }

    @Override
    public void deleteById(Long id) {
        institutionRepository.delete(institutionRepository.findOne(id));

    }

    @Override
    public Integer countInstitutions() {

        return institutionRepository.countInstitutions();
    }
}
