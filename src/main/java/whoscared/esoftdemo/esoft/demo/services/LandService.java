package whoscared.esoftdemo.esoft.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whoscared.esoftdemo.esoft.demo.models.immovables.Apartment;
import whoscared.esoftdemo.esoft.demo.models.immovables.Land;
import whoscared.esoftdemo.esoft.demo.repositories.LandRepository;

import java.util.List;

@Service
public class LandService {
    private final LandRepository landRepository;

    @Autowired
    public LandService(LandRepository landRepository) {
        this.landRepository = landRepository;
    }

    public List<Land> findAll() {
        return landRepository.findAll();
    }

    public List<Land> findByCityAndStreet (String city, String street ){return landRepository.findByCityAndStreet(city, street);}
}
