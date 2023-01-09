package whoscared.esoftdemo.esoft.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whoscared.esoftdemo.esoft.demo.models.Demand;
import whoscared.esoftdemo.esoft.demo.repositories.DemandRepository;

import java.util.List;

@Service
public class DemandService {

    private final DemandRepository demandRepository;

    @Autowired
    public DemandService(DemandRepository demandRepository) {
        this.demandRepository = demandRepository;
    }

    public void save(Demand demand) {
        demandRepository.save(demand);
    }

    public List<Demand> findAll() {
        return demandRepository.findAll();
    }

    public Demand findById(Long id) {
        return demandRepository.findById(id).orElse(null);
    }

    public List<Demand> findWithoutDeal() {
        return findAll().stream().filter(x -> x.getDeal() == null).toList();
    }
}
