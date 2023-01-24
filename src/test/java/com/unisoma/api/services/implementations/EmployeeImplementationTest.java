package com.unisoma.api.services.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unisoma.api.models.AddressModel;
import com.unisoma.api.models.EmployeeModel;
import com.unisoma.api.repositories.AddressRepository;
import com.unisoma.api.repositories.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeImplementationTest {

        @Mock
        private EmployeeRepository employeeRepository;

        @Mock
        private AddressRepository addressRepository;

        @InjectMocks
        private EmployeeImplementation employeeImplementation;

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

        private final EmployeeModel MODEL = new EmployeeModel(NOME, CPF, NASC, TEL,
                        new AddressModel(RUA, NUM, BLOCO, BAIRRO, CIDADE, UF, CEP), SALARIO);

        @Test
        @DisplayName("Cadastro de funcionário com sucesso")
        void test_Register_Employee() {
                EmployeeModel employee = MODEL;
                when(employeeRepository.existsByCpf(CPF)).thenReturn(false);
                when(employeeRepository.save(employee)).thenReturn(employee);
                when(addressRepository.save(employee.getEndereco())).thenReturn(employee.getEndereco());
                String result = employeeImplementation.registerEmployee(employee);
                assertEquals("Funcionário Registrado", result);
        }

        @Test
        @DisplayName("Cadastro de funcionário com CPF já cadastrado")
        void test_Register_Employee_With_Cpf_Already_Registered() {
                EmployeeModel employee = MODEL;
                when(employeeRepository.existsByCpf(CPF)).thenReturn(true);
                String result = employeeImplementation.registerEmployee(employee);
                assertEquals("Funcionário já cadastrado", result);
        }

        @Test
        @DisplayName("Atualização de funcionário com sucesso")
        void test_Update_Employee() {
                EmployeeModel employeeOld = MODEL;
                EmployeeModel employeeNew = MODEL;
                when(employeeRepository.existsByCpf(CPF)).thenReturn(true);
                when(employeeRepository.findByCpf(CPF)).thenReturn(employeeOld);
                when(employeeRepository.save(employeeNew)).thenReturn(employeeNew);
                when(addressRepository.save(employeeNew.getEndereco())).thenReturn(employeeNew.getEndereco());
                String result = (String) employeeImplementation.updateEmployeeByCpf(employeeNew.getCpf(), employeeNew);
                assertEquals("Funcionário Atualizado", result);
        }
}
