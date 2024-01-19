package dk.thvilum.TT.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import dk.thvilum.TT.model.CustomerEntity;

@Repository
public interface CustomerRepository extends ListCrudRepository<CustomerEntity, Integer>{
    
}
