package com.unisoma.api.models.dtos.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IncomeTaxDTOTest {

    @Test
    public void testIncomeTaxDTO() {
        IncomeTaxDTO incomeTaxDTO = new IncomeTaxDTO();
        incomeTaxDTO.setCpf("12345678910");
        incomeTaxDTO.setImposto("R$ 1000,00");
        assertEquals("12345678910", incomeTaxDTO.getCpf());
        assertEquals("R$ 1000,00", incomeTaxDTO.getImposto());
    }

    @Test
    public void testGetCpf() {
        IncomeTaxDTO incomeTaxDTO = new IncomeTaxDTO();
        incomeTaxDTO.setCpf("12345678910");
        assertEquals("12345678910", incomeTaxDTO.getCpf());
    }

    @Test
    public void testSetCpf() {
        IncomeTaxDTO incomeTaxDTO = new IncomeTaxDTO();
        incomeTaxDTO.setCpf("12345678910");
        assertEquals("12345678910", incomeTaxDTO.getCpf());
    }

    @Test
    public void testGetImposto() {
        IncomeTaxDTO incomeTaxDTO = new IncomeTaxDTO();
        incomeTaxDTO.setImposto("R$ 1000,00");
        assertEquals("R$ 1000,00", incomeTaxDTO.getImposto());
    }

}
