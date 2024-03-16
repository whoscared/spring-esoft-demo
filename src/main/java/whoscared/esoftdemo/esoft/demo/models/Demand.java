package whoscared.esoftdemo.esoft.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import whoscared.esoftdemo.esoft.demo.models.immovables.TypeOfRealEstate;
import whoscared.esoftdemo.esoft.demo.models.people.Client;
import whoscared.esoftdemo.esoft.demo.models.people.Realtor;

// потребность
@Entity
@Table(name = "demand")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type_of_real_estate")
    @Enumerated(EnumType.STRING)
    private TypeOfRealEstate typeOfRealEstate;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id")
    private Client client;
    
    @ManyToOne
    @JoinColumn(name = "realtor", referencedColumnName = "id")
    private Realtor realtor;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Column(name = "min_area")
    @Min(value = 1, message = "Area must be greater than 0")
    private Integer minArea;
    @Column(name = "max_area")
    private Integer maxArea;
    @Min(value = 1, message = "Room must be greater than 0")
    @Column(name = "min_room")
    private Integer minRoom;
    @Column(name = "max_room")
    private Integer maxRoom;
    @Min(value = 1, message = "Floor must be greater than 0")
    @Column(name = "min_float")
    private Integer minFloat;

    @Column(name = "max_float")
    private Integer maxFloat;

    @OneToOne(mappedBy = "demand")
    private Deal deal;

    public Demand() {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Realtor getRealtor() {
        return realtor;
    }

    public void setRealtor(Realtor realtor) {
        this.realtor = realtor;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getMinArea() {
        return minArea;
    }

    public void setMinArea(Integer minArea) {
        this.minArea = minArea;
    }

    public Integer getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(Integer maxArea) {
        this.maxArea = maxArea;
    }

    public Integer getMinRoom() {
        return minRoom;
    }

    public void setMinRoom(Integer minRoom) {
        this.minRoom = minRoom;
    }

    public Integer getMaxRoom() {
        return maxRoom;
    }

    public void setMaxRoom(Integer maxRoom) {
        this.maxRoom = maxRoom;
    }

    public Integer getMinFloat() {
        return minFloat;
    }

    public void setMinFloat(Integer minFloat) {
        this.minFloat = minFloat;
    }

    public Integer getMaxFloat() {
        return maxFloat;
    }

    public void setMaxFloat(Integer maxFloat) {
        this.maxFloat = maxFloat;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }


    @Override
    public String toString() {
        return "Demand{" +
                "typeOfRealEstate=" + typeOfRealEstate +
                ", address=" + address.toString() +
                ", minArea=" + minArea +
                ", maxArea=" + maxArea +
                ", minRoom=" + minRoom +
                ", maxRoom=" + maxRoom +
                ", minFloat=" + minFloat +
                ", maxFloat=" + maxFloat +
                '}';
    }
}
