package pl.charity.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.charity.entity.Institution;
import pl.charity.service.InstitutionService;

@Component
public class FundationsFixture {

    InstitutionService institutionService;

    @Autowired
    public FundationsFixture(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    public void initData() {
        Institution institution1 = new Institution();
        institution1.setName("Fundacja \"Dbam o Zdrowie\"");
        institution1.setDescription(" Pomoc dzieciom z ubogich rodzin.");
        institutionService.saveinstitution(institution1);

        Institution institution2 = new Institution();
        institution2.setName("Fundacja \"A kogo\"");
        institution2.setDescription("Pomoc wybudzaniu dzieci ze śpiączki.");
        institutionService.saveinstitution(institution2);

        Institution institution3 = new Institution();
        institution3.setName("Fundacja “Dla dzieci\"");
        institution3.setDescription("Pomoc osobom znajdującym się w trudnej sytuacji życiowej.");
        institutionService.saveinstitution(institution3);

        Institution institution4 = new Institution();
        institution4.setName("Fundacja “Bez domu”");
        institution4.setDescription("Pomoc dla osób nie posiadających miejsca zamieszkania");
        institutionService.saveinstitution(institution4);
    }
}
