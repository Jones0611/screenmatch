package br.com.joao.screenmatch.principal;

import br.com.joao.screenmatch.modelos.Filme;
import br.com.joao.screenmatch.modelos.Serie;
import br.com.joao.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1972);
        meuFilme.avalia(9);
        Filme melhorFilme = new Filme("Rocky, um Lutador",1976);
        melhorFilme.avalia(10);
        var filmeDoJoao = new Filme("Clube da Luta", 1999);
        filmeDoJoao.avalia(9);
        Serie theOffice = new Serie("The Office",2005);
        Serie modernFamily = new Serie("Modern Family" , 2009);
        Serie breakingBad = new Serie("Breaking Bad",2008);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoJoao);
        lista.add(meuFilme);
        lista.add(melhorFilme);
        lista.add(theOffice);
        lista.add(modernFamily);
        lista.add(breakingBad);
        for (Titulo item: lista){
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("João");
        buscaPorArtista.add("Michelly");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(lista);
        System.out.println(lista);
        //Comparar com ano
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano:");
        System.out.println(lista);

    }
}
