package com.harsh.restapi.LearningRESTAPIs.service.impl;

import com.harsh.restapi.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.harsh.restapi.LearningRESTAPIs.dto.StudentDto;
import com.harsh.restapi.LearningRESTAPIs.entity.Student;
import com.harsh.restapi.LearningRESTAPIs.repository.StudentRepository;
import com.harsh.restapi.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor //-> this will generate a default constructor for private fields
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper; //to use the @RequiredArgsConstructor the field variable should be private

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));
        return modelMapper.map(student, StudentDto.class); //auto converts the Student object to StudentDto
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentByid(Long id) {
        if(!studentRepository.existsById(id))
            throw new IllegalArgumentException("Student does not exist by id: "+id);
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));
        modelMapper.map(addStudentRequestDto, student); //we can insert either the class name or the object
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));
        updates.forEach((field, value) ->{
            switch (field){
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default: throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }

}
