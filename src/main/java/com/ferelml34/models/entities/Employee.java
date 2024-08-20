package com.ferelml34.models.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor // void constructor
@ToString
@Builder
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String name;
    private String email;
//    public Employee(Integer employeeId, String name, String email) {
//        this.employeeId = employeeId;
//        this.name = name;
//        this.email = email;
//    } ----- I use AllArgsConstructor Notation instead Employee Constructor
}
