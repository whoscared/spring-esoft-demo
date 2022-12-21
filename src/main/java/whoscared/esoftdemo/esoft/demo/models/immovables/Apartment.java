package whoscared.esoftdemo.esoft.demo.models.immovables;

import jakarta.persistence.*;

@Entity
@Table(name = "apartment")
public class Apartment extends RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "apartmentnumber")
    private String apartmentNumber;
    @Column(name = "latitude")
    private int latitude;
    @Column(name = "longitude")
    private int longitude;
    @Column(name = "floor")
    private int floor;
    @Column(name = "countofrooms")
    private int rooms;
    @Column(name = "apartmentarea")
    private int area;

    @Column(name = "type_of_real_estate")
    private TypeOfRealEstate typeOfRealEstate = TypeOfRealEstate.APARTMENT;
    public Apartment() {
    }

    public Apartment(RealEstate realEstate){
        city = realEstate.getCity();
        street = realEstate.getStreet();
        house = realEstate.getHouse();
        apartmentNumber = realEstate.getApartmentNumber();
        latitude = realEstate.getLatitude();
        longitude = realEstate.getLongitude();
        floor = realEstate.getFloors();
        rooms = realEstate.getRooms();
        area = realEstate.getArea();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
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
    public int getLatitude() {
        return latitude;
    }

    @Override
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    @Override
    public int getLongitude() {
        return longitude;
    }

    @Override
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    @Override
    public TypeOfRealEstate getTypeOfRealEstate() {
        return typeOfRealEstate;
    }
}
