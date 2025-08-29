package com.harsh.springdatajpaex.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@Component
@Scope("prototype")
@ToString
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private int rollNo;
    private String name;
    private int marks;
}
