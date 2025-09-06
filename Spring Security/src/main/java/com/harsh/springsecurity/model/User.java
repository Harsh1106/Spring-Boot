package com.harsh.springsecurity.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name="users")
public class User {
    private int id;
    @Id
    @Column(unique = true)
    private String username;
    private String password;
}
