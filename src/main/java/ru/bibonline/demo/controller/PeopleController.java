package ru.bibonline.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bibonline.demo.entity.PeopleEntity;

import ru.bibonline.demo.response.BaseResponse;
import ru.bibonline.demo.response.PeopleListResponse;
import ru.bibonline.demo.response.PeopleResponse;
import ru.bibonline.demo.service.PeopleService;

import java.util.Optional;

@RestController
// говорим что данный класс является контроллером который и возвращает объект, и данные объекта напрямую записываются в HTTP-ответ в виде JSON или XML.
@RequestMapping ("lincast/v1/buro")//используется для мапинга (связывания) с URL для всего класса (или для конкретного метода) обработчика.

public class PeopleController {
    private final PeopleService service;

    public PeopleController(PeopleService service) {
        this.service = service;
    }

    //http://localhost:2825/lincast/v1/buro/all

@GetMapping("/all")
    public ResponseEntity <BaseResponse> getAll(){
        return ResponseEntity.ok(new PeopleListResponse(service.getAll()));
}

@PostMapping("/add")
    public ResponseEntity<BaseResponse> registration(@RequestBody PeopleEntity data){
    try {
        service.save(data);
        return ResponseEntity.ok(new BaseResponse(true,"Человек успешно добавлен в базу!"));
    } catch (Exception e) {
        return ResponseEntity.ok(new BaseResponse(false, e.getMessage()));
    }
}

@GetMapping("/id")
    public ResponseEntity <BaseResponse> getById(@RequestParam Long id){
        Optional <PeopleEntity> people = service.byId(id);

        if (people.isEmpty())
            return ResponseEntity.ok(new BaseResponse(false,"Такой id не найден"));
        else return ResponseEntity.ok(new PeopleResponse(true, "Найденный человек", people.get()));
}

@PostMapping("/update")
    public ResponseEntity <BaseResponse> update (@RequestBody PeopleEntity people){
        try {
            service.save(people);
            return ResponseEntity.ok(new BaseResponse(true, "В бюро сохранены изменения."));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

@DeleteMapping("/del")
    public ResponseEntity <BaseResponse> delById(@RequestParam Long id){
        service.delete(id);
        return ResponseEntity.ok(new BaseResponse(false,"Человек удален из базы."));
}
}
