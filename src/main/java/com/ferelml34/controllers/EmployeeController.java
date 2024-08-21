package com.ferelml34.controllers;

import com.ferelml34.models.entities.Employee;
import com.ferelml34.models.payload.ResponseMessage;
import com.ferelml34.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("employees")
    public ResponseEntity<?> getEmployee() {
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
}
