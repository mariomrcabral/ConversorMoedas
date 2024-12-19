import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//public class conversorMoedas {
//1}

public class conversorMoedas {
    private static final String API_KEY = "54a8fb0131c1a6825b41eeb5"; // Substitua pela sua chave da API
    private static final String BASE_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("Seja bem-vindo ao Conversor de Moeda ");
        System.out.println("**************************************** ");
        System.out.println("Escolha somente uma dessas moedas:" +
                " ARS - Argentina," +
                " USD - Dólar," +
                " EURO - Europeu," +
                " CLP - Peso Chileno," +
                " BRL - Real," +
                " BOB - Peso Boliviano)");


        while (continuar) {
            //System.out.println("Conversor de Moedas");
            System.out.println("1. Converter");
            System.out.println("######################");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a moeda de origem (ex: BRL): ");
                    String moedaOrigem = scanner.next().toUpperCase();
                    System.out.print("Digite a moeda de destino (ex: USD): ");
                    String moedaDestino = scanner.next().toUpperCase();
                    System.out.print("Digite o valor a ser convertido: ");
                    double valor = scanner.nextDouble();

                    String resultado = converter(moedaOrigem, moedaDestino, valor);
                    System.out.println(resultado);
                    break;
                case 2:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static String converter(String moedaOrigem, String moedaDestino, double valor) throws Exception {
        // Construir a URL da requisição
        URI uri = URI.create(BASE_URL + moedaOrigem + "?base=" + moedaOrigem + "&symbols=" + moedaDestino);

        // Fazer a requisição HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("apikey", API_KEY)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parsear o JSON
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        double taxaConversao = jsonObject.getAsJsonObject("rates").get(moedaDestino).getAsDouble();

        // Calcular o valor convertido e formatar a saída
        double valorConvertido = valor * taxaConversao;
        JsonObject resultado = new JsonObject();
        resultado.addProperty("moedaOrigem", moedaOrigem);
        resultado.addProperty("moedaDestino", moedaDestino);
        resultado.addProperty("valor", valor);
        resultado.addProperty("valorConvertido", valorConvertido);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(resultado);



    }
}
