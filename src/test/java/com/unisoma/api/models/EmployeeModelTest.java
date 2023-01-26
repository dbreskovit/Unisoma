package com.unisoma.api.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unisoma.api.models.dtos.AddressDTO;
import com.unisoma.api.models.dtos.EmployeeDTO;

@ExtendWith(MockitoExtension.class)
public class EmployeeModelTest {

    @InjectMocks
    private EmployeeModel employeeModel;

    @Mock
    private AddressModel addressModel;

    @Mock
    private AddressDTO addressDTO;

    @Test
    public void testConverterToDTO() {
        employeeModel.setNome("John Doe");
        employeeModel.setCpf("12345678910");
        employeeModel.setDataNasc("01/01/1990");
        employeeModel.setTelefone("1234567890");
        employeeModel.setEndereco(addressModel);
        employeeModel.setSalario(10000.0);
        EmployeeDTO employeeDTO = employeeModel.converterToDTO();
        assertEquals("John Doe", employeeDTO.getNome());
        assertEquals("12345678910", employeeDTO.getCpf());
        assertEquals("01/01/1990", employeeDTO.getDataNasc());
        assertEquals("1234567890", employeeDTO.getTelefone());
        assertEquals(10000.0, employeeDTO.getSalario());

    }

    @Test
    public void testConverterToModel() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setNome("John Doe");
        employeeDTO.setCpf("12345678910");
        employeeDTO.setDataNasc("01/01/1990");
        employeeDTO.setTelefone("1234567890");
        employeeDTO.setEndereco(addressDTO);
        employeeDTO.setSalario(10000.0);
        employeeModel = EmployeeModel.converterToModel(employeeDTO);
        assertEquals("John Doe", employeeModel.getNome());
        assertEquals("12345678910", employeeModel.getCpf());
        assertEquals("01/01/1990", employeeModel.getDataNasc());
        assertEquals("1234567890", employeeModel.getTelefone());
        assertEquals(10000.0, employeeModel.getSalario());
    }
}
