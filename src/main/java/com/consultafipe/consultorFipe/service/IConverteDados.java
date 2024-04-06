package com.consultafipe.consultorFipe.service;

public interface IConverteDados {
    // Classe responsável por receber dados genéricos e transforma-los de acordo com o tipoo e classe desejada.
    <T> T  obterDados(String json, Class<T> classe);
}
