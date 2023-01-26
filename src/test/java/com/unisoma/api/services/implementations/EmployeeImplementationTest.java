package com.unisoma.api.services.implementations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unisoma.api.models.AddressModel;
import com.unisoma.api.models.EmployeeModel;
import com.unisoma.api.models.dtos.EmployeeDTO;
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
        void testRegisterEmployee_Success() {
                EmployeeModel employee = MODEL;
                when(employeeRepository.existsByCpf(CPF)).thenReturn(false);
                when(employeeRepository.save(employee)).thenReturn(employee);
                when(addressRepository.save(employee.getEndereco())).thenReturn(employee.getEndereco());
                String result = employeeImplementation.registerEmployee(employee);
                assertEquals("Funcionário Registrado", result);
        }

        @Test
        @DisplayName("Cadastro de funcionário com CPF já cadastrado")
        void testRegisterEmployeeWithCpfAlreadyRegistered() {
                EmployeeModel employee = MODEL;
                when(employeeRepository.existsByCpf(CPF)).thenReturn(true);
                String result = employeeImplementation.registerEmployee(employee);
                assertEquals("Funcionário já cadastrado", result);
        }

        @Test
        @DisplayName("Atualização de funcionário com sucesso")
        void testUpdateEmployee_Success() {
                EmployeeModel employeeOld = MODEL;
                EmployeeModel employeeNew = MODEL;
                when(employeeRepository.existsByCpf(CPF)).thenReturn(true);
                when(employeeRepository.findByCpf(CPF)).thenReturn(employeeOld);
                when(employeeRepository.save(employeeNew)).thenReturn(employeeNew);
                when(addressRepository.save(employeeNew.getEndereco())).thenReturn(employeeNew.getEndereco());
                String result = (String) employeeImplementation.updateEmployeeByCpf(employeeNew.getCpf(), employeeNew);
                assertEquals("Funcionário Atualizado", result);
        }

        @Test
        @DisplayName("Atualização de funcionário com CPF não cadastrado")
        void testUpdateEmployeeWithCpfNotRegistered_NotFound() {
                EmployeeModel employee = MODEL;
                when(employeeRepository.existsByCpf(CPF)).thenReturn(false);
                String result = (String) employeeImplementation.updateEmployeeByCpf(employee.getCpf(), employee);
                assertEquals("Funcionário não encontrado", result);
        }

        @Test
        @DisplayName("Listar todos os funcionários")
        void testFindAll() {

                List<EmployeeModel> employees = new ArrayList<>();
                employees.add(MODEL);
                when(employeeRepository.findAll()).thenReturn(employees);
                List<EmployeeDTO> result = (List<EmployeeDTO>) employeeImplementation.findAll();
                assertEquals(employees.size(), result.size());
        }

        @Test
        @DisplayName("Calcular aumento de salário com sucesso")
        void testAdjustmentSalary_Success() {
                EmployeeModel employee = MODEL;
                when(employeeRepository.existsByCpf(CPF)).thenReturn(true);
                when(employeeRepository.findByCpf(CPF)).thenReturn(employee);
                when(employeeRepository.save(employee)).thenReturn(employee);
                Object result = employeeImplementation.adjustmentSalary(employee.getCpf());
                assertEquals("AdjustmentSalaryDTO(cpf=123.456.789-10, salario=R$ 1412,40, ganho=R$ 92,40, percentual=7%)",
                                result.toString());
        }

        @Test
        @DisplayName("Calcular aumento de salário com CPF não cadastrado")
        void testAdjustmentSalaryWithCpfNotRegistered_NotFound() {
                EmployeeModel employee = MODEL;
                when(employeeRepository.existsByCpf(CPF)).thenReturn(false);
                Object result = employeeImplementation.adjustmentSalary(employee.getCpf());
                assertEquals("Funcionário não encontrado", result);
        }

        @Test
        @DisplayName("Calcular Imposto de Renda com sucesso")
        void testCalculateIncomeTax_Success() {
                EmployeeModel employee = MODEL;
                when(employeeRepository.existsByCpf(CPF)).thenReturn(true);
                when(employeeRepository.findByCpf(CPF)).thenReturn(employee);
                Object result = employeeImplementation.incomeTax(employee.getCpf());
                assertEquals("IncomeTaxDTO(cpf=123.456.789-10, imposto=Isento)", result.toString());
        }

        @Test
        @DisplayName("Calcular Imposto de Renda com CPF não cadastrado")
        void testCalculateIncomeTaxWithCpfNotRegistered_NotFound() {
                EmployeeModel employee = MODEL;
                when(employeeRepository.existsByCpf(CPF)).thenReturn(false);
                Object result = employeeImplementation.incomeTax(employee.getCpf());
                assertEquals("Funcionário não encontrado", result);
        }
}
