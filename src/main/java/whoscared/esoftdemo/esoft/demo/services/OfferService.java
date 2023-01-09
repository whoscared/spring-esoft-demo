package whoscared.esoftdemo.esoft.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<Offer> findAll (){
        return offerRepository.findAll();
    }

    public Offer findByClient(Client client){
        return offerRepository.findByClient(client);
    }

    public Offer findByRealtor(Realtor realtor){
        return offerRepository.findByRealtor(realtor);
    }

    public List<Offer> findWithoutDeal (){
        return  findAll().stream().filter(x->x.getDeal() == null).toList();
    }

    public void save(Offer offer){
        offerRepository.save(offer);
    }
}
