package whoscared.esoftdemo.esoft.demo.models.immovables;

import jakarta.persistence.*;

@Entity
@Table (name = "land")
public class Land extends RealEstate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "area")
    private int area;

    @Column(name = "type_of_real_estate")
    private TypeOfRealEstate typeOfRealEstate = TypeOfRealEstate.LAND;

    public Land() {
    }

    public Land(RealEstate realEstate){
        city = realEstate.getCity();
        street = realEstate.getStreet();
        house = realEstate.getHouse();
        apartmentNumber = realEstate.getApartmentNumber();
        latitude = realEstate.getLatitude();
        longitude = realEstate.getLongitude();
        area = realEstate.getArea();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
