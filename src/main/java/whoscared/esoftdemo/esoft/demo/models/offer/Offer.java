package whoscared.esoftdemo.esoft.demo.models.offer;

import jakarta.persistence.*;
import whoscared.esoftdemo.esoft.demo.models.immovables.RealEstate;
import whoscared.esoftdemo.esoft.demo.models.people.Client;
import whoscared.esoftdemo.esoft.demo.models.people.Realtor;

@Entity
@Table
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name = "client", referencedColumnName = "id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "realtor", referencedColumnName = "id")
    private Realtor realtor;

    @OneToOne
    @JoinColumn(name = "real_estate", referencedColumnName = "id")
    private RealEstate realEstate;

    @Column(name = "price")
    private int price;

    public Offer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public RealEstate getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(RealEstate realEstate) {
        this.realEstate = realEstate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "realEstate=" + realEstate +
                ", price=" + price +
                '}';
    }
}
