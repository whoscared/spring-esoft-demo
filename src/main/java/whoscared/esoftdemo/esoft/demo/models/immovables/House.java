package whoscared.esoftdemo.esoft.demo.models.immovables;

import jakarta.persistence.*;

@Entity
@Table(name = "house")
public class House extends RealEstate {
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

    @Column(name = "apartmentNumber")
    private String apartmentNumber;
    @Column(name = "latitude")
    private int latitude;
    @Column(name = "latitude")
    private int longitude;

    @Column(name = "countOfFloors")
    private int countOfFloors;

    @Column(name = "countOfRooms")
    private int countOfRooms;
    @Column(name = "area")
    private int area;

    public House() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
