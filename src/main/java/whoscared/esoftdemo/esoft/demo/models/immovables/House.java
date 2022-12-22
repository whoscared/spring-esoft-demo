package whoscared.esoftdemo.esoft.demo.models.immovables;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class House extends RealEstate {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

//    @Column(name = "countoffloors")
    private int countOfFloors;

//    @Column(name = "countofrooms")
    private int countOfRooms;
//    @Column(name = "area")
    private int area;

    private final TypeOfRealEstate typeOfRealEstate = TypeOfRealEstate.HOUSE;

    public House() {

    }

    public House(RealEstate realEstate) {
        id = realEstate.getId();
        city = realEstate.getCity();
        street = realEstate.getStreet();
        house = realEstate.getHouse();
        apartmentNumber = realEstate.getApartmentNumber();
        latitude = realEstate.getLatitude();
        longitude = realEstate.getLongitude();
        countOfFloors = realEstate.getFloor();
        countOfRooms = realEstate.getRooms();
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

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getHouse() {
        return house;
    }

    @Override
    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public String getApartmentNumber() {
        return apartmentNumber;
    }

    @Override
    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    @Override
    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public int getCountOfFloors() {
        return countOfFloors;
    }

    public void setCountOfFloors(int countOfFloors) {
        this.countOfFloors = countOfFloors;
    }

    public int getCountOfRooms() {
        return countOfRooms;
    }

    public void setCountOfRooms(int countOfRooms) {
        this.countOfRooms = countOfRooms;
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
}
