package com.unisoma.api.models.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressDTOTest {

    @Test
    public void testAddressDTO() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setLogradouro("Rua dos Bobos");
        addressDTO.setNumero("0");
        addressDTO.setComplemento("Sem Complemento");
        addressDTO.setBairro("Bairro dos Bobos");
        addressDTO.setCidade("Cidade dos Bobos");
        addressDTO.setUf("UF dos Bobos");
        addressDTO.setCep("00000000");
        assertEquals("Rua dos Bobos", addressDTO.getLogradouro());
        assertEquals("0", addressDTO.getNumero());
        assertEquals("Sem Complemento", addressDTO.getComplemento());
        assertEquals("Bairro dos Bobos", addressDTO.getBairro());
        assertEquals("Cidade dos Bobos", addressDTO.getCidade());
        assertEquals("UF dos Bobos", addressDTO.getUf());
        assertEquals("00000000", addressDTO.getCep());
    }

    @Test
    public void testGetLogradouro() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setLogradouro("Rua dos Bobos");
        assertEquals("Rua dos Bobos", addressDTO.getLogradouro());
    }

    @Test
    public void testSetLogradouro() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setLogradouro("Rua dos Bobos");
        assertEquals("Rua dos Bobos", addressDTO.getLogradouro());
    }

    @Test
    public void testGetNumero() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setNumero("0");
        assertEquals("0", addressDTO.getNumero());
    }

    @Test
    public void testSetNumero() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setNumero("0");
        assertEquals("0", addressDTO.getNumero());
    }

    @Test
    public void testGetComplemento() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setComplemento("Sem Complemento");
        assertEquals("Sem Complemento", addressDTO.getComplemento());
    }

    @Test
    public void testSetComplemento() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setComplemento("Sem Complemento");
        assertEquals("Sem Complemento", addressDTO.getComplemento());
    }

    @Test
    public void testGetBairro() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setBairro("Bairro dos Bobos");
        assertEquals("Bairro dos Bobos", addressDTO.getBairro());
    }

    @Test
    public void testSetBairro() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setBairro("Bairro dos Bobos");
        assertEquals("Bairro dos Bobos", addressDTO.getBairro());
    }

    @Test
    public void testGetCidade() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCidade("Cidade dos Bobos");
        assertEquals("Cidade dos Bobos", addressDTO.getCidade());
    }

    @Test
    public void testSetCidade() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCidade("Cidade dos Bobos");
        assertEquals("Cidade dos Bobos", addressDTO.getCidade());
    }

    @Test
    public void testGetUf() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setUf("UF dos Bobos");
        assertEquals("UF dos Bobos", addressDTO.getUf());
    }

    @Test
    public void testSetUf() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setUf("UF dos Bobos");
        assertEquals("UF dos Bobos", addressDTO.getUf());
    }

    @Test
    public void testGetCep() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCep("00000000");
        assertEquals("00000000", addressDTO.getCep());
    }

    @Test
    public void testSetCep() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCep("00000000");
        assertEquals("00000000", addressDTO.getCep());
    }

}
