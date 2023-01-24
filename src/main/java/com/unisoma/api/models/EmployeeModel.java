package com.unisoma.api.models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.unisoma.api.models.dtos.AddressDTO;
import com.unisoma.api.models.dtos.EmployeeDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TB_EMPLOYEES")
public class EmployeeModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String dataNasc;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private AddressModel endereco;

    @Column(nullable = false)
    private int salario;

    public static EmployeeModel converter(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = new EmployeeModel();
        AddressDTO addressDTO = employeeDTO.getEndereco();
        AddressModel addressModel = new AddressModel();
        BeanUtils.copyProperties(employeeDTO, employeeModel);
        BeanUtils.copyProperties(addressDTO, addressModel);
        employeeModel.setEndereco(addressModel);
        return employeeModel;
    }

}