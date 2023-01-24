package com.unisoma.api.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisoma.api.models.EmployeeModel;
import com.unisoma.api.repositories.AddressRepository;
import com.unisoma.api.repositories.EmployeeRepository;
import com.unisoma.api.services.EmployeeService;

@Service
public class EmployeeImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public String registerEmployee(EmployeeModel employee) {
        if (verifyCpf(employee.getCpf()))
            return "Funcionário já cadastrado";
        employeeRepository.save(employee);
        addressRepository.save(employee.getEndereco());

        return "Funcionário Registrado";
    }

    @Override
    public Object updateEmployeeByCpf(String cpf, EmployeeModel employeeNew) {
        if (verifyCpf(cpf)) {
            EmployeeModel employeeOld = employeeRepository.findByCpf(cpf);
            employeeRepository.deleteById(employeeOld.getId());
            addressRepository.deleteById(employeeOld.getEndereco().getId());
            employeeRepository.save(employeeNew);
            addressRepository.save(employeeNew.getEndereco());
            return "Funcionário Atualizado";
        }
        return "Funcionário não encontrado";
    }

    @Override
    public boolean verifyCpf(String cpf) {
        return employeeRepository.existsByCpf(cpf);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
        addressRepository.deleteAll();
    }

    @Override
    public Object findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Object findByCpf(String cpf) {
        return employeeRepository.findByCpf(cpf);
    }

    public void deleteEmployeeByCpf(String cpf) {
        addressRepository.deleteById(employeeRepository.findByCpf(cpf).getEndereco().getId());
        employeeRepository.deleteById(employeeRepository.findByCpf(cpf).getId());
    }
}
