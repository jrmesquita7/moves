package br.com.jr.screenmatch.modelos;

import br.com.jr.screenmatch.excecao.ErroDeConversaoException;

public class Titulo {


    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaAvaliacoes;
    private int totalDeAvaliacao;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb){
        this.nome = meuTituloOmdb.title();

        if (meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoException("Não consegui converter o ano");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome: " + nome);
        System.out.println("Ano de Lançamento " + anoDeLancamento);
        System.out.println("Duração " + duracaoEmMinutos + " Minutos");
        if(totalDeAvaliacao == 0){
            System.out.println("Ainda não existe avaliações para esse título");
        }else{
            System.out.println("Quantidade de avaliações: " + totalDeAvaliacao);
        }

    }

    public void avalia(double nota){
        somaAvaliacoes += nota;
        totalDeAvaliacao++;
    }

    public double pegaMedia (){
        return somaAvaliacoes/totalDeAvaliacao;
    }

    public int getTotalDeAvaliacao(){
        return totalDeAvaliacao;
    }

    public int getDuracaoEmMinutos(){
        return duracaoEmMinutos;
    }


    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        if(duracaoEmMinutos >5000){
            System.out.printf("Limite estourado de minutos");
        }else{
            this.duracaoEmMinutos = duracaoEmMinutos;
        }

    }

    @Override
    public String toString() {
        return "Titulo{" +
                "nome='" + nome + '\'' +
                ", anoDeLancamento=" + anoDeLancamento + '\'' +
                ", duracao=" + duracaoEmMinutos +
                '}';
    }
}
