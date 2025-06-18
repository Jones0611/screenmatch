package br.com.joao.screenmatch.modelos;

public class Filme  {
    public String nome;
    public int anoDeLancamento;
    public boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacao;
    public int duracaoEmMinutos;

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
}
