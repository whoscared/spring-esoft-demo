package whoscared.esoftdemo.esoft.demo.models.offer;

import whoscared.esoftdemo.esoft.demo.models.immovables.RealEstate;
import whoscared.esoftdemo.esoft.demo.models.people.Client;
import whoscared.esoftdemo.esoft.demo.models.people.Realtor;

public class Offer {
    private long id;
    private Client client;
    private Realtor realtor;
    private RealEstate realEstate;
    private int price;

}
