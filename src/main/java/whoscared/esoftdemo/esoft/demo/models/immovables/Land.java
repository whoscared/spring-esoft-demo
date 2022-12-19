package whoscared.esoftdemo.esoft.demo.models.immovables;

import jakarta.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Table (name = "land")
public class Land extends RealEstate {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "area")
    private int area;

    private final TypeOfRealEstate typeOfRealEstate = TypeOfRealEstate.LAND;

    public Land() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
