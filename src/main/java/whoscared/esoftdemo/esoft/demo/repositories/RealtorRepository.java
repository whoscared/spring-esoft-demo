package whoscared.esoftdemo.esoft.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import whoscared.esoft.esoftdemo.models.Realtor;

@Repository
public interface RealtorRepository extends JpaRepository<Realtor, Long> {
    void deleteById (long id);
}
