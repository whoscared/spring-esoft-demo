package whoscared.esoftdemo.esoft.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import whoscared.esoft.esoftdemo.services.ClientService;
import whoscared.esoft.esoftdemo.services.RealtorService;

@Component
public class SearchClientsAndRealtors {
    private final ClientService clientService;
    private final RealtorService realtorService;

    @Autowired
    public SearchClientsAndRealtors(ClientService clientService, RealtorService realtorService) {
        this.clientService = clientService;
        this.realtorService = realtorService;
    }

//    public List<Client> searchClients (String s){
//        List<Client> allClients = clientService.allClients();
//
//    }
//
//    private int getLevenshteinDistance (String first, String second){
//        int lenght_first = first.length();
//        int lenght_second = second.length();
//
//
//    }
}
