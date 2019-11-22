package pl.charity.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pl.charity.entity.*;
import pl.charity.repository.DonationRepository;
import pl.charity.service.DonationService;
import pl.charity.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {
    private DonationRepository donationRepo;
    private UserService userService;

    @Autowired
    public DonationServiceImpl(DonationRepository donationRepo, UserService userService) {
        this.donationRepo = donationRepo;
        this.userService = userService;
    }

    @Override
    public Long numberOfDonations() {
        return donationRepo.sumDonations();
    }

    @Override
    public Donation save(Donation donation, CurrentUser currentUser) {
        User user = userService.findById(currentUser.getUser().getId());
        donation.setUser(user);
        return donationRepo.save(donation);
    }
}
