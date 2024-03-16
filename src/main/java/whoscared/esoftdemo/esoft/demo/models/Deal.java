package whoscared.esoftdemo.esoft.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "deal")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name = "offer", referencedColumnName = "id")
    private Offer offer;

    @OneToOne
    @JoinColumn(name = "demand", referencedColumnName = "id")
    private Demand demand;

    public Deal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", offer=" + offer.toString() +
                ", demand=" + demand.toString() +
                '}';
    }
}
