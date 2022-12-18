package whoscared.esoftdemo.esoft.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whoscared.esoftdemo.esoft.demo.models.Client;
import whoscared.esoftdemo.esoft.demo.repositories.ClientRepository;

import java.util.List;

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

    public List<Client> findByFirstname (String firstname){
        return clientRepository.findByFirstname(firstname);
    }

    public List<Client> findByLastName (String lastname){
        return clientRepository.findByLastname(lastname);
    }

    public List<Client> findByPatronymic (String patronymic) {
        return clientRepository.findByPatronymic(patronymic);
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public Client findById(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public void update(long id, Client client) {
        client.setId(id);
        clientRepository.save(client);
    }

    public void delete(long id) {
        clientRepository.deleteById(id);
    }
}
