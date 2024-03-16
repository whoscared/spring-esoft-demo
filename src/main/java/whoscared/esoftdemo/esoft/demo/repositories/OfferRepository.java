package whoscared.esoftdemo.esoft.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import whoscared.esoftdemo.esoft.demo.models.Offer;
import whoscared.esoftdemo.esoft.demo.models.people.Client;
import whoscared.esoftdemo.esoft.demo.models.people.Realtor;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    Offer findByClient(Client client);

    Offer findByRealtor(Realtor realtor);

}
