package pl.charity.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pl.charity.entity.Category;
import pl.charity.entity.Donation;
import pl.charity.entity.Institution;
import pl.charity.repository.DonationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DonationServiceImpl implements DonationService{

    private final DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Donation findFirstById(Long id) {
        return donationRepository.findFirstById(id);
    }

    @Override
    public List<Donation> findByCategories(List<Category> categories) {
        return donationRepository.findAllByCategories(categories);
    }

    @Override
    public List<Donation> findByInstitution(Institution institution) {
        return donationRepository.findAllByInstitution(institution);
    }

    @Override
    public List<Donation> findByStreet(String street) {
        return donationRepository.findAllByStreet(street);
    }

    @Override
    public List<Donation> findByZipCode(String zipcode) {
        return donationRepository.findAllByZipCode(zipcode);
    }

    @Override
    public List<Donation> findByPickUpDate(LocalDateTime pickUpDate) {
        return donationRepository.findAllByPickUpDate(pickUpDate);
    }

    @Override
    public Donation saveDonation(Donation donation) {
        Donation donation1 = donationRepository.save(donation);
        return donation1;
    }

    @Override
    public void deleteById(Long id) {
        donationRepository.delete(donationRepository.findOne(id));
    }

    @Override
    public Integer sumDonations() {

        return donationRepository.sumDonations();
    }




}
