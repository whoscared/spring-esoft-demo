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

    @OneToOne(mappedBy = "offer")
    @PrimaryKeyJoinColumn
    private Client client;

    @OneToOne(mappedBy = "offer")
    @PrimaryKeyJoinColumn
    private Realtor realtor;

    @OneToOne(mappedBy = "offer")
    @PrimaryKeyJoinColumn
    private RealEstate realEstate;

    @Column(name = "price")
    private int price;

}
