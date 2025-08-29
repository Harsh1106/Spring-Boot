package com.harsh.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentDate;;

    @Column(length = 500)
    private String reason;

//The Many side is always the owning side because the FK lives in the “many” table.
//Thumb rule: If a table has the FK column, that entity should be the owning side.
    @ManyToOne //owning side
    @JoinColumn(name = "patient_id", nullable = false) //for appointment patient is required that's why it cannot be nullable
    private Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
