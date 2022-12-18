package whoscared.esoftdemo.esoft.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import whoscared.esoftdemo.esoft.demo.models.Client;
import whoscared.esoftdemo.esoft.demo.models.Person;
import whoscared.esoftdemo.esoft.demo.models.Realtor;
import whoscared.esoftdemo.esoft.demo.services.ClientService;
import whoscared.esoftdemo.esoft.demo.services.RealtorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SearchClientsAndRealtors {
    private final ClientService clientService;
    private final RealtorService realtorService;

    @Autowired
    public SearchClientsAndRealtors(ClientService clientService, RealtorService realtorService) {
        this.clientService = clientService;
        this.realtorService = realtorService;
    }

    public List<String> searchPersons(Person p) {
        List<Person> allPersons = new ArrayList<>();
        allPersons.addAll(clientService.allClients());
        allPersons.addAll(realtorService.allRealtors());
        //List<Client> allClients = clientService.allClients();
        //List<Realtor> allRealtors = realtorService.allRealtors();

        String personBySearch = p.getFirstname() + " " + p.getLastname() + " " + p.getPatronymic();

        List<String> searchBy = new ArrayList<>(allPersons.stream()
                .map(x -> {
                    String s = "";
                    s += p.getFirstname().isEmpty() ? " " : x.getFirstname() + " ";
                    s += p.getLastname().isEmpty() ? " " : x.getLastname() + " ";
                    s += p.getPatronymic().isEmpty() ? " " : x.getPatronymic();
                    return s;
                })
                .map(String::trim)
                .toList());
//        searchBy.addAll(allRealtors.stream()
//                .map(x -> x.getFirstname() + " " + x.getLastname() + " " + x.getPatronymic())
//                .map(String::trim)
//                .toList());
        searchBy.removeIf(String::isEmpty);

        List<String> result = searchByString(searchBy, personBySearch.trim());

        return searchByString(searchBy, personBySearch.trim());
    }

    private List<String> searchByString(List<String> searchBy, String s) {
        List<String> result = new ArrayList<>();
        for (String temp : searchBy){
            int tempLen = levenshteinDistance(temp, s);
            if (tempLen <= 3){
                result.add(temp);
            }
        }
        return result;
    }

    private int levenshteinDistance(String s1, String s2) {
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = levDiv(i, j, s1, s2, matrix);
            }
        }
        return matrix[s1.length()][s2.length()];
    }

    private int levDiv(int i, int j, String s1, String s2, int[][] matrix) {
        if (i == 0 && j == 0)
            return 0;
        if (i > 0 && j == 0)
            return i;
        if (j > 0 && i == 0)
            return j;
        int m = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;

        int min = matrix[i][j - 1] + 1;
        if (matrix[i - 1][j] + 1 < min)
            min = matrix[i - 1][j] + 1;
        if (matrix[i - 1][j - 1] + m < min)
            min = matrix[i - 1][j - 1] + m;
        return min;
    }


}
