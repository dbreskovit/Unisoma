package com.unisoma.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisoma.api.models.AddressModel;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, UUID> {

    void deleteById(UUID id);

}
