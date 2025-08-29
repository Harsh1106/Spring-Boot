package com.harsh.hospitalManagement.dto;

import com.harsh.hospitalManagement.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountResponseEntity {
    private BloodGroupType bloodGroupType;
    private Long count;
}
