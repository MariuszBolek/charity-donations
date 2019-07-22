package pl.charity.service;

import org.springframework.stereotype.Service;
import pl.charity.entity.Category;
import pl.charity.entity.Donation;
import pl.charity.entity.Institution;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface DonationService {

    List<Donation> findByCategories(List<Category> categories);

    List<Donation> findByInstitution(Institution institution);

    List<Donation> findByStreet(String street);

    List<Donation> findByZipCode(String zipcode);

    List<Donation> findByPickUpDate(LocalDateTime pickUpDate);

    Donation saveDonation(Donation donation);

    void deleteById(Long id);

    Double sumDonations();


}
