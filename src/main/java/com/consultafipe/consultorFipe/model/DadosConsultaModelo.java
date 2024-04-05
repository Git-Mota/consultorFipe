package com.consultafipe.consultorFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosConsultaModelo(@JsonAlias("codigo") String codigo,
                                  @JsonAlias("nome") String Nome){
    @Override
    public String toString() {
        return "\nCódigo= " + codigo +
               " | Nome= " + Nome;
    }
}



