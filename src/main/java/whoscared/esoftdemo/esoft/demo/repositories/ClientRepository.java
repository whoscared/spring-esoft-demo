package whoscared.esoftdemo.esoft.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import whoscared.esoftdemo.esoft.demo.models.people.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByFirstname(String firstname);

    List<Client> findByLastname(String lastname);

    List<Client> findByPatronymic(String patronymic);

    Optional<Client> findByEmail(String email);

}
