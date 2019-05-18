package com.mateacademy.spring_mvc.listener;

import com.mateacademy.spring_mvc.entity.CreatableEntity;

import javax.persistence.PrePersist;
import java.util.Date;

public class UserListener {
    @PrePersist
    public void prePersist(CreatableEntity entity) {
        entity.setCreatedDate(new Date().getTime());
    }
}
