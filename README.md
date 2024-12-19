# Conversor de Moedas Java com API ExchangeRate-API

Este projeto em Java implementa um conversor de moedas utilizando a API [ExchangeRate-API](https://www.exchangerate-api.com/). Ele permite converter valores entre diversas moedas, consultando as taxas de câmbio em tempo real.

## Funcionalidades

*   Conversão entre diversas moedas (ex: BRL para USD, EUR para BRL, etc.).
*   Consulta de taxas de câmbio atualizadas através da API ExchangeRate-API.
*   Interface de usuário simples via console.
*   Utilização da biblioteca Gson para manipulação de JSON.
*   Tratamento de erros e opções inválidas.
*   Manipulação de entrada e tratamento dos dados por HttpClient, HttpRequest e HttpResponse.

## Pré-requisitos

*   Java Development Kit (JDK) instalado (versão 11 ou superior, devido ao uso do `HttpClient`).
*   Um editor de código ou IDE Java (ex: IntelliJ IDEA, Eclipse, VS Code).
*   Uma chave de API válida da ExchangeRate-API. Você pode obter uma gratuitamente no site deles.

## Como usar

1.  **Clone o repositório:**

    ```bash
    git clone [URL inválido removido]
    ```

2.  **Abra o projeto no seu IDE Java.**

3.  **Substitua a chave da API:** No arquivo `conversorMoedas.java`, substitua o valor da variável `API_KEY` pela sua chave de API:

    ```java
    private static final String API_KEY = "SUA_CHAVE_AQUI"; // Substitua pela sua chave da API
    ```

4.  **Compile e execute o programa:** No seu IDE ou através do terminal com os comandos `javac conversorMoedas.java` e `java conversorMoedas`.

5.  **Interaja com o programa:** O programa exibirá um menu no console. Siga as instruções para escolher as moedas de origem e destino e o valor a ser convertido.

## Exemplo de uso
Seja bem-vindo ao Conversor de Moeda

Escolha somente uma dessas moedas: ARS - Argentina, USD - Dólar, EURO - Europeu, CLP - Peso Chileno, BRL - Real, BOB - Peso Boliviano)

Converter ######################
Sair Escolha uma opção: 1 Digite a moeda de origem (ex: BRL): BRL Digite a moeda de destino (ex: USD): USD Digite o valor a ser convertido: 100 { "moedaOrigem": "BRL", "moedaDestino": "USD", "valor": 100.0, "valorConvertido": 19.23076923076923, }
Converter ######################
Sair Escolha uma opção: 2

## Estrutura do código

*   `conversorMoedas.java`: Contém a lógica principal do conversor, incluindo a comunicação com a API e a manipulação do JSON.

## Dependências

*   **Gson:** Biblioteca para manipulação de JSON. Certifique-se de incluir a dependência no seu projeto. Se você estiver usando Maven, adicione o seguinte ao seu `pom.xml`:

    ```xml
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version> </dependency>
    ```

    Se estiver usando Gradle:

    ```gradle
    implementation 'com.google.code.gson:gson:2.10.1' // Use a versão mais recente
    ```

## Explicação do código

O código utiliza a classe `HttpClient` (introduzida no Java 11) para fazer requisições HTTP para a API ExchangeRate-API. A resposta da API, em formato JSON, é então processada com a biblioteca Gson.

O método `converter()` constrói a URL da API com base nas moedas fornecidas pelo usuário, faz a requisição, parseia o JSON e extrai a taxa de câmbio. Em seguida, calcula o valor convertido e retorna um JSON formatado com os dados da conversão.

## Considerações

*   **Tratamento de erros:** O código possui um tratamento básico de erros. Um tratamento mais robusto, como tratamento de exceções específicas e mensagens de erro mais informativas, pode ser implementado.
*   **Validação de entrada:** A validação das entradas do usuário (ex: moedas inválidas) pode ser melhorada.
*   **Limites da API gratuita:** A API ExchangeRate-API possui limites de requisições em seu plano gratuito. Considere isso ao utilizar o programa.
*   **O código é funcional, mas pode ser melhorado e utilizado como base para estudos

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

[MIT](LICENSE) (Adicione um arquivo LICENSE com a licença escolhida)

