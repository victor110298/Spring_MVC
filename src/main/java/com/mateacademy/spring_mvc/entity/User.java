package com.mateacademy.spring_mvc.entity;

import com.mateacademy.spring_mvc.listener.UserListener;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Getter
@Setter
@Entity
@EntityListeners(UserListener.class)
@Accessors(chain = true)
@Table(name = "users")
public class User extends CreatableEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Length(min = 2)
    private String name;

    @Column(name = "age")
    @Min(20)
    private Integer age;

    @Email
    @Column(name = "email")
    private String email;

}
