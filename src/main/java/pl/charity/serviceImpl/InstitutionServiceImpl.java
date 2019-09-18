package pl.charity.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.charity.entity.Institution;
import pl.charity.repository.InstitutionRepository;
import pl.charity.service.InstitutionService;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {
    private InstitutionRepository institutionRepo;

    public InstitutionServiceImpl(InstitutionRepository institutionRepo) {
        this.institutionRepo = institutionRepo;
    }

    @Override
    public List<Institution> findAll() {
        return institutionRepo.findAll();
    }

    @Override
    public Institution findById(Long id) {
        return institutionRepo.findFirstById(id);
    }
}
