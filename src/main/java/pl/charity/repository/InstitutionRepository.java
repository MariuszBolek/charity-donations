package pl.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.charity.entity.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {


    Institution findFirstByName(String name);

}
