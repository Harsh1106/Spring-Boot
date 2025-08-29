package com.harsh.hospitalManagement;

import com.harsh.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.harsh.hospitalManagement.entity.Patient;
import com.harsh.hospitalManagement.entity.type.BloodGroupType;
import com.harsh.hospitalManagement.repository.PatientRepository;
import com.harsh.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);

//        Patient p1 = new Patient();
//        patientRepository.save(p1);
    }

    @Test
    public void testTransactionMethods(){
//        Patient patient = patientRepository.findByName("Diya Patel");
//        LocalDate birthDate = LocalDate.of(1990, 5, 10);
//        Patient patient = patientRepository.findByBirthDate(birthDate);
//        Optional<Patient> patient = patientRepository.findById(Long.valueOf(7));

//        Patient patientList = patientRepository.findByBirthDateOrEmail(
//                LocalDate.of(1990, 5, 10),
//                "aarav.sharma@example.com"
//        );
//        LocalDate startDate = LocalDate.of(1988, 3, 15);
//        LocalDate endDate = LocalDate.of(1994, 5, 10);

//        List<Patient> patientList = patientRepository.findByBirthDateBetween(startDate, endDate);

//        List<Patient> patientList = patientRepository.findByNameContainingOrderByIdDesc("Di");

//        List<Patient> patientList = patientRepository.findByNameBloodGroup(BloodGroupType.A_POSITIVE);

//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1988, 3, 14));
//        System.out.println(patientList);

//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroup();
//        for(Object[] row : bloodGroupList) {
//            BloodGroupType bloodGroup = (BloodGroupType) row[0];
//            Long count = (Long) row[1];
//            System.out.println(bloodGroup + " " + count);
//        }

//        List<Patient> patientList = patientRepository.findAllPatient();
//        for(Patient patient : patientList){
//            System.out.println(patient);
//        }

//        int rowsUpdated = patientRepository.updateNameWithId("Arav Sharma", 1L);
//        System.out.println(rowsUpdated);
//
//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponse : bloodGroupList){
//            System.out.println(bloodGroupCountResponse);
//        }

        Page<Patient> patientPage = patientRepository.findAllPatient(PageRequest.of(0, 2, Sort.by("name")));
        for(Patient patient : patientPage){
            System.out.println(patient);
        }
    }
}
