package com.consultafipe.consultorFipe.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// Classe Record responsável para modelar dados para melhor execução do sistema.
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(@JsonAlias("TipoVeiculo") String tipoVeiculo,
                           @JsonAlias("Valor") String valor,
                           @JsonAlias("Marca") String marca,
                           @JsonAlias("Modelo") String modelo,
                           @JsonAlias("AnoModelo") String anoModelo,
                           @JsonAlias("Combustivel") String combustivel,
                           @JsonAlias("CodigoFipe") String codigoFipel,
                           @JsonAlias("MesReferencia") String mesReferencia,
                           @JsonAlias("SiglaCombustivel") String siglaCombustivel){
    @Override
    public String toString() {
        // retorna texto modelado confrome necessário.
        return "\n\nDadosVeiculo: " +
                "Valor=" + valor +
                ", Marca=" + marca +
                ", Modelo=" + modelo +
                ", Ano do modelo=" + anoModelo +
                ", Combustivel=" + combustivel +
                ", Código Fipe=" + codigoFipel +
                ", Mês de referência=" + mesReferencia +
                ", Combustivel=" + siglaCombustivel;
    }
}