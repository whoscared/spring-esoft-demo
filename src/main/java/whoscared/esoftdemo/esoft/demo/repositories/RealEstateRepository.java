package whoscared.esoftdemo.esoft.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import whoscared.esoftdemo.esoft.demo.models.immovables.RealEstate;
import whoscared.esoftdemo.esoft.demo.models.immovables.TypeOfRealEstate;

import java.util.List;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {
    List<RealEstate> findAll ();
    List<RealEstate> findByTypeOfRealEstate(TypeOfRealEstate typeOfRealEstate);
}
