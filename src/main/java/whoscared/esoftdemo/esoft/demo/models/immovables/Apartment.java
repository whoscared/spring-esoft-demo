package whoscared.esoftdemo.esoft.demo.models.immovables;

import jakarta.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Table(name = "real_estate_object")
public class Apartment extends RealEstate {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "floor")
    private int floor;
    @Column(name = "rooms")
    private int rooms;
    @Column(name = "area")
    private int area;

    private final TypeOfRealEstate typeOfRealEstate = TypeOfRealEstate.APARTMENT;

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
