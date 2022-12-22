package whoscared.esoftdemo.esoft.demo.models.people;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import whoscared.esoftdemo.esoft.demo.models.offer.Offer;

@Entity
@Table(name = "realtor")
public class Realtor extends Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Lastname should not be empty")
    @Max(value = 50, message = "Lastname should not be larger than 50 symbols")
    @Column(name = "lastname")
    private String lastname;

    @NotEmpty(message = "Firstname should not be empty")
    @Max(value = 50, message = "Firstname should not be larger than 50 symbols")
    @Column(name = "firstname")
    private String firstname;

    @NotEmpty(message = "Patronymic should not be empty")
    @Max(value = 50, message = "Patronymic should not be larger than 50 symbols")
    @Column(name = "patronymic")
    private String patronymic;

    @NotEmpty(message = "Share Of Commission should not be empty")
    @Size(max = 100, message = "Share Of Commission must be between 0 and 100")
    @Column(name = "share_of_commission")
    private int shareOfCommission;

    @OneToOne
    @JoinColumn(name = "offer" ,referencedColumnName = "id")
    private Offer offer;

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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
