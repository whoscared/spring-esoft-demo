package whoscared.esoftdemo.esoft.demo.models.immovables;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import whoscared.esoftdemo.esoft.demo.models.Address;
import whoscared.esoftdemo.esoft.demo.models.offer.Offer;

@Entity
@Table(name = "real_estate")
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type_of_real_estate")
    @Enumerated(EnumType.STRING)
    private TypeOfRealEstate typeOfRealEstate;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Min(value = 1, message = "Floor must be greater than 0")
    @Column(name = "floor")
    private Integer floor;

    @Min(value = 1, message = "Count of rooms must be greater than 0")
    @Column(name = "rooms")
    private Integer rooms;

    @Min(value = 1, message = "Area must be greater than 0")
    @Column(name = "area")
    private Integer area;

    @OneToOne(mappedBy = "realEstate")
    private Offer offer;


    public RealEstate() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeOfRealEstate getTypeOfRealEstate() {
        return typeOfRealEstate;
    }

    public void setTypeOfRealEstate(TypeOfRealEstate typeOfRealEstate) {
        this.typeOfRealEstate = typeOfRealEstate;
    }


    public Integer getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void toRealEstateObject(TypeOfRealEstate typeOfRealEstate) {
        if (typeOfRealEstate == TypeOfRealEstate.LAND) {
            floor = null;
            rooms = null;
        }
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "typeOfRealEstate=" + typeOfRealEstate +
                ", address =" + address.toString() +
                '}';
    }
}
