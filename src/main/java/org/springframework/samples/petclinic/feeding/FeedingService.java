package org.springframework.samples.petclinic.feeding;

import java.util.List;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedingService {
    @Autowired
    FeedingRepository feedingRepository;
    public List<Feeding> getAll(){
        return feedingRepository.findAll();
    }

    public List<FeedingType> getAllFeedingTypes(){
        return feedingRepository.findAllFeedingTypes();
    }

    public FeedingType getFeedingType(String typeName) {
        return feedingRepository.findFeedingTypesByName(typeName);
    }

    @Transactional
    public Feeding save(Feeding p) throws UnfeasibleFeedingException {
        if(p.getPet().getType() == p.getFeedingType().getPetType()){
            return feedingRepository.save(p);   
        }
        throw new UnfeasibleFeedingException();
    }

    
}
