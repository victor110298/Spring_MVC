package com.mateacademy.springmvc.entity;

import com.mateacademy.springmvc.listener.UserListener;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import java.util.Set;

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

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private int active;

    @Email
    @Column(name = "email")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;
}
