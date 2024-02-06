package ru.bibonline.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.bibonline.demo.entity.PeopleEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class PeopleListResponse extends BaseResponse{
    public PeopleListResponse(Iterable<PeopleEntity> data){
        super(true, "Люди");
        this.data = data;
    }

    private Iterable<PeopleEntity> data;
}
