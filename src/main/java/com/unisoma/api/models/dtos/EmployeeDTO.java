package com.unisoma.api.models.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {

    @NotEmpty(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String nome;

    @NotEmpty(message = "CPF is required")
    @Size(min = 11, max = 14, message = "CPF must have 11 characters")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF must be in the format xxx.xxx.xxx-xx")
    private String cpf;

    @NotNull(message = "Date of birth is required")
    @Size(min = 10, max = 10, message = "Date of birth must have 10 characters")
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Date of birth must be in the format dd/mm/yyyy")
    private String dataNasc;

    @NotEmpty(message = "Phone number is required")
    @Size(min = 8, max = 20, message = "Phone number must be between 8 and 20 characters")
    @Pattern(regexp = "^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$", message = "Phone number must be in the format (xx) xxxx-xxxx or (xx) xxxxx-xxxx")
    private String telefone;

    @OneToOne
    @JoinColumn(name = "employee_address_address_id")
    private AddressDTO endereco;

    @NotNull(message = "Salary is required")
    private double salario;

    public EmployeeDTO() {

    }
}