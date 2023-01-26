package com.unisoma.api.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressModelTest {

    @Test
    public void testAddressModel_allArgsConstructor() {
        AddressModel address = new AddressModel("Rua Teste", "123",
                "apto 100", "Bairro Teste", "Cidade Teste", "UF", "12345678");
        assertEquals("Rua Teste", address.getLogradouro());
        assertEquals("123", address.getNumero());
        assertEquals("apto 100", address.getComplemento());
        assertEquals("Bairro Teste", address.getBairro());
        assertEquals("Cidade Teste", address.getCidade());
        assertEquals("UF", address.getUf());
        assertEquals("12345678", address.getCep());
    }

    @Test
    public void testAddressModel_noArgsConstructor() {
        AddressModel address = new AddressModel();
        address.setLogradouro("Rua Teste");
        address.setNumero("123");
        address.setComplemento("apto 100");
        address.setBairro("Bairro Teste");
        address.setCidade("Cidade Teste");
        address.setUf("UF");
        address.setCep("12345678");
        assertEquals("Rua Teste", address.getLogradouro());
        assertEquals("123", address.getNumero());
        assertEquals("apto 100", address.getComplemento());
        assertEquals("Bairro Teste", address.getBairro());
        assertEquals("Cidade Teste", address.getCidade());
        assertEquals("UF", address.getUf());
        assertEquals("12345678", address.getCep());
    }

    @Test
    public void testAddressModel_gettersSetters() {
        AddressModel address = new AddressModel();
        address.setLogradouro("Rua Teste");
        assertEquals("Rua Teste", address.getLogradouro());
        address.setNumero("123");
        assertEquals("123", address.getNumero());
        address.setComplemento("apto 100");
        assertEquals("apto 100", address.getComplemento());
        address.setBairro("Bairro Teste");
        assertEquals("Bairro Teste", address.getBairro());
        address.setCidade("Cidade Teste");
        assertEquals("Cidade Teste", address.getCidade());
        address.setUf("UF");
        assertEquals("UF", address.getUf());
        address.setCep("12345678");
        assertEquals("12345678", address.getCep());
    }

}
