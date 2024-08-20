package com.ferelml34.services.impl;

import com.ferelml34.models.dao.EmployeeDao;
import com.ferelml34.models.dto.EmployeeDto;
import com.ferelml34.models.entities.Employee;
import com.ferelml34.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeImplService implements IEmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> listAll() {
        return (List<Employee>) employeeDao.findAll();
    }

    @Transactional
    @Override
    public Employee save(EmployeeDto employeeDto) {
        Employee employee = Employee.builder()
                .name(employeeDto.getName())
                .email(employeeDto.getEmail())
                .build();
        return employeeDao.save(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }

    @Override
    public boolean existsById(Integer id) {
        return employeeDao.existsById(id);
    }
}
