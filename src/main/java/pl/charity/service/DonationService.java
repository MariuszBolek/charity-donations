package pl.charity.service;


import pl.charity.entity.CurrentUser;
import pl.charity.entity.Donation;



public interface DonationService {
    Long numberOfDonations();
    Donation save(Donation donation, CurrentUser currentUser);
}







