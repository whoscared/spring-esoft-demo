package whoscared.esoftdemo.esoft.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whoscared.esoftdemo.esoft.demo.models.Demand;
import whoscared.esoftdemo.esoft.demo.models.Offer;
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
                // проверяем указан ли город, если да ищем с таким же городом
                .filter(x -> x.getRealEstate().getAddress().getCity() == null
                        || x.getRealEstate().getAddress().getCity().equals(demand.getAddress().getCity()))
                .filter(x -> x.getRealEstate().getAddress().getStreet() == null
                        || x.getRealEstate().getAddress().getStreet().equals(demand.getAddress().getStreet()))
                .filter(x -> x.getRealEstate().getAddress().getHouse() == null
                        || x.getRealEstate().getAddress().getHouse().equals(demand.getAddress().getHouse()))

                .filter(x -> demand.getMinArea() == null || (x.getRealEstate().getArea() != null && x.getRealEstate().getArea() >= demand.getMinArea()))
                .filter(x -> demand.getMaxArea() == null || (x.getRealEstate().getArea() != null && x.getRealEstate().getArea() <= demand.getMaxArea()))

                .filter(x -> demand.getMinRoom() == null || (x.getRealEstate().getRooms() != null && x.getRealEstate().getRooms() >= demand.getMinRoom()))
                .filter(x -> demand.getMaxRoom() == null || (x.getRealEstate().getRooms() != null && x.getRealEstate().getRooms() <= demand.getMaxRoom()))

                .filter(x -> demand.getMinFloat() == null || (x.getRealEstate().getFloor() != null && x.getRealEstate().getFloor() >= demand.getMinFloat()))
                .filter(x -> demand.getMaxFloat() == null || (x.getRealEstate().getFloor() != null && x.getRealEstate().getFloor() <= demand.getMaxFloat()))
                .toList();

        return allOffer;
    }

    public void save(Offer offer) {
        offerRepository.save(offer);
    }
}
