package com.harsh.springbootrest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
