package com.unisoma.api.services;

import org.springframework.stereotype.Service;

import com.unisoma.api.models.EmployeeModel;

@Service
public interface EmployeeService {

    public String registerEmployee(EmployeeModel employee);

    Object updateEmployeeByCpf(String cpf, EmployeeModel employee);

    public Object findByCpf(String cpf);

    public Object findAll();

    public boolean verifyCpf(String cpf);

    public void deleteAll();

}
