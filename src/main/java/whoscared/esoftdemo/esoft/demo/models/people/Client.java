package whoscared.esoftdemo.esoft.demo.models.people;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import whoscared.esoftdemo.esoft.demo.models.Demand;
import whoscared.esoftdemo.esoft.demo.models.offer.Offer;
import whoscared.esoftdemo.esoft.demo.utils.annotation.Phone;

import java.util.List;


@Entity
@Table(name = "client")
public class Client extends Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 1, max = 50, message = "Lastname cannot be more than 50 characters")
    @Column(name = "lastname")
    private String lastname;

    @Size(min = 1, max = 50, message = "Firstname cannot be more than 50 characters")
    @Column(name = "firstname")
    private String firstname;

    @Size(min = 1, max = 50, message = "Patronymic cannot be more than 50 characters")
    @Column(name = "patronymic")
    private String patronymic;

    @Phone(message = "Phone number entered incorrectly")
    @Column(name = "phone")
    private String phone;

    @Email(message = "Email entered incorrectly")
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Offer> offer;

    @OneToMany(mappedBy = "client")
    private List<Demand> demand;

    public List<Demand> getDemand() {
        return demand;
    }

    public void setDemand(List<Demand> demand) {
        this.demand = demand;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Offer> getOffer() {
        return offer;
    }

    public void setOffer(List<Offer> offer) {
        this.offer = offer;
    }
}
