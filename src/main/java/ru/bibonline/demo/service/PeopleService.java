package ru.bibonline.demo.service;

import org.springframework.stereotype.Service;
import ru.bibonline.demo.entity.PeopleEntity;
import ru.bibonline.demo.repo.PeopleRepository;

import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepository repo;
    public PeopleService(PeopleRepository repo){
        this.repo = repo;
    }
    public void save(PeopleEntity people){repo.save((people));}

    public void delete(Long id) {
        repo.deleteById(id);}

    public Iterable<PeopleEntity> getAll(){return  repo.findAll();}


    public Optional<PeopleEntity> byId(Long id){
        return repo.findById(id);
    }
}
