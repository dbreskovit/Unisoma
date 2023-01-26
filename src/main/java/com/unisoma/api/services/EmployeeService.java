package com.unisoma.api.services;

import org.springframework.stereotype.Service;

import com.unisoma.api.models.EmployeeModel;

@Service
public interface EmployeeService {

    String registerEmployee(EmployeeModel employee);

    Object findByCpf(String cpf);

    Object findAll();

    Object updateEmployeeByCpf(String cpf, EmployeeModel employee);

    Object deleteEmployeeByCpf(String cpf);

    Object adjustmentSalary(String cpf);

    Object incomeTax(String cpf);

    boolean verifyCpf(String cpf);

}
