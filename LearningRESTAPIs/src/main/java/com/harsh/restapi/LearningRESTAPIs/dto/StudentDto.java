package com.harsh.restapi.LearningRESTAPIs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //this annotation will reduce all the external work such as getter setter and constructor to insert values
@AllArgsConstructor //this annotation will generate parameterized constructor for inserting all the private values.
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;
}
