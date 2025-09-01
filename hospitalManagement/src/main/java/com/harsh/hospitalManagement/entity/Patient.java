package com.harsh.hospitalManagement.entity;

import com.harsh.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString //will provide toString method for all the fields.
@Getter
@Setter
@Table(
        name="patient",
        uniqueConstraints = {
//                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name", "birthDate"})
        },
        indexes = {
                @Index(name =  "idx_patient_birth_date", columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //will generate value on auto incremented db columns
    private Long id;

//    @Column(name = "patient_name", nullable = false, length = 40) //by this it will update the column name from name to patient_name
    @Column(nullable = false, length = 40)
    private String name;

    @ToString.Exclude //will exclude this variable in toString method
    private LocalDate birthDate;

    @Column(unique = true, nullable = false) //using this annotation we do not need to explicitly declare this container as unique
    private String email;

    private String gender;

    @CreationTimestamp //it will fill it with the time of its creation
    @Column(updatable = false) //not mandatory because we have already used the annotation @CreationTimestamp
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

//    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}) //Merge cascade is used when we are updating smth, while Persist comes under when we save first time.
    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id") //this helps to alter the name of column
    //in simple words jidhar @JoinColumn rhega wo side owning side bnn jaega auur whi foreign key laega
    //dono side owning side nai ho skti ek Owning side or ek Inverse side hogi wrna ambiguity aa jaegi jisse hm 2 source of truth keh ske hai
    private Insurance insurance;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.EAGER) //bi directional mapping
//    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>(); //inverse side

}
