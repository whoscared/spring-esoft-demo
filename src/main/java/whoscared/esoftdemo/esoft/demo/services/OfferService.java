package whoscared.esoftdemo.esoft.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whoscared.esoftdemo.esoft.demo.models.Demand;
import whoscared.esoftdemo.esoft.demo.models.immovables.RealEstate;
import whoscared.esoftdemo.esoft.demo.models.offer.Offer;
import whoscared.esoftdemo.esoft.demo.models.people.Client;
import whoscared.esoftdemo.esoft.demo.models.people.Realtor;
import whoscared.esoftdemo.esoft.demo.repositories.OfferRepository;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    public Offer findByClient(Client client) {
        return offerRepository.findByClient(client);
    }

    public Offer findByRealtor(Realtor realtor) {
        return offerRepository.findByRealtor(realtor);
    }

    public List<Offer> findWithoutDeal() {
        return findAll().stream().filter(x -> x.getDeal() == null).toList();
    }

    public List<Offer> findByDemand(Demand demand) {
        List<Offer> allOffer = findAll();
        allOffer = allOffer.stream().filter(x -> x.getRealEstate().getTypeOfRealEstate() == demand.getTypeOfRealEstate()).toList();
        allOffer = allOffer.stream()
                .filter(x -> x.getRealEstate().getAddress().getCity() == null
                        || x.getRealEstate().getAddress().getCity().equals(demand.getAddress().getCity()))
                .filter(x -> x.getRealEstate().getAddress().getStreet() == null
                        || x.getRealEstate().getAddress().getStreet().equals(demand.getAddress().getStreet()))
                .filter(x -> x.getRealEstate().getAddress().getHouse() == null
                        || x.getRealEstate().getAddress().getHouse().equals(demand.getAddress().getHouse()))
                .filter(x -> x.getRealEstate().getArea() >= demand.getMinArea() && x.getRealEstate().getArea() <= demand.getMaxArea())
                .filter(x -> x.getRealEstate().getRooms() >= demand.getMinRoom() && x.getRealEstate().getRooms() <= demand.getMaxRoom())
                .filter(x -> x.getRealEstate().getFloor() >= demand.getMinFloat() && x.getRealEstate().getFloor() <= demand.getMaxFloat())
                .toList();
        return allOffer;
    }

    public void save(Offer offer) {
        offerRepository.save(offer);
    }
}
