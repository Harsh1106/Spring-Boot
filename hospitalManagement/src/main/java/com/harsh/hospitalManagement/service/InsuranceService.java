package com.harsh.hospitalManagement.service;

import com.harsh.hospitalManagement.entity.Insurance;
import com.harsh.hospitalManagement.entity.Patient;
import com.harsh.hospitalManagement.repository.InsuranceRepository;
import com.harsh.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository; //whenever we are using @RequiredArgsConstructor then we have to make objects as final
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("patient not found: " + patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient); //just to insure that bidirectional mapping consistency maintain

        return patient;
    }
}
