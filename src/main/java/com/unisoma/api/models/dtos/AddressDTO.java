package com.unisoma.api.models.dtos;

import com.unisoma.api.models.AddressModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public AddressDTO(AddressModel addressModel) {
        this.logradouro = addressModel.getLogradouro();
        this.numero = addressModel.getNumero();
        this.complemento = addressModel.getComplemento();
        this.bairro = addressModel.getBairro();
        this.cidade = addressModel.getCidade();
        this.uf = addressModel.getUf();
        this.cep = addressModel.getCep();
    }
}