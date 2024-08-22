package com.ferelml34.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class EmployeeDto implements Serializable {
//    private Integer employeeId;
    private String name;
    private String email;
}
