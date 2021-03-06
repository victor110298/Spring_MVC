package com.mateacademy.springmvc.entity;

import com.mateacademy.springmvc.listener.UserListener;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Setter
@EntityListeners(value = UserListener.class)
public class CreatableEntity {
    @Column(name = "created_date")
    private LocalDate createdDate;
}
