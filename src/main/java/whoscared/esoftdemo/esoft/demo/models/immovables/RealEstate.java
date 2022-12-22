package whoscared.esoftdemo.esoft.demo.models.immovables;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import whoscared.esoftdemo.esoft.demo.models.offer.Offer;

@Entity
@Table(name = "real_estate")
public class RealEstate {
//добавить предложение и добавить предложение в таблицы данных моделей в бд как столбец
    // удаление объекта связанного с приложением невозможно
    //предложение - отдельная таблица, с которой связаны три таблицы типов объектов и таблицы клиентов и риэлторов
    //организовать поиск в заданных координатах
    //добавить валидацию объектов (координаты)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type_of_real_estate")
    private TypeOfRealEstate typeOfRealEstate;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private String house;
    @Column(name = "apartment_number")
    private String apartmentNumber;
    @Column(name = "latitude")
    private Integer latitude;
    @Column(name = "longitude")
    private Integer longitude;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "rooms")
    private Integer rooms;

    @Column(name = "area")
    private Integer area;

    @OneToOne
    @JoinColumn(name = "offer",referencedColumnName = "id")
    private Offer offer;


    public RealEstate() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
            this.floor = floor;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
            this.rooms = rooms;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void toRealEstateObject(TypeOfRealEstate typeOfRealEstate){
        if (typeOfRealEstate == TypeOfRealEstate.LAND){
            floor = null;
            rooms = null;
        }
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
