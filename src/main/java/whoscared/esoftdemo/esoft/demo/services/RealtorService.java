package whoscared.esoftdemo.esoft.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whoscared.esoftdemo.esoft.demo.models.Realtor;
import whoscared.esoftdemo.esoft.demo.repositories.RealtorRepository;

import java.util.List;

@Service
public class RealtorService {
    private final RealtorRepository realtorRepository;

    @Autowired
    public RealtorService(RealtorRepository realtorRepository) {
        this.realtorRepository = realtorRepository;
    }

    public Realtor findById(long id) {
        return realtorRepository.findById(id).orElse(null);
    }

    public List<Realtor> allRealtors() {
        return realtorRepository.findAll();
    }

    public void save(Realtor realtor) {
        realtorRepository.save(realtor);
    }

    public void update(long id, Realtor realtor) {
        realtor.setId(id);
        realtorRepository.save(realtor);
    }

    public void delete(long id) {
        realtorRepository.deleteById(id);
    }
}
