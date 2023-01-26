package com.unisoma.api.controllers;

import com.unisoma.api.services.implementations.EmployeeImplementation;
import com.unisoma.api.util.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class SalaryController {

    @Autowired
    EmployeeImplementation employeeImplementation;

    @GetMapping(value = { "aumento", "funcionario/aumento" })
    public ResponseEntity<Object> defaultMessageAdjustmentSalary() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Informe o CPF do funcionário para saber o valor do reajuste salarial");
    }

    @GetMapping(value = { "imposto", "funcionario/imposto" })
    public ResponseEntity<Object> defaultMessageIncomeTax() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Informe o CPF do funcionário para saber o valor do imposto de renda");
    }

    @GetMapping(value = { "aumento/{cpf}", "funcionario/aumento/{cpf}" })
    public ResponseEntity<Object> getAdjustmentSalary(@PathVariable String cpf) {
        if (Validation.isCPF(cpf))
            cpf = Validation.formatCPF(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(employeeImplementation.adjustmentSalary(cpf));
    }

    @GetMapping(value = { "imposto/{cpf}", "funcionario/imposto/{cpf}" })
    public ResponseEntity<Object> getIncomeTax(@PathVariable String cpf) {
        if (Validation.isCPF(cpf))
            cpf = Validation.formatCPF(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(employeeImplementation.incomeTax(cpf));
    }

}
