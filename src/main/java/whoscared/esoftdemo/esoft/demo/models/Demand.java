package whoscared.esoftdemo.esoft.demo.models;

import jakarta.persistence.*;
import whoscared.esoftdemo.esoft.demo.models.immovables.TypeOfRealEstate;
import whoscared.esoftdemo.esoft.demo.models.people.Client;
import whoscared.esoftdemo.esoft.demo.models.people.Realtor;

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
    private int minArea;
    @Column(name = "max_area")
    private int maxArea;
    @Column(name = "min_room")
    private int minRoom;
    @Column(name = "max_room")
    private int maxRoom;
    @Column(name = "min_float")
    private int minFloat;
    @Column(name = "max_float")
    private int maxFloat;

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

    public int getMinArea() {
        return minArea;
    }

    public void setMinArea(int minArea) {
        this.minArea = minArea;
    }

    public int getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(int maxArea) {
        this.maxArea = maxArea;
    }

    public int getMinRoom() {
        return minRoom;
    }

    public void setMinRoom(int minRoom) {
        this.minRoom = minRoom;
    }

    public int getMaxRoom() {
        return maxRoom;
    }

    public void setMaxRoom(int maxRoom) {
        this.maxRoom = maxRoom;
    }

    public int getMinFloat() {
        return minFloat;
    }

    public void setMinFloat(int minFloat) {
        this.minFloat = minFloat;
    }

    public int getMaxFloat() {
        return maxFloat;
    }

    public void setMaxFloat(int maxFloat) {
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
