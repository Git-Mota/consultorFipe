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
    private static final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    static String enderecoEditavel = ENDERECO;
    Scanner leitura = new Scanner(System.in);
    static ConsumoApi consumo = new ConsumoApi();
    static ConverteDados conversor = new ConverteDados();
    public void exibirMenu () throws InterruptedException {


        System.out.println("Digite '1' para carros,'2' para motos ou '3' para caminhões.");
        int tipoVeiculo = leitura.nextInt();
        if (tipoVeiculo == 1 || tipoVeiculo == 2 || tipoVeiculo == 3) {

            System.out.println("Gerando lista de marcas...");
            pesquisaMarca(retornaPesquisaTipoVeiculo(tipoVeiculo));

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
    }
    public static String retornaPesquisaTipoVeiculo(int recebeTipoVeiculo){
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


        var json = consumo.obterDados(recebeEnd);

        List<ModeloPesquisa> pesquisa = new ArrayList<>();
        ModeloPesquisa[] dadosPesquisa = conversor.obterDados(json, ModeloPesquisa[].class);
        Collections.addAll(pesquisa, dadosPesquisa);
        System.out.println(pesquisa);
    }
    public static void pesquisaModelos(int recTipoVeiculo){

        enderecoEditavel = enderecoEditavel+"/"+recTipoVeiculo+"/modelos";

        var json = consumo.obterDados(enderecoEditavel);

        List<ModeloPesquisa> pesquisa = new ArrayList<>();
        ModeloPesquisa dadosPesquisa = conversor.obterDados(json,ModeloPesquisa.class);
        pesquisa.add(dadosPesquisa);

        pesquisa = pesquisa.stream()
                .flatMap( t -> t.modelos().stream())
                .collect(Collectors.toList());
        System.out.println(pesquisa);
    }
    public void dadosVeiculo(int codModelo){

        enderecoEditavel = enderecoEditavel + "/"+ codModelo+"/anos";
        var json = consumo.obterDados(enderecoEditavel);
        ModeloPesquisa[] dadosPesquisa = conversor.obterDados(json, ModeloPesquisa[].class);

        List<DadosVeiculo> dadosVeiculo = new ArrayList<>();
        for (ModeloPesquisa m : dadosPesquisa){
            String veiculoJson = consumo.obterDados(enderecoEditavel+"/"+m.codigo());
            DadosVeiculo dados = conversor.obterDados(veiculoJson, DadosVeiculo.class);
            dadosVeiculo.add(dados);
        }
        System.out.println(dadosVeiculo);
    }
}

