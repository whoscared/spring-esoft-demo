package whoscared.esoftdemo.esoft.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whoscared.esoftdemo.esoft.demo.models.Deal;
import whoscared.esoftdemo.esoft.demo.repositories.DealRepository;

import java.util.List;

@Service
public class DealService {
    final private DealRepository dealRepository;

    @Autowired
    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public void save (Deal deal){
        dealRepository.save(deal);
    }
    public Deal findById (Long id){
        return dealRepository.findById(id).orElse(null);
    }

    public List<Deal> findAll(){
        return dealRepository.findAll();
    }
}
