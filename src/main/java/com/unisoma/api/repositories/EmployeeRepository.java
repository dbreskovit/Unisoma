package com.unisoma.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unisoma.api.models.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {

    boolean existsByCpf(String cpf);

    EmployeeModel findByCpf(String cpf);
}