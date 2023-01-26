package com.unisoma.api.controllers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.unisoma.api.services.implementations.EmployeeImplementation;

@ExtendWith(MockitoExtension.class)
public class SalaryControllerTest {

    @InjectMocks
    private SalaryController salaryController;

    @Mock
    private EmployeeImplementation employeeImplementation;

    @Test
    public void testDefaultMessageAdjustmentSalary() {
        ResponseEntity<Object> response = salaryController.defaultMessageAdjustmentSalary();
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Informe o CPF do funcionário para saber o valor do reajuste salarial", response.getBody());
    }

    @Test
    public void testDefaultMessageIncomeTax() {
        ResponseEntity<Object> response = salaryController.defaultMessageIncomeTax();
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Informe o CPF do funcionário para saber o valor do imposto de renda", response.getBody());
    }

    @Test
    public void testGetAdjustmentSalary() {
        String cpf = "123.456.789-09";
        when(employeeImplementation.adjustmentSalary(cpf)).thenReturn("Valor do reajuste: R$1000,00");
        ResponseEntity<Object> response = salaryController.getAdjustmentSalary(cpf);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Valor do reajuste: R$1000,00", response.getBody());
    }

    @Test
    public void testGetIncomeTax() {
        String cpf = "123.456.789-09";
        when(employeeImplementation.incomeTax(cpf)).thenReturn("Valor do imposto de renda: R$500,00");
        ResponseEntity<Object> response = salaryController.getIncomeTax(cpf);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Valor do imposto de renda: R$500,00", response.getBody());
    }
}
