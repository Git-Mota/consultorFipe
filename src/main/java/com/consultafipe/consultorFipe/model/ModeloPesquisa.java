package com.consultafipe.consultorFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModeloPesquisa(@JsonAlias("codigo") Integer codigo,
                             @JsonAlias("nome") String nome,
                             @JsonAlias("modelos")List<DadosConsultaModelo> modelos,
                             @JsonAlias ("marcas")List<DadosConsultaMarcas> marcas) {
}
