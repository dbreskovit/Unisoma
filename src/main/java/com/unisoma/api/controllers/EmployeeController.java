package com.unisoma.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unisoma.api.models.EmployeeModel;
import com.unisoma.api.models.dtos.EmployeeDTO;
import com.unisoma.api.services.implementations.EmployeeImplementation;
import com.unisoma.api.util.Validation;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/funcionario")
public class EmployeeController {

    @Autowired
    EmployeeImplementation employeeImplementation;

    @PostMapping(value = { "", "cadastrar" })
    public ResponseEntity<Object> registerEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeImplementation.registerEmployee(EmployeeModel.converterToModel(employeeDTO)));
    }

    @GetMapping(value = { "", "listar" })
    public ResponseEntity<Object> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeImplementation.findAll());
    }

    @GetMapping(value = { "{cpf}", "buscar/{cpf}" })
    public ResponseEntity<Object> getEmployeeByCpf(@PathVariable String cpf) {
        if (Validation.isCPF(cpf))
            cpf = Validation.formatCPF(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(employeeImplementation.findByCpf(cpf));
    }

    @PutMapping(value = { "/{cpf}", "atualizar/{cpf}" })
    public ResponseEntity<Object> updateEmployeeByCpf(@PathVariable String cpf,
            @RequestBody @Valid EmployeeDTO employeeDTO) {
        if (Validation.isCPF(cpf))
            cpf = Validation.formatCPF(cpf);
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeImplementation.updateEmployeeByCpf(cpf, EmployeeModel.converterToModel(employeeDTO)));
    }

    @DeleteMapping(value = { "/{cpf}", "dispensar/{cpf}" })
    public ResponseEntity<Object> deleteEmployeeByCpf(@PathVariable String cpf) {
        if (Validation.isCPF(cpf))
            cpf = Validation.formatCPF(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(employeeImplementation.deleteEmployeeByCpf(cpf));
    }

}