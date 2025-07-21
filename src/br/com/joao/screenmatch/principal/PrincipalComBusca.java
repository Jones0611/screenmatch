package br.com.joao.screenmatch.principal;

import br.com.joao.screenmatch.execao.ErroDeConversaoDeAnoException;
import br.com.joao.screenmatch.modelos.Titulo;
import br.com.joao.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca");
        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=89dd21a4";
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            //Titulo meuTitulo = gson.fromJson(json, Titulo.class);
            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);

            //try {
            System.out.println("Dentro do Try");
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);

            FileWriter escrita = new FileWriter("filmes.txt");
            escrita.write(meuTitulo.toString());
            escrita.close();
        } catch (NumberFormatException e){
            System.out.println("Aconteceu um erro:");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Algum erro de argumento na busca");
        } catch (ErroDeConversaoDeAnoException e){
            System.out.println(e.getMensagem());
        }

    }
}
