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

//    private int levenshteinDistance(String s1, String s2) {
//        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                matrix[i][j] = levDiv(i, j, s1, s2, matrix);
//            }
//        }
//        return matrix[s1.length()][s2.length()];
//    }

//    private int levDiv(int i, int j, String s1, String s2, int[][] matrix) {
//        if (i == 0 && j == 0)
//            return 0;
//        if (i > 0 && j == 0)
//            return i;
//        if (j > 0 && i == 0)
//            return j;
//        int m = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
//
//        int min = matrix[i][j - 1] + 1;
//        if (matrix[i - 1][j] + 1 < min)
//            min = matrix[i - 1][j] + 1;
//        if (matrix[i - 1][j - 1] + m < min)
//            min = matrix[i - 1][j - 1] + m;
//        return min;
//    }


}
