//package whoscared.esoftdemo.esoft.demo.search;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import whoscared.esoftdemo.esoft.demo.models.immovables.RealEstate;
//import whoscared.esoftdemo.esoft.demo.services.ApartmentService;
//import whoscared.esoftdemo.esoft.demo.services.HouseService;
//import whoscared.esoftdemo.esoft.demo.services.LandService;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@Component
//public class SearchRealEstate extends SearchWithLevenshteinDistance {
//    private final ApartmentService apartmentService;
//    private final HouseService houseService;
//    private final LandService landService;
//
//    //@Autowired
//    public SearchRealEstate(ApartmentService apartmentService, HouseService houseService, LandService landService) {
//        this.apartmentService = apartmentService;
//        this.houseService = houseService;
//        this.landService = landService;
//    }
//
//    public List<RealEstate> searchRealEstates(RealEstate realEstate) {
//        List<RealEstate> result = new ArrayList<>();
//        List<RealEstate> allObjects = new ArrayList<>();
//        //allObjects.addAll(apartmentService.findAll());
//        //allObjects.addAll(houseService.findAll());
//        //allObjects.addAll(landService.findAll());
//
//        String cityAndStreet = realEstate.getCity() + " " + realEstate.getStreet();
//        String houseAndApartmentNumber = realEstate.getHouse() + " " + realEstate.getApartmentNumber();
//
//        for (RealEstate temp : allObjects) {
//            String tempCityAndStreet = "";
//            String tempHouseAndApartmentNumber = "";
//
//            tempCityAndStreet += realEstate.getCity().isEmpty() ? " " : temp.getCity();
//            tempCityAndStreet += realEstate.getStreet().isEmpty() ? " " : temp.getStreet();
//
//            tempHouseAndApartmentNumber += realEstate.getHouse().isEmpty() ? " " : temp.getHouse();
//            tempHouseAndApartmentNumber += realEstate.getApartmentNumber().isEmpty() ? " " : temp.getApartmentNumber();
//
//            if (levenshteinDistance(tempCityAndStreet.replace(" ", ""), cityAndStreet.replace(" ", "")) <= 3
//                    && levenshteinDistance(tempHouseAndApartmentNumber.replace(" ", ""), houseAndApartmentNumber.replace(" ", "")) <= 1) {
//                result.add(temp);
//            }
//
//        }
//
//        return result;
//    }
//}
