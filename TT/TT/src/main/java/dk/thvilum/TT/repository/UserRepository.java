package dk.thvilum.TT.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import dk.thvilum.TT.model.UserEntity;

@Repository
public interface UserRepository extends ListCrudRepository<UserEntity, Integer>{
    
}
