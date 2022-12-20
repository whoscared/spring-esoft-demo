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
    @Column(name = "rooms")
    private int rooms;
    @Column(name = "area")
    private int area;


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
}
