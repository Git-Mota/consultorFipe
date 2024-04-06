package com.consultafipe.consultorFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// Classe Record responsável para modelar dados para melhor execução do sistema.
@JsonIgnoreProperties(ignoreUnknown = true)
public record ModeloPesquisa(@JsonAlias("codigo") String codigo,
                             @JsonAlias("nome") String nome,
                             @JsonAlias("modelos")List<ModeloPesquisa> modelos) {
    @Override
    public String toString() {
        // retorna texto modelado confrome necessário.
        return "\nCódigo= " + codigo +
                " | Nome= " + nome;
    }
}
