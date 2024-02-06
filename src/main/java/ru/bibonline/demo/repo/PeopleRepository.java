package ru.bibonline.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.bibonline.demo.entity.PeopleEntity;

import java.util.List;

public interface PeopleRepository extends CrudRepository<PeopleEntity, Long> {
  /*  List<PeopleEntity> findByLastName(String lastName);
    PeopleEntity findById(long id);*/
}
