package com.unisoma.api.models.dtos.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AdjustmentSalaryDTOTest {

    @Test
    public void testAdjustmentSalaryDTO() {
        AdjustmentSalaryDTO adjustmentSalaryDTO = new AdjustmentSalaryDTO();
        adjustmentSalaryDTO.setCpf("12345678910");
        adjustmentSalaryDTO.setSalario("R$ 1000,00");
        assertEquals("12345678910", adjustmentSalaryDTO.getCpf());
        assertEquals("R$ 1000,00", adjustmentSalaryDTO.getSalario());
    }

    @Test
    public void testGetCpf() {
        AdjustmentSalaryDTO adjustmentSalaryDTO = new AdjustmentSalaryDTO();
        adjustmentSalaryDTO.setCpf("12345678910");
        assertEquals("12345678910", adjustmentSalaryDTO.getCpf());
    }

    @Test
    public void testSetCpf() {
        AdjustmentSalaryDTO adjustmentSalaryDTO = new AdjustmentSalaryDTO();
        adjustmentSalaryDTO.setCpf("12345678910");
        assertEquals("12345678910", adjustmentSalaryDTO.getCpf());
    }

    @Test
    public void testGetSalario() {
        AdjustmentSalaryDTO adjustmentSalaryDTO = new AdjustmentSalaryDTO();
        adjustmentSalaryDTO.setSalario("R$ 1000,00");
        assertEquals("R$ 1000,00", adjustmentSalaryDTO.getSalario());
    }

}
