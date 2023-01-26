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
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_EMPLOYEES")
@Data
@NoArgsConstructor
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
    private double salario;

    public EmployeeModel(String nome, String cpf, String dataNasc,
            String telefone, AddressModel endereco, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        this.endereco = endereco;
        this.salario = salario;
    }

    public EmployeeDTO converterToDTO() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        AddressModel addressModel = this.getEndereco();
        AddressDTO addressDTO = new AddressDTO();
        BeanUtils.copyProperties(addressModel, addressDTO);
        BeanUtils.copyProperties(this, employeeDTO);
        employeeDTO.setEndereco(addressDTO);
        employeeDTO.setSalario(Math.round((employeeDTO.getSalario() * 100) / 100));
        return employeeDTO;
    }

    public static EmployeeModel converterToModel(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel = new EmployeeModel();
        AddressDTO addressDTO = employeeDTO.getEndereco();
        AddressModel addressModel = new AddressModel();
        BeanUtils.copyProperties(addressDTO, addressModel);
        BeanUtils.copyProperties(employeeDTO, employeeModel);
        employeeModel.setEndereco(addressModel);
        return employeeModel;
    }

}