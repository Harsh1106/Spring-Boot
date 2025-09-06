package com.harsh.hospitalManagement.service;

import com.harsh.hospitalManagement.dto.DoctorResponseDto;
import com.harsh.hospitalManagement.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
//    public List<DoctorResponseDto> getAllDoctors() {
////        return doctorRepository.getAllDoctors();
//    }
}
