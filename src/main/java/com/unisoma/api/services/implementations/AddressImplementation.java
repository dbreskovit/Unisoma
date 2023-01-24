package com.unisoma.api.services.implementations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unisoma.api.models.AddressModel;
import com.unisoma.api.repositories.AddressRepository;
import com.unisoma.api.services.AddressService;

@Service
public class AddressImplementation implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public AddressModel registerAddress(AddressModel addressModel) {
        return addressRepository.save(addressModel);
    }

    @Override
    public void deleteAll() {
        addressRepository.deleteAll();
    }

    @Override
    public void deleteById(UUID id) {
        addressRepository.deleteById(id);
    }
}