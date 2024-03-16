package whoscared.esoftdemo.esoft.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import whoscared.esoftdemo.esoft.demo.models.Deal;

public interface DealRepository extends JpaRepository<Deal, Long> {
}
