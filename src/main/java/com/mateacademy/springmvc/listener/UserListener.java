package com.mateacademy.springmvc.listener;

import com.mateacademy.springmvc.entity.CreatableEntity;

import javax.persistence.PrePersist;
import java.util.Date;

public class UserListener {
    @PrePersist
    public void prePersist(CreatableEntity entity) {
        entity.setCreatedDate(new Date().getTime());
    }
}
