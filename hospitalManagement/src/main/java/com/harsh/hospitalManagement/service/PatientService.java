package com.harsh.hospitalManagement.service;

import com.harsh.hospitalManagement.entity.Patient;
import com.harsh.hospitalManagement.repository.PatientRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id){

        Patient p1 = patientRepository.findById(id).orElseThrow();

        Patient p2 = patientRepository.findById(id).orElseThrow();

        System.out.println(p1 == p2); //true because they are in the same persistence context
        p1.setName("abhi");

//        patientRepository.save(p1); we actually don't need to save it explicitly because it is already in transactional state
//        before completing this method Transactional method it will do a dirty checking(in commit phase) just for getting surety that is there any changes or not
        return p1;
    }


}
