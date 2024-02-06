package ru.bibonline.demo.service;

import org.springframework.stereotype.Service;
import ru.bibonline.demo.entity.PeopleEntity;

import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleService repo;
    public PeopleService(PeopleService repo){
        this.repo = repo;
    }
    public void save(PeopleEntity people){repo.save((people));}
    public void save(Long id){repo.deleteById(id);}

    private void deleteById(Long id) {
    }

    public Iterable<PeopleEntity> getAll(){return  repo.findAll();}

    private Iterable<PeopleEntity> findAll() {
        return null;
    }

    public Optional<PeopleEntity> byId(Long id) {
        return Optional.empty();
    }
}
