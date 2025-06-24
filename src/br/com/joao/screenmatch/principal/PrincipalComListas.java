package br.com.joao.screenmatch.principal;

import br.com.joao.screenmatch.modelos.Filme;
import br.com.joao.screenmatch.modelos.Serie;
import br.com.joao.screenmatch.modelos.Titulo;

import java.util.ArrayList;

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
            Filme filme = (Filme) item;
            System.out.println("Classificação " + filme.getClassificacao());
        }
    }
}
