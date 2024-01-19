package dk.thvilum.TT.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import dk.thvilum.TT.model.ContactEntity;

@Repository
public interface ContactRepository extends ListCrudRepository<ContactEntity, Integer>{
    
}
