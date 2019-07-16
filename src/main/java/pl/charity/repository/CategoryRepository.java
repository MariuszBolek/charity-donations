package pl.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.charity.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Category findFirstByName(String name);



}
