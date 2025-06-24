package br.com.joao.screenmatch.principal;

import br.com.joao.screenmatch.calculos.CalculadorDeTempo;
import br.com.joao.screenmatch.calculos.FiltroRecomendacao;
import br.com.joao.screenmatch.modelos.Episodio;
import br.com.joao.screenmatch.modelos.Filme;
import br.com.joao.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1972);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração do Filme: " + meuFilme.getDuracaoEmMinutos() + " minutos");
        
        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacao());
        System.out.println(meuFilme.pegaMedia());

        Serie breakingBad = new Serie("Breaking Bad",2008);
        breakingBad.setTemporadas(5);
        breakingBad.setEpisodeosPorTemporada(13);
        breakingBad.setMinutosPorEpisodio(47);
        System.out.println("Duração para maratonar Breaking bad: " + breakingBad.getDuracaoEmMinutos() + " minutos");
        System.out.println("Duração para maratonar Breaking bad: " + (breakingBad.getDuracaoEmMinutos()/60) + " horas");

        Filme melhorFilme = new Filme("Rocky, um Lutador",1976);
        melhorFilme.avalia(10);
        System.out.println(melhorFilme.pegaMedia());
        melhorFilme.setDuracaoEmMinutos(120);
        System.out.println("Duração do Filme: " + melhorFilme.getDuracaoEmMinutos() + " minutos");

        Serie modernFamily = new Serie("Modern Family" , 2009);
        modernFamily.setTemporadas(11);
        modernFamily.setEpisodeosPorTemporada(22);
        modernFamily.setMinutosPorEpisodio(22);

        Serie theOffice = new Serie("The Office",2005);
        theOffice.setTemporadas(9);
        theOffice.setEpisodeosPorTemporada(22);
        theOffice.setMinutosPorEpisodio(22);

        CalculadorDeTempo calculadora = new CalculadorDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(melhorFilme);
        calculadora.inclui(theOffice);
        calculadora.inclui(modernFamily);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(melhorFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(breakingBad);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoJoao = new Filme("Clube da Luta", 1999);
        filmeDoJoao.avalia(8);
        System.out.println(filmeDoJoao.pegaMedia());
        filmeDoJoao.setDuracaoEmMinutos(139);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoJoao);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(melhorFilme);
        System.out.println("Tamanho da lista:"  + listaDeFilmes.size());
        System.out.println("Primeiro Filme: " +listaDeFilmes.get(0));
        System.out.println(listaDeFilmes);
    }
}