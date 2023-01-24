package com.unisoma.api.services;

import java.util.UUID;

import com.unisoma.api.models.AddressModel;

public interface AddressService {

    public AddressModel registerAddress(AddressModel addressModel);

    public void deleteAll();

    public void deleteById(UUID id);
}
