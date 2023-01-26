package com.unisoma.api.models.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeTaxDTO {

    @JsonProperty("CPF")
    private String cpf;

    @JsonProperty("Imposto")
    private String imposto;

}
