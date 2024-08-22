package com.ferelml34.controllers;

import com.ferelml34.models.dto.EmployeeDto;
import com.ferelml34.models.entities.Employee;
import com.ferelml34.models.payload.ResponseMessage;
import com.ferelml34.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("employees")
    public ResponseEntity<?> getEmployees() {
        List<Employee> employees = this.employeeService.listAll();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(
                    ResponseMessage.builder()
                            .message("No records")
                            .data(null)
                            .build(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(
                ResponseMessage.builder()
                        .message("Fetched succesfully")
                        .data(employees)
                        .build(),
                HttpStatus.OK
        );
    }

    @PostMapping("employee")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto) {
    try {
        Employee employeeSave = this.employeeService.save(employeeDto);
        return new ResponseEntity<>(ResponseMessage.builder()
                .message("Employee created successfully")
                .data(EmployeeDto.builder()
                        .name(employeeDto.getName())
                        .email(employeeDto.getEmail())
                        .build()
                )
                .build(), HttpStatus.CREATED);
    }catch (DataAccessException dataAccessException){
return new ResponseEntity<>(ResponseMessage.builder()
        .message(dataAccessException.getMessage())
        .data(null)
        .build()
          , HttpStatus.METHOD_NOT_ALLOWED);
    }
    }



}
