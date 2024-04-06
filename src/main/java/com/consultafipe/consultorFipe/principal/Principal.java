package com.consultafipe.consultorFipe.principal;

import com.consultafipe.consultorFipe.model.*;
import com.consultafipe.consultorFipe.service.ConsumoApi;
import com.consultafipe.consultorFipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/"; // URL modelo da API.
    static String enderecoEditavel = ENDERECO; // URL que receberá alterações.
    Scanner leitura = new Scanner(System.in);
    static ConsumoApi consumo = new ConsumoApi();
    static ConverteDados conversor = new ConverteDados();
    public void exibirMenu () throws InterruptedException {
        //bloco responsável por interagir com o usr e chamar metódos.
        while (true) {
            try {

                // loop para manter exibindo informações.
                System.out.println("\nDigite '1' para carros,'2' para motos ou '3' para caminhões.");
                int tipoVeiculo = leitura.nextInt();
                if (tipoVeiculo == 1 || tipoVeiculo == 2 || tipoVeiculo == 3) {

                    System.out.println("Gerando lista de marcas...");
                    pesquisaMarca(retornaTipoVeiculo(tipoVeiculo));

                    System.out.println("Digite o código da marca desejada:");
                    int codMarca = leitura.nextInt();
                    System.out.println("Gerando lista de modelos...");
                    pesquisaModelos(codMarca);

                    System.out.println("Digite o código do modelo desejado:");
                    int codModelo = leitura.nextInt();
                    System.out.println("Gerando informações...");
                    dadosVeiculo(codModelo);

                } else {
                    System.out.println("Número inválido, tente novamente.");
                }
            }catch (Exception ex){
                System.out.println("Erro: "+ ex);
            }
        }
    }
    public static String retornaTipoVeiculo(int recebeTipoVeiculo){
        // bloco responsável por editar conforme necessário e restaurar a URL da API.
        switch (recebeTipoVeiculo){
            case 1:
                enderecoEditavel = ENDERECO;
                enderecoEditavel = enderecoEditavel + "carros/marcas";
                return enderecoEditavel;
            case 2:
                enderecoEditavel = ENDERECO;
                enderecoEditavel = enderecoEditavel + "motos/marcas";
                return enderecoEditavel;
            case 3:
                enderecoEditavel = ENDERECO;
                enderecoEditavel = enderecoEditavel + "caminhoes/marcas";
                return enderecoEditavel;
        }
        return null;
    }
    public static void pesquisaMarca(String recebeEnd){
        // Bloco responsável por consultar e imprmir marcas.
        var json = consumo.obterDados(recebeEnd); // Consulta e retorna json da API.

        List<ModeloPesquisa> pesquisa = new ArrayList<>();
        ModeloPesquisa[] dadosPesquisa = conversor.obterDados(json, ModeloPesquisa[].class); // Converte e modela dados json para o tipo da classe dejada.
        Collections.addAll(pesquisa, dadosPesquisa); // Adiciona dados convertidos em uma Lista do tipo "ModeloPesquisa".
        System.out.println(pesquisa);
    }
    public static void pesquisaModelos(int recTipoVeiculo){
        //Bloco responável por consultar e impimir modelos.

        enderecoEditavel = enderecoEditavel+"/"+recTipoVeiculo+"/modelos"; //Modelagem da URL para API.
        var json = consumo.obterDados(enderecoEditavel); // Consulta API

        List<ModeloPesquisa> pesquisa = new ArrayList<>();
        ModeloPesquisa dadosPesquisa = conversor.obterDados(json,ModeloPesquisa.class); // Converte e modela dados json para o tipo da classe dejada.
        pesquisa.add(dadosPesquisa);// Adiciona dados convertidos em uma Lista do tipo "ModeloPesquisa".

        pesquisa = pesquisa.stream()
                .flatMap( t -> t.modelos().stream())
                .collect(Collectors.toList());
        // Nesse caso, utilizei o stream e flatmap para mapear a classe ModeloPesquisa tento em vista que nessa consulta à API não é retornado um Array genérico.
        System.out.println(pesquisa);
    }
    public void dadosVeiculo(int codModelo){
        // Bloco responsável por consultaras os anos do veículo e adicionar as informações do veículo de cada ano em forma de lista.
        enderecoEditavel = enderecoEditavel + "/"+ codModelo+"/anos"; //Modelagem da URL para API.
        var json = consumo.obterDados(enderecoEditavel);// Consulta API e obtem anos do veículo.
        ModeloPesquisa[] dadosPesquisa = conversor.obterDados(json, ModeloPesquisa[].class); // Converte e modela dados json para o tipo da classe dejada.

        List<DadosVeiculo> dadosVeiculo = new ArrayList<>();
        for (ModeloPesquisa m : dadosPesquisa){ // Para cada elemento da coleção ano disponível.
            String veiculoJson = consumo.obterDados(enderecoEditavel+"/"+m.codigo()); //Retorna dados do veículo de acordo com o ano do índice.
            DadosVeiculo dados = conversor.obterDados(veiculoJson, DadosVeiculo.class); // Converte e modela dados json para o tipo da classe dejada.
            dadosVeiculo.add(dados); // Adiciona dados do veículo em uma forma de ano, sendo cada ano um índice com suas respectivas informações.
        }
        System.out.println(dadosVeiculo);
    }
}

