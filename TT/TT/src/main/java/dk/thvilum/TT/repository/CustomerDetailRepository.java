package dk.thvilum.TT.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import dk.thvilum.TT.model.CustomerDetailEntity;

@Repository
public interface CustomerDetailRepository extends ListCrudRepository<CustomerDetailEntity, Integer>{
    
}
