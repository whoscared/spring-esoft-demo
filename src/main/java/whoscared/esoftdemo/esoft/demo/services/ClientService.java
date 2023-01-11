package whoscared.esoftdemo.esoft.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whoscared.esoftdemo.esoft.demo.models.people.Client;
import whoscared.esoftdemo.esoft.demo.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> allClients() {
        return clientRepository.findAll();
    }

    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email).orElse(null);
    }

    public List<Client> findByFirstname(String firstname) {
        return clientRepository.findByFirstname(firstname);
    }

    public List<Client> findByLastName(String lastname) {
        return clientRepository.findByLastname(lastname);
    }

    public List<Client> findByPatronymic(String patronymic) {
        return clientRepository.findByPatronymic(patronymic);
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public Client findById(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> findWithoutOffer() {
        //List<Client> allClients = allClients().stream().filter(x -> x.getOffer() == null).toList();
        return allClients().stream().filter(x -> x.getOffer() == null).toList();
    }

//    public List<Client> findWithoutDeal () {
//        return allClients().stream().filter(x-> x.getOffer().getDeal() == null && x.getDemand().getDeal() == null).toList();
//    }

    public void update(long id, Client client) {
        client.setId(id);
        clientRepository.save(client);
    }


    public void delete(long id) {
        clientRepository.deleteById(id);
    }
}
