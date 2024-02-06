package ru.bibonline.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bibonline.demo.entity.PeopleEntity;
import ru.bibonline.demo.entity.Response;
import ru.bibonline.demo.response.BaseResponse;
import ru.bibonline.demo.response.PeopleListResponse;
import ru.bibonline.demo.service.PeopleService;

import java.util.Optional;

@RestController
// говорим что данный класс является контроллером который и возвращает объект, и данные объекта напрямую записываются в HTTP-ответ в виде JSON или XML.
@RequestMapping ("lincast/v1/buro")//используется для мапинга (связывания) с URL для всего класса (или для конкретного метода) обработчика.
@RequiredArgsConstructor
public class PeopleController {
    private final PeopleService service;

    //http://localhost:2825/lincast/v1/buro/all

@GetMapping("/all")
    public Response <BaseResponse> getAll(){
        return Response.ok(new PeopleListResponse(service.getAll()));
}

@PostMapping("/add")
    public Response <BaseResponse> registration(@RequestBody PeopleEntity data){
    try {
        service.save(data);
        return Response.ok(new BaseResponse(true,"Человек успешно добавлен в базу!"));
    } catch (Exception e) {
        return Response.badRequest().body(new BaseResponse(false, e.getMessage()));
    }
}

@GetMapping("/id")
    public Response <Optional> getById(@RequestParam Long id){
        Optional <PeopleEntity> people = service.byId(id);

        if (people.isEmpty())
            return Response.ok(new BaseResponse(false,"Такой id не найден"));
        else return Response.ok(new BaseResponse(true, "Найденная книга", people.get()));
}

}