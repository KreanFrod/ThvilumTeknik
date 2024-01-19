package dk.thvilum.TT.controller;

import dk.thvilum.TT.model.UserEntity;
import dk.thvilum.TT.repository.UserRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    
    private final UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }
    
    @GetMapping
    public List<UserEntity> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> findById(@PathVariable Integer id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserEntity not found.")));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Validated @RequestBody UserEntity UserEntity) {
        repository.save(UserEntity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Validated @RequestBody UserEntity UserEntity, @PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UserEntity not found.");
        }
        repository.save(UserEntity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}