package com.mateacademy.spring_mvc.entity;

import com.mateacademy.spring_mvc.listener.UserListener;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@EntityListeners(value = UserListener.class)
public class CreatableEntity {
    @Column(name = "created_date")
    private Long createdDate;
}
