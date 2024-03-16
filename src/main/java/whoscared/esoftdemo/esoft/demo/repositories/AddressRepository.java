package whoscared.esoftdemo.esoft.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import whoscared.esoftdemo.esoft.demo.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
