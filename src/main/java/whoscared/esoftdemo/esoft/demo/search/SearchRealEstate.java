package whoscared.esoftdemo.esoft.demo.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import whoscared.esoftdemo.esoft.demo.models.immovables.RealEstate;
import whoscared.esoftdemo.esoft.demo.services.RealEstateService;


import java.util.ArrayList;
import java.util.List;

@Component
public class SearchRealEstate extends SearchWithLevenshteinDistance {
    private final RealEstateService realEstateService;

    @Autowired
    public SearchRealEstate(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    public List<RealEstate> searchRealEstates(RealEstate realEstate) {
        List<RealEstate> result = new ArrayList<>();
        List<RealEstate> allObjects = new ArrayList<>(realEstateService.findAll());


        String cityAndStreet = realEstate.getAddress().getCity() + " " + realEstate.getAddress().getStreet();
        String houseAndApartmentNumber = realEstate.getAddress().getHouse() + " " + realEstate.getAddress().getApartmentNumber();

        for (RealEstate temp : allObjects) {
            String tempCityAndStreet = "";
            String tempHouseAndApartmentNumber = "";

            //строка город и улица
            tempCityAndStreet += realEstate.getAddress().getCity().isEmpty() ? " " : temp.getAddress().getCity();
            tempCityAndStreet += realEstate.getAddress().getStreet().isEmpty() ? " " : temp.getAddress().getStreet();

            //строка номер дома и номер квартиры
            tempHouseAndApartmentNumber += realEstate.getAddress().getHouse().isEmpty() ? " " : temp.getAddress().getHouse();
            tempHouseAndApartmentNumber += realEstate.getAddress().getApartmentNumber().isEmpty() ? " " : temp.getAddress().getApartmentNumber();



            if (levenshteinDistance(tempCityAndStreet.replace(" ", ""), cityAndStreet.replace(" ", "")) <= 3
                    && levenshteinDistance(tempHouseAndApartmentNumber.replace(" ", ""), houseAndApartmentNumber.replace(" ", "")) <= 1) {
                result.add(temp);
            }

        }

        return result;
    }
}
