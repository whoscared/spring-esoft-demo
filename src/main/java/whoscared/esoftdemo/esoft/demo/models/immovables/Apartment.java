package whoscared.esoftdemo.esoft.demo.models.immovables;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;

@Component
public class Apartment extends RealEstate {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private long id;

//    @Column(name = "city")
    private String city;

//    @Column(name = "street")
    private String street;

//    @Column(name = "house")
    private String house;

//    @Column(name = "apartmentnumber")
    private String apartmentNumber;
//    @Column(name = "latitude")
    private Integer latitude = null;
//    @Column(name = "longitude")
    private Integer longitude = null;
//    @Column(name = "floor")
    private int floor;
//    @Column(name = "countofrooms")
    private int rooms;
//    @Column(name = "apartmentarea")
    private int area;

    @Column(name = "type_of_real_estate")
    private TypeOfRealEstate typeOfRealEstate = TypeOfRealEstate.APARTMENT;
    public Apartment() {
    }

    public Apartment(RealEstate realEstate){
//        city = realEstate.getCity();
//        street = realEstate.getStreet();
//        house = realEstate.getHouse();
//        apartmentNumber = realEstate.getApartmentNumber();
//        latitude = realEstate.getLatitude();
//        longitude = realEstate.getLongitude();
        floor = realEstate.getFloor();
        rooms = realEstate.getRooms();
        area = realEstate.getArea();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

//    @Override
//    public String getCity() {
//        return city;
//    }
//
//    @Override
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    @Override
//    public String getStreet() {
//        return street;
//    }
//
//    @Override
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    @Override
//    public String getHouse() {
//        return house;
//    }
//
//    @Override
//    public void setHouse(String house) {
//        this.house = house;
//    }
//
//    @Override
//    public String getApartmentNumber() {
//        return apartmentNumber;
//    }
//
//    @Override
//    public void setApartmentNumber(String apartmentNumber) {
//        this.apartmentNumber = apartmentNumber;
//    }
//
//    @Override
//    public Integer getLatitude() {
//        return latitude;
//    }
//
//    @Override
//    public void setLatitude(Integer latitude) {
//        this.latitude = latitude;
//    }
//
//    @Override
//    public Integer getLongitude() {
//        return longitude;
//    }
//
//    @Override
//    public void setLongitude(Integer longitude) {
//        this.longitude = longitude;
//    }

    @Override
    public Integer getFloor() {
        return floor;
    }

    @Override
    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public Integer getRooms() {
        return rooms;
    }

    @Override
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public Integer getArea() {
        return area;
    }

    @Override
    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public TypeOfRealEstate getTypeOfRealEstate() {
        return typeOfRealEstate;
    }

    @Override
    public void setTypeOfRealEstate(TypeOfRealEstate typeOfRealEstate) {
        this.typeOfRealEstate = typeOfRealEstate;
    }
}
