package com.consultafipe.consultorFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModeloPesquisa(@JsonAlias("codigo") String codigo,
                             @JsonAlias("nome") String nome,
                             @JsonAlias("modelos")List<ModeloPesquisa> modelos) {
    @Override
    public String toString() {
        return "\nCódigo= " + codigo +
                " | Nome= " + nome;
    }
}
