package com.harsh.hospitalManagement.repository;

import com.harsh.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.harsh.hospitalManagement.entity.Patient;
import com.harsh.hospitalManagement.entity.type.BloodGroupType;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    Patient findByBirthDate(LocalDate birthDate);
    Patient findByBirthDateOrEmail(LocalDate birthDate, String email);
    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);
    List<Patient> findByNameContaining(String query);
    List<Patient> findByNameContainingOrderByIdDesc(String query);

//    Query methods
    @Query("select p from Patient p where p.bloodGroup = ?1") //it's a JPQL not a SQL query
    List<Patient> findByNameBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate") //inside @Query the :birthDate is @Param variable and this is the way to access this @Param
    List<Patient> findByBornAfterDate(@Param("birthDate")LocalDate birthDate);


//    @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroup();
    @Query("SELECT new com.harsh.hospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, COUNT(p)) " +
        "FROM Patient p GROUP BY p.bloodGroup") //this projection query cannot be done with the native query
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Transactional //required in terms of update part
    @Modifying //compulsory in jpql when we are updating the value
    @Query("update Patient p set p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

//    Native Query
//    @Query(value = "select * from patient", nativeQuery = true)
//    List<Patient> findAllPatient();

    //Pagination
    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);


}
