package whoscared.esoftdemo.esoft.demo.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import whoscared.esoftdemo.esoft.demo.models.people.Person;
import whoscared.esoftdemo.esoft.demo.services.ClientService;
import whoscared.esoftdemo.esoft.demo.services.RealtorService;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchClientsAndRealtors extends SearchWithLevenshteinDistance {
    private final ClientService clientService;
    private final RealtorService realtorService;

    @Autowired
    public SearchClientsAndRealtors(ClientService clientService, RealtorService realtorService) {
        this.clientService = clientService;
        this.realtorService = realtorService;
    }

    public List<Person> searchPersons(Person p) {
        List<Person> allPersons = new ArrayList<>();
        allPersons.addAll(clientService.allClients());
        allPersons.addAll(realtorService.allRealtors());

        return searchByPerson(allPersons, p);
    }

    private List<Person> searchByPerson(List<Person> searchBy, Person person) {
        String personBySearch = person.getFirstname() + " " + person.getLastname() + " " + person.getPatronymic();
        List<Person> result = new ArrayList<>();

        for (Person temp : searchBy) {
            String temp_person = "";
            temp_person += person.getFirstname().isEmpty() ? " " : temp.getFirstname() + " ";
            temp_person += person.getLastname().isEmpty() ? " " : temp.getLastname() + " ";
            temp_person += person.getPatronymic().isEmpty() ? " " : temp.getPatronymic();
            if (levenshteinDistance(temp_person.replace(" ", ""), personBySearch.replace(" ", "")) <= 3) {
                result.add(temp);
            }
        }
        return result;
    }

}
