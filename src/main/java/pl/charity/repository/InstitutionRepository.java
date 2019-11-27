package pl.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import pl.charity.entity.Donation;
import pl.charity.entity.Institution;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {


    Institution findFirstById(Long id);

    @Query(value = "select count(*) from institution", nativeQuery = true)
    Integer countInstitutions();

    List<Institution> findAllById(Long id);

}
