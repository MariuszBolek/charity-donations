package pl.charity.entity;

import org.hibernate.validator.constraints.NotBlank;
import pl.charity.validation.InstitutionValidationGroup;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Size;

@Entity
@Table(name= "institution")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(groups = InstitutionValidationGroup.class, message = "pole nie może być puste")
    private String name;

    @Size(max = 300)
    @NotBlank(groups = InstitutionValidationGroup.class, message = "pole nie może być puste")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
