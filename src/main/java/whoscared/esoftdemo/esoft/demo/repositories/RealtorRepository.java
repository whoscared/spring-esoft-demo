package whoscared.esoftdemo.esoft.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import whoscared.esoftdemo.esoft.demo.models.people.Realtor;

import java.util.List;

@Repository
public interface RealtorRepository extends JpaRepository<Realtor, Long> {
    List<Realtor> findByFirstname(String firstname);

    List<Realtor> findByLastname(String lastname);

    List<Realtor> findByPatronymic(String patronymic);

}
