# Consultor de Tabela Fipe ✨

O Consultor FIPE é um programa Java projetado para fornecer informações detalhadas sobre veículos usando uma API externa. O programa permite aos usuários buscar e visualizar dados sobre carros, motos e caminhões, incluindo marcas disponíveis, modelos associados a cada marca e informações específicas de cada modelo, como anos disponíveis e detalhes técnicos.

## Sumário 📋

1. [Sobre o Projeto](#sobre-o-projeto)
    - [Tecnologias Utilizadas](#tecnologias-utilizadas)
    - [Funcionalidades Principais](#funcionalidades-principais)
2. [Como Executar](#como-executar)
3. [Contribuindo](#contribuindo)
4. [Licença](#licença)

## Sobre o Projeto

O Consultor FIPE é uma aplicação Java desenvolvida no framework Spring Boot com auxilio do Maven, tento como objetivo interagir com uma API externa fornecendo informações detalhadas sobre veículos.Abaixo, ofereço uma descrição técnica das principais classes e bibliotecas utilizadas neste programa:

Classes Principais:

**Principal (Principal.java):**

Esta classe é responsável por controlar a interação com o usuário e o fluxo de execução do programa.
Utiliza instâncias da classe ConsumoApi para realizar requisições à API da FIPE e da classe ConverteDados para converter os dados retornados pela API em objetos Java.

**ConsumoApi (ConsumoApi.java):**

Esta classe encapsula a lógica para realizar chamadas HTTP à API de qualquer tipo e obter os dados correspondentes.
Utiliza a classe HttpClient do pacote java.net.http para fazer requisições HTTP de forma assíncrona.
Retorna os dados obtidos da API no formato de uma string JSON.

**ConverteDados (ConverteDados.java):**

Esta classe é responsável por converter os dados JSON retornados pela API em objetos Java.
Utiliza a biblioteca Jackson, uma popular biblioteca de processamento JSON em Java, para fazer a conversão dos dados.
Implementa métodos para realizar a conversão de uma string JSON para objetos Java de um tipo específico.

**ModeloPesquisa (ModeloPesquisa.java):**

Esta classe é um modelo de dados que representa as informações de marcas e modelos de veículos.
Utiliza a anotação @JsonIgnoreProperties para ignorar propriedades desconhecidas durante a desserialização do JSON.
Implementa um método toString() personalizado para apresentar os dados de forma formatada.


### Tecnologias Utilizadas

**Linguagem de programação Utilizadas:** Java.

**Framework utilizados:** Spring Boot, Maven.

**Bibliotecas Utilizadas:** Jackson (com.fasterxml.jackson), HttpClient (java.net.http).


### Funcionalidades Principais

**Consulta de Marcas e Modelos:** O programa permite aos usuários selecionar o tipo de veículo (carro, moto ou caminhão) e consultar a lista de marcas disponíveis para o tipo selecionado. Em seguida, os usuários podem selecionar uma marca específica e visualizar os modelos associados a essa marca.

**Visualização de Informações Detalhadas:** Após selecionar um modelo de veículo, os usuários podem acessar informações detalhadas, como os anos disponíveis para o modelo selecionado e os detalhes técnicos correspondentes a cada ano.

**Interface Interativa:** O programa apresenta uma interface interativa por meio da linha de comando, onde os usuários podem navegar facilmente pelas opções disponíveis e realizar consultas de forma intuitiva.


## Como Executar

Para executar o arquivo .jar do projeto, certifique-se de ter o JDK 17 instalado em seu sistema. Em seguida, siga estas etapas:

1. Abra o terminal (no Windows, você pode abrir o prompt de comando ou o PowerShell).

2. Pelo prompt navegue até o diretório onde está localizado o arquivo .jar,dentro do repositório, usando o comando `cd`.                  
Por exemplo: 
```
cd  C:\Users\Mario\Documents\consultorFipe\out\artifacts\consultorFipe_jar
```

3. Uma vez dentro do diretório correto, execute o seguinte comando para iniciar a aplicação:
```
java -jar consultorFipe.jar
```

Após executar esse comando, a aplicação deve iniciar normalmente. Certifique-se de que todas as dependências necessárias estão corretamente configuradas e que o arquivo .jar foi está no diretório correto.

<h3>Se preferir você pode carregar, compilar e executar o projeto em uma IDE de preferência.  

## Contribuindo

Instruções para contribuir com o projeto, seja através de sugestões, relatórios de bugs, solicitações de funcionalidades ou até mesmo envio de código.

1. Faça um fork do projeto.
2. Crie uma nova branch (`git checkout -b feature/nova-feature`).
3. Faça commit das suas mudanças (`git commit -am 'Adicione uma nova feature'`).
4. Faça push para a branch (`git push origin feature/nova-feature`).
5. Crie um novo Pull Request.

## Licença

MIT License

Copyright (c) 2024 Evaldo Junior

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
