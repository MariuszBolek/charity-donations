package pl.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.charity.entity.Category;
import pl.charity.entity.Donation;
import pl.charity.entity.Institution;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findAllByCategories(List<Category> categories);

    List<Donation> findAllByInstitution(Institution institution);

    List<Donation> findAllByStreet(String street);

    List<Donation> findAllByZipCode(String zipcode);

    List<Donation> findAllByPickUpDate(LocalDateTime pickUpDate);

    @Query(value = "select sum(quantity) from donations", nativeQuery = true)
    Double sumDonations();


}
