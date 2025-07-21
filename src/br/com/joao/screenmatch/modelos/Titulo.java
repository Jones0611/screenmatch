package br.com.joao.screenmatch.modelos;

import br.com.joao.screenmatch.execao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacao;
    private int duracaoEmMinutos;

    public Titulo(int anoDeLancamento, String nome) {
        this.anoDeLancamento = anoDeLancamento;
        this.nome = nome;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if(meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));

        /*// código omitido…

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", anoDeLancamento=" + anoDeLancamento + "," +
                " duração " + duracaoEmMinutos;

    }

    --------

    public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

// código omitido…

        Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Titulo já convertido");
            System.out.println(meuTitulo);
    }
}*/
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacao(){
        return totalDeAvaliacao;
    }

    public void exibeFichaTecnica (){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento do filme: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacao++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes/totalDeAvaliacao;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "<(nome = " + nome +
                ", anoDeLancamento = " + anoDeLancamento + "," +
                " duração = " + duracaoEmMinutos + ")>";
    }
}
