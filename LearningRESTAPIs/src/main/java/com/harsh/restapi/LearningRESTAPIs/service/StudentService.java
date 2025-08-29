package com.harsh.restapi.LearningRESTAPIs.service;

import com.harsh.restapi.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.harsh.restapi.LearningRESTAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudent();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentByid(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
