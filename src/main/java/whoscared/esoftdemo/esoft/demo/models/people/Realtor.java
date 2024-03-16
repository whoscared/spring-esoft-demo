package whoscared.esoftdemo.esoft.demo.models.people;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import whoscared.esoftdemo.esoft.demo.models.Demand;
import whoscared.esoftdemo.esoft.demo.models.Offer;

import java.util.List;

@Entity
@Table(name = "realtor")
public class Realtor extends Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Lastname should not be empty")
    @Size(max = 50, message = "Lastname should not be larger than 50 symbols")
    @Column(name = "lastname")
    private String lastname;

    @NotEmpty(message = "Firstname should not be empty")
    @Size(max = 50, message = "Firstname should not be larger than 50 symbols")
    @Column(name = "firstname")
    private String firstname;

    @NotEmpty(message = "Patronymic should not be empty")
    @Size(max = 50, message = "Patronymic should not be larger than 50 symbols")
    @Column(name = "patronymic")
    private String patronymic;


    @Min(value = 0, message = "Share Of Commission must be between 0 and 100")
    @Max(value = 100, message = "Share Of Commission must be between 0 and 100")
    @Column(name = "share_of_commission")
    private int shareOfCommission;

    @OneToMany(mappedBy = "realtor")
    private List<Offer> offer;

    @OneToMany(mappedBy = "realtor")
    private List<Demand> demand;

    public Realtor(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getShareOfCommission() {
        return shareOfCommission;
    }

    public void setShareOfCommission(int shareOfCommission) {
        this.shareOfCommission = shareOfCommission;
    }

    public List<Offer> getOffer() {
        return offer;
    }

    public void setOffer(List<Offer> offer) {
        this.offer = offer;
    }

    public List<Demand> getDemand() {
        return demand;
    }

    public void setDemand(List<Demand> demand) {
        this.demand = demand;
    }
}
