package com.ferelml34.services;

import com.ferelml34.models.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> listAll();
    Employee save(Employee employee);
    Employee findById(Integer id);
    void delete(Employee employee);
    boolean existsById(Integer id);
}
