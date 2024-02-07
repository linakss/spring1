package ru.bibonline.demo.response;

import com.mysql.cj.jdbc.result.UpdatableResultSet;
import lombok.*;
import ru.bibonline.demo.entity.PeopleEntity;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class PeopleResponse extends BaseResponse{
    private PeopleEntity bd;

    public PeopleResponse(boolean success, String message, PeopleEntity bd) {
        super(success, message);
        this.bd = bd;
    }

}
