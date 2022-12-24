package whoscared.esoftdemo.esoft.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import whoscared.esoftdemo.esoft.demo.models.immovables.Land;
import whoscared.esoftdemo.esoft.demo.models.immovables.RealEstate;
import whoscared.esoftdemo.esoft.demo.models.immovables.TypeOfRealEstate;
import whoscared.esoftdemo.esoft.demo.repositories.RealEstateRepository;


import java.util.List;

@Service
public class RealEstateService {
    private final RealEstateRepository realEstateRepository;

    @Autowired
    public RealEstateService(RealEstateRepository realEstateRepository) {
        this.realEstateRepository = realEstateRepository;
    }

    public List<RealEstate> findAll() {
        return realEstateRepository.findAll();
    }

    public List<RealEstate> findByCityAndStreet(String city, String street) {
        return realEstateRepository.findByCityAndStreet(city, street);
    }

    public List<RealEstate> findByTypeOfRealEstate (TypeOfRealEstate typeOfRealEstate){
        return realEstateRepository.findByTypeOfRealEstate(typeOfRealEstate);
    }

    public List<RealEstate> findWithoutOffer () {
        return findAll().stream().filter(x -> x.getOffer() == null).toList();
    }

    public void save(RealEstate realEstate) {
        realEstateRepository.save(realEstate);
    }
}
