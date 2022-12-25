package whoscared.esoftdemo.esoft.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import whoscared.esoftdemo.esoft.demo.models.Demand;
import whoscared.esoftdemo.esoft.demo.models.people.Client;
import whoscared.esoftdemo.esoft.demo.models.people.Realtor;

import java.util.List;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {
    List<Demand> findByClient (Client client);
    List<Demand> findByRealtor (Realtor realtor);
}
