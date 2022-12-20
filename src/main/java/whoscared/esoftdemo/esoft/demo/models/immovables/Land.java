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

    @Column(name = "apartmentNumber")
    private String apartmentNumber;
    @Column(name = "latitude")
    private int latitude;
    @Column(name = "latitude")
    private int longitude;
    @Column(name = "area")
    private int area;

    public Land() {
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
}
