package com.unisoma.api.models.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotBlank(message = "{nome.not.blank}")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String nome;

    @NotBlank(message = "{cpf.not.blank}")
    @Size(min = 11, max = 14, message = "CPF must have 11 characters")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "{cpf.not.valid}")
    private String cpf;

    @NotBlank(message = "{dataNasc.not.blank}")
    @Size(min = 10, max = 10, message = "Date of birth must have 10 characters")
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$",  message = "{dataNasc.not.valid}")
    private String dataNasc;

    @NotBlank(message = "{telefone.not.blank}")
    @Size(min = 8, max = 20, message = "Phone number must be between 8 and 20 characters")
    @Pattern(regexp = "^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$",  message = "{telefone.not.valid}")
    private String telefone;

    @OneToOne
    @JoinColumn(name = "employee_address_address_id")
    private AddressDTO endereco;

    @NotNull(message = "{salario.not.blank}")
    private double salario;

}