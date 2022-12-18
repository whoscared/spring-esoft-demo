package whoscared.esoftdemo.esoft.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;


@Entity
@Table(name = "client")
public class Client extends Person{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 1, max = 50)
    @Column(name = "lastname")
    private String lastname;

    @Size(min = 1, max = 50)
    @Column(name = "firstname")
    private String firstname;

    @Size(min = 1, max = 50)
    @Column(name = "patronymic")
    private String patronymic;


    //@Min(value = 11, message = "Phone number must contain 11 digits")
    @Column(name = "phone")
    private String phone;

    @Email(message = "Email introduced not correct")
    @Column(name = "email")
    private String email;

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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
