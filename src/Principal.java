import br.com.joao.screenmatch.calculos.CalculadorDeTempo;
import br.com.joao.screenmatch.calculos.FiltroRecomendacao;
import br.com.joao.screenmatch.modelos.Episodio;
import br.com.joao.screenmatch.modelos.Filme;
import br.com.joao.screenmatch.modelos.Serie;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.logging.Filter;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1976);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração do Filme: " + meuFilme.getDuracaoEmMinutos() + " minutos");

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacao());
        System.out.println(meuFilme.pegaMedia());

        Serie breakingBad = new Serie();
        breakingBad.setNome("Breaking Bad");
        breakingBad.setAnoDeLancamento(2008);
        breakingBad.setTemporadas(5);
        breakingBad.setEpisodeosPorTemporada(13);
        breakingBad.setMinutosPorEpisodio(47);
        System.out.println("Duração para maratonar Breaking bad: " + breakingBad.getDuracaoEmMinutos() + " minutos");
        System.out.println("Duração para maratonar Breaking bad: " + (breakingBad.getDuracaoEmMinutos()/60) + " horas");

        Filme melhorFilme = new Filme();
        melhorFilme.setNome("Rocky, um Lutador");
        melhorFilme.setAnoDeLancamento(1976);
        melhorFilme.avalia(10);
        System.out.println(melhorFilme.pegaMedia());
        melhorFilme.setDuracaoEmMinutos(120);
        System.out.println("Duração do Filme: " + melhorFilme.getDuracaoEmMinutos() + " minutos");

        Serie modernFamily = new Serie();
        modernFamily.setNome("Modern Family");
        modernFamily.setAnoDeLancamento(2009);
        modernFamily.setTemporadas(11);
        modernFamily.setEpisodeosPorTemporada(22);
        modernFamily.setMinutosPorEpisodio(22);

        Serie theOffice = new Serie();
        theOffice.setNome("The Office");
        theOffice.setAnoDeLancamento(2005);
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
    }
}