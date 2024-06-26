package whoscared.esoftdemo.esoft.demo.models;

import jakarta.persistence.*;
import whoscared.esoftdemo.esoft.demo.models.Deal;
import whoscared.esoftdemo.esoft.demo.models.immovables.RealEstate;
import whoscared.esoftdemo.esoft.demo.models.people.Client;
import whoscared.esoftdemo.esoft.demo.models.people.Realtor;

// предложение
@Entity
@Table
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "realtor", referencedColumnName = "id")
    private Realtor realtor;

    @OneToOne
    @JoinColumn(name = "real_estate", referencedColumnName = "id")
    private RealEstate realEstate;

    @Column(name = "price")
    private int price;

    @OneToOne(mappedBy = "offer")
    private Deal deal;

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

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    @Override
    public String toString() {
        return "Offer{" +
                ", client firstname=" + client.getFirstname() +
                ", client lastname=" + client.getLastname() +
                ", client email=" + client.getEmail() +
                ", realtor firstname=" + realtor.getFirstname() +
                ", realtor lastname=" + realtor.getLastname() +
                ", realEstate=" + realEstate.toString() +
                ", price=" + price +
                '}';
    }
}
