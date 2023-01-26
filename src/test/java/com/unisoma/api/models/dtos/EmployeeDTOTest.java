package com.unisoma.api.models.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeDTOTest {

    @Test
    public void testEmployeeDTO() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setNome("Nome");
        employeeDTO.setCpf("12345678910");
        employeeDTO.setDataNasc("01/01/2000");
        employeeDTO.setTelefone("11 1111-1111");
        employeeDTO.setEndereco(new AddressDTO());
        employeeDTO.setSalario(1000.0);
        assertEquals("Nome", employeeDTO.getNome());
        assertEquals("12345678910", employeeDTO.getCpf());
        assertEquals("01/01/2000", employeeDTO.getDataNasc());
        assertEquals("11 1111-1111", employeeDTO.getTelefone());
        assertEquals(new AddressDTO(), employeeDTO.getEndereco());
        assertEquals(1000.0, employeeDTO.getSalario());
    }

    @Test
    public void testGetNome() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setNome("Nome");
        assertEquals("Nome", employeeDTO.getNome());
    }

    @Test
    public void testSetNome() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setNome("Nome");
        assertEquals("Nome", employeeDTO.getNome());
    }

    @Test
    public void testGetCpf() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCpf("12345678910");
        assertEquals("12345678910", employeeDTO.getCpf());
    }

    @Test
    public void testSetCpf() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setCpf("12345678910");
        assertEquals("12345678910", employeeDTO.getCpf());
    }

    @Test
    public void testGetDataNasc() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDataNasc("01/01/2000");
        assertEquals("01/01/2000", employeeDTO.getDataNasc());
    }

    @Test
    public void testSetDataNasc() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDataNasc("01/01/2000");
        assertEquals("01/01/2000", employeeDTO.getDataNasc());
    }

    @Test
    public void testGetTelefone() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setTelefone("11 1111-1111");
        assertEquals("11 1111-1111", employeeDTO.getTelefone());
    }

    @Test
    public void testSetTelefone() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setTelefone("11 1111-1111");
        assertEquals("11 1111-1111", employeeDTO.getTelefone());
    }

    @Test
    public void testGetEndereco() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEndereco(new AddressDTO());
        assertEquals(new AddressDTO(), employeeDTO.getEndereco());
    }

    @Test
    public void testSetEndereco() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEndereco(new AddressDTO());
        assertEquals(new AddressDTO(), employeeDTO.getEndereco());
    }

    @Test
    public void testGetSalario() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setSalario(1000.0);
        assertEquals(1000.0, employeeDTO.getSalario());
    }

    @Test
    public void testSetSalario() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setSalario(1000.0);
        assertEquals(1000.0, employeeDTO.getSalario());
    }

}
