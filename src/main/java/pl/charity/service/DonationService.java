package pl.charity.service;


import pl.charity.entity.CurrentUser;
import pl.charity.entity.Donation;

import java.util.List;


public interface DonationService {
    Long numberOfDonations();
    Donation save(Donation donation, CurrentUser currentUser);
    List<Donation> findAllUserDonations(Long id);
}







