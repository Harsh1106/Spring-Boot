package com.harsh.hospitalManagement.service;

import com.harsh.hospitalManagement.entity.Appointment;
import com.harsh.hospitalManagement.entity.Doctor;
import com.harsh.hospitalManagement.entity.Patient;
import com.harsh.hospitalManagement.repository.AppointmentRepository;
import com.harsh.hospitalManagement.repository.DoctorRepository;
import com.harsh.hospitalManagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not be there");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment); //to maintain bidirectional mapping

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); //this will automatically call the update, because it is dirty

        doctor.getAppointments().add(appointment); //just for bidirectional consistency

        return appointment;
    }
}
