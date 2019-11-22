package pl.charity.entity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.charity.validation.UserValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email(groups = UserValidationGroup.class)
    @NotBlank(groups = UserValidationGroup.class)
    @Column(nullable = false, unique = true)
    @NotNull
    private String email;

    @NotBlank(groups = UserValidationGroup.class, message = "Hasło nie może być puste")
    @Size(min = 6, groups = UserValidationGroup.class, message = "hasło musi zawierać co najmniej 6 znaków")
    private String password;

    @NotBlank(groups = UserValidationGroup.class, message = "Musisz podać imię")
    @Size(min = 3, max = 20, groups = UserValidationGroup.class, message = "Imię musi zawierać od 3 do 20 znaków")
    private String firstName;

    @NotBlank(groups = UserValidationGroup.class, message = "Musisz podać nazwisko")
    @Size(min = 3, max = 20, groups = UserValidationGroup.class, message = "Nazwisko musi zawierać od 3 do 20 znaków")
    private String lastName;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Donation> donations = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}