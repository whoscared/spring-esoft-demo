//package whoscared.esoftdemo.esoft.demo.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import whoscared.esoftdemo.esoft.demo.models.immovables.Apartment;
//import whoscared.esoftdemo.esoft.demo.models.immovables.House;
//import whoscared.esoftdemo.esoft.demo.repositories.HouseRepository;
//
//import java.util.List;
//
//@Service
//public class HouseService {
//    private final HouseRepository houseRepository;
//
//    @Autowired
//    public HouseService(HouseRepository houseRepository) {
//        this.houseRepository = houseRepository;
//    }
//
//    public List<House> findAll(){
//        return houseRepository.findAll();
//    }
//    public List<House> findByCityAndStreet (String city, String street ){return houseRepository.findByCityAndStreet(city, street);}
//
//    public void save(House house){houseRepository.save(house);}
//}
