package pl.charity.entity;

import org.springframework.beans.factory.annotation.Autowired;
import pl.charity.repository.CategoryRepository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "donations")
public class Donation {


//    id
//    quantity (liczba worków)
//    categories (lista obiektów typu Category), pamiętaj o odpowiedniej adnotacji
//    institution (obiekt typu Institution), pamiętaj o odpowiedniej adnotacji.
//    street
//            city
//    zipCode
//            pickUpDate
//    pickUpTime
//            pickUpComment

    @Autowired
    CategoryRepository categoryRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Double quantity;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Category> categories;

    @ManyToOne
    private Institution institution;

    private String street;

    private String zipCode;

    private LocalDateTime pickUpDate;

    private LocalDateTime pickUpTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDateTime getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDateTime pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalDateTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalDateTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }
}
