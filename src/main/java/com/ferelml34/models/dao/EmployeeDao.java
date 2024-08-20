package com.ferelml34.models.dao;

import com.ferelml34.models.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
