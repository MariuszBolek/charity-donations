package pl.charity.entity;

import org.springframework.format.annotation.DateTimeFormat;
import pl.charity.validation.DonationValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donations")
public class Donation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    @Min(value = 1, groups = {DonationValidationGroup.class, Default.class}, message = "Minimalna ilość worków to 1")
    @Max(value = 200, groups = {DonationValidationGroup.class, Default.class}, message = "Maksymalna ilość worków to 200. Jeżeli chcesz ofiarować więcej, skontaktuj się z nami " +
            "przez formularz kontaktowy u dołu strony")
    private Integer quantity;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(joinColumns = @JoinColumn(name = "donations_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @NotEmpty(groups = {DonationValidationGroup.class, Default.class}, message = "Musisz wybrać conajmneij jedną kategorię")
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    private Institution institution;

    @ManyToOne
    private User user;

    @NotBlank(groups = {DonationValidationGroup.class}, message = "Pole wymagane")
    private String street;

    @NotBlank(groups = {DonationValidationGroup.class}, message = "Pole wymagane")
    private String city;

    @Column(name = "zip_code")
    @NotBlank(groups = {DonationValidationGroup.class}, message = "Pole wymagane")
    private String zipCode;

    @NotBlank(groups = {DonationValidationGroup.class}, message = "Pole wymagane")
    private String phone;

    @Column(name = "pick_up_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future(message = "Umów proszę kuriera na przyszłą datę")
    private LocalDate pickUpDate;

    @Column(name = "pick_up_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime pickUpTime;

    @Column(name = "comments")
    @Size(max = 1000, groups = {DonationValidationGroup.class, Default.class})
    private String comments;

    @Override
    public String toString() {
        return "Donation{" +
                "quantity=" + quantity +
                ", categories=" + categories +
                ", institution=" + institution +
                ", user=" + user +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", pickUpTime=" + pickUpTime +
                ", comments='" + comments + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
