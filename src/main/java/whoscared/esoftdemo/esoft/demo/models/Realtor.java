package whoscared.esoftdemo.esoft.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "realtor")
public class Realtor {
    @Id
    @Column(name = "id")
    private long id;

    @NotEmpty(message = "Lastname should not be empty")
    @Max(value = 50, message = "Lastname should not be larger than 50 symbols")
    @Column(name = "lastname")
    private String lastname;

    @NotEmpty(message = "Firstname should not be empty")
    @Max(value = 50, message = "Firstname should not be larger than 50 symbols")
    @Column(name = "firsname")
    private String firstname;

    @NotEmpty(message = "Patronymic should not be empty")
    @Max(value = 50, message = "Patronymic should not be larger than 50 symbols")
    @Column(name = "patronymic")
    private String patronymic;

    @Size(min = 0, max = 100, message = "Share Of Commission must be between 0 and 100")
    @Column(name = "share_of_commission")
    private int shareOfCommission;

    @Column(name = "offer")
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
