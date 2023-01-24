package com.unisoma.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unisoma.api.models.EmployeeModel;
import com.unisoma.api.models.dtos.EmployeeDTO;
import com.unisoma.api.services.implementations.EmployeeImplementation;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/funcionario")
public class EmployeeController {

    @Autowired
    EmployeeImplementation employeeImplementation;

    @PostMapping
    public ResponseEntity<Object> registerEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        var employee = EmployeeModel.converter(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeImplementation.registerEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<Object> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeImplementation.findAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> getEmployeeByCpf(@PathVariable String cpf) {
        if (!employeeImplementation.verifyCpf(cpf))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado");
        return ResponseEntity.status(HttpStatus.OK).body(employeeImplementation.findByCpf(cpf));
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAllEmployees() {
        employeeImplementation.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Todos os funcionários foram deletados");
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Object> deleteEmployeeByCpf(@PathVariable String cpf) {
        if (!employeeImplementation.verifyCpf(cpf))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado");
        employeeImplementation.deleteEmployeeByCpf(cpf);
        return ResponseEntity.status(HttpStatus.OK).body("Funcionário deletado");
    }
}