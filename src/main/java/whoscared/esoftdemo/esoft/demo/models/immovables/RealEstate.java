package whoscared.esoftdemo.esoft.demo.models.immovables;

import org.springframework.stereotype.Component;

@Component
public class RealEstate {

    private String city;
    private String street;
    private String house;
    private String apartmentNumber;
    private int latitude;
    private int longitude;

    private int floors;

    private int rooms;

    private int area;

    private TypeOfRealEstate typeOfRealEstate;

    public RealEstate() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
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

    public TypeOfRealEstate getTypeOfRealEstate() {
        return typeOfRealEstate;
    }

    public void setTypeOfRealEstate(TypeOfRealEstate typeOfRealEstate) {
        this.typeOfRealEstate = typeOfRealEstate;
    }
}
