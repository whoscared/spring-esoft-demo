package whoscared.esoftdemo.esoft.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whoscared.esoftdemo.esoft.demo.models.immovables.Apartment;
import whoscared.esoftdemo.esoft.demo.repositories.ApartmentRepository;

import java.util.List;

@Service
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    @Autowired
    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public List<Apartment> findAll(){
        return apartmentRepository.findAll();
    }
    public List<Apartment> findByCityAndStreet (String city, String street ){return apartmentRepository.findByCityAndStreet(city, street);}

    public void save(Apartment apartment){apartmentRepository.save(apartment);}
}

