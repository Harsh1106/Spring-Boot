package com.harsh.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToOne //Department owns relationships because department has the join column
//    JoinColumn annotation is not mandatory to specify always
    private Doctor headDoctor;

    @ManyToMany //when we establish this type of relationships then hibernate by default create join table for both the tables
    @JoinTable(name = "my_dpt_doctors", joinColumns = @JoinColumn(name = "dpt_id"), inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private Set<Doctor> doctors = new HashSet<>();
}
