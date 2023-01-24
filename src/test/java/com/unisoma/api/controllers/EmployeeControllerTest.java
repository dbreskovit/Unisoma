package com.unisoma.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.unisoma.api.models.AddressModel;
import com.unisoma.api.models.EmployeeModel;
import com.unisoma.api.models.dtos.AddressDTO;
import com.unisoma.api.models.dtos.EmployeeDTO;
import com.unisoma.api.services.implementations.EmployeeImplementation;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

        @InjectMocks
        EmployeeController employeeController;

        @Mock
        EmployeeImplementation employeeImplementation;

        private static String NOME = "Diego";
        private static String CPF = "123.456.789-10";
        private static String NASC = "25/08/2005";
        private static String TEL = "(55) 99999-9999";
        private static String RUA = " Rua dos Bobos";
        private static String NUM = "101";
        private static String BLOCO = "Bloco A";
        private static String BAIRRO = "Bairro dos Bobos";
        private static String CIDADE = "Cidade dos Bobos";
        private static String UF = "RS";
        private static String CEP = "99999-999";
        private static double SALARIO = 1320;

        private final EmployeeDTO DTO = new EmployeeDTO(NOME, CPF, NASC, TEL,
                        new AddressDTO(RUA, NUM, BLOCO, BAIRRO, CIDADE, UF, CEP), SALARIO);

        private final EmployeeModel MODEL = new EmployeeModel(NOME, CPF, NASC, TEL,
                        new AddressModel(RUA, NUM, BLOCO, BAIRRO, CIDADE, UF, CEP), SALARIO);

        @Test
        @DisplayName("Teste de registro de funcionário")
        public void testRegisterEmployee() {
                EmployeeDTO employeeDTO = DTO;
                EmployeeModel employee = EmployeeModel.converter(employeeDTO);
                when(employeeImplementation.registerEmployee(employee)).thenReturn(String.valueOf(employee));
                ResponseEntity<Object> response = employeeController.registerEmployee(employeeDTO);
                assertEquals(HttpStatus.CREATED, response.getStatusCode());
                verify(employeeImplementation).registerEmployee(employee);
        }

        @Test
        @DisplayName("Teste de registro de funcionário com CPF inválido")
        public void testGetAllEmployees_Success() {
                List<EmployeeModel> employees = new ArrayList<>();
                employees.add(MODEL);
                when(employeeImplementation.findAll()).thenReturn(employees);
                ResponseEntity<Object> response = employeeController.getAllEmployees();
                assertEquals(HttpStatus.OK, response.getStatusCode());
                verify(employeeImplementation).findAll();
        }

        @Test
        @DisplayName("Teste de registro de funcionário com CPF inválido")
        public void testGetEmployeeByCpf_Success() {
                EmployeeModel employee = MODEL;
                when(employeeImplementation.verifyCpf(CPF)).thenReturn(true);
                when(employeeImplementation.findByCpf(CPF)).thenReturn(employee);
                ResponseEntity<Object> response = employeeController.getEmployeeByCpf(CPF);
                assertEquals(HttpStatus.OK, response.getStatusCode());
                assertEquals(employee, response.getBody());
                verify(employeeImplementation).findByCpf(CPF);
        }

        @Test
        @DisplayName("Teste de registro de funcionário com CPF inválido")
        public void testGetEmployeeByCpf_NotFound() {
                when(employeeImplementation.verifyCpf(CPF)).thenReturn(false);
                ResponseEntity<Object> response = employeeController.getEmployeeByCpf(CPF);
                assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
                assertEquals("Funcionário não encontrado", response.getBody());
        }

}