package whoscared.esoftdemo.esoft.demo.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import whoscared.esoftdemo.esoft.demo.models.immovables.RealEstate;
import whoscared.esoftdemo.esoft.demo.services.RealEstateService;


import java.util.ArrayList;
import java.util.List;

@Component
public class SearchRealEstate extends SearchWithLevenshteinDistance {
    private RealEstateService realEstateService;

    @Autowired
    public SearchRealEstate(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    //@Autowired
//    public SearchRealEstate(ApartmentService apartmentService, HouseService houseService, LandService landService) {
//        this.apartmentService = apartmentService;
//        this.houseService = houseService;
//        this.landService = landService;
//    }

    public List<RealEstate> searchRealEstates(RealEstate realEstate) {
        List<RealEstate> result = new ArrayList<>();
        List<RealEstate> allObjects = new ArrayList<>(realEstateService.findAll());
        //allObjects.addAll(apartmentService.findAll());
        //allObjects.addAll(houseService.findAll());
        //allObjects.addAll(landService.findAll());

        String cityAndStreet = realEstate.getCity() + " " + realEstate.getStreet();
        String houseAndApartmentNumber = realEstate.getHouse() + " " + realEstate.getApartmentNumber();

        for (RealEstate temp : allObjects) {
            String tempCityAndStreet = "";
            String tempHouseAndApartmentNumber = "";

            tempCityAndStreet += realEstate.getCity().isEmpty() ? " " : temp.getCity();
            tempCityAndStreet += realEstate.getStreet().isEmpty() ? " " : temp.getStreet();

            tempHouseAndApartmentNumber += realEstate.getHouse().isEmpty() ? " " : temp.getHouse();
            tempHouseAndApartmentNumber += realEstate.getApartmentNumber().isEmpty() ? " " : temp.getApartmentNumber();

            if (levenshteinDistance(tempCityAndStreet.replace(" ", ""), cityAndStreet.replace(" ", "")) <= 3
                    && levenshteinDistance(tempHouseAndApartmentNumber.replace(" ", ""), houseAndApartmentNumber.replace(" ", "")) <= 1) {
                result.add(temp);
            }

        }

        return result;
    }
}
