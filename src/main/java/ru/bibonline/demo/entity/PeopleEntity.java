package ru.bibonline.demo.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "people")

public class PeopleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                 //уник.номер пользователя
    private int dateRegistration;    //дата регистрации
    private String name;             //Имя
    private String lastName;         //Отчество
    private String surname;          //Фамилия
    private String gender;           //пол
    private String requirements;     //требования
    private String aboutMe;          //о себе
    private String numRegistration;  //регистрационный номер

}
