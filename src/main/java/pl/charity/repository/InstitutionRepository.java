package pl.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import pl.charity.entity.Institution;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {


    Institution findFirstByName(String name);

    List<Institution> findAllByName(@RequestParam("name") String name);

    List<Institution> findAllByDescription(@RequestParam("description") String description);

    @Query(value = "select count(*) from institutions", nativeQuery = true)
    Integer countInstitutions();

}
