package ru.bibonline.demo.response;

import lombok.*;
import ru.bibonline.demo.entity.PeopleEntity;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class BaseResponse {
    protected boolean success; //логическое поле, которое будет говорить что запрос прошел (true) или нет (falsh)
    public String message; //сообщение, которое содержит информацию о том что произошло (к примеру, если все плохо, сообщение об ошибке)

}
