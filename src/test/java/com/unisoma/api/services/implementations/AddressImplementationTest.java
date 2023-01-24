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
import com.unisoma.api.repositories.AddressRepository;

@ExtendWith(MockitoExtension.class)
public class AddressImplementationTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressImplementation addressImplementation;

    @Test
    @DisplayName("Cadastro de endereço com sucesso")
    void test_Register_Address() {
        AddressModel address = new AddressModel(" Rua dos Bobos", "101", "Bloco A", "Bairro dos Bobos",
                "Cidade dos Bobos", "RS", "99999-999");
        when(addressRepository.save(address)).thenReturn(address);
        AddressModel result = addressImplementation.registerAddress(address);
        assertEquals(address, result);
    }

}
