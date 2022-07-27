package br.com.bb.letscode.projetofinal3.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;
import java.util.Objects;

public class Filme implements Comparable {
    private int rank;
    private String titulo;
    private ArrayList<String> genero;
    private String descricao;
    private String diretor;
    private ArrayList<String> atores;
    private Year ano;
    private Duration duracao;
    private double rating;
    private long quantidadeVotos;
    private BigDecimal lucro;
    private double metascore;

    public Filme(ArrayList<String> entrada) {
        this.rank =  Integer.parseInt(entrada.get(0));
        this.titulo = entrada.get(1);
        this.genero = separaNomes(entrada.get(2));
        this.descricao = entrada.get(3);
        this.diretor = entrada.get(4);
        this.atores = separaNomes(entrada.get(5));
        this.ano = Year.parse(entrada.get(6));
        this.duracao = Duration.parse("PT"+entrada.get(7)+"M");
        this.rating = Double.parseDouble(entrada.get(8));
        this.quantidadeVotos = Long.parseLong(entrada.get(9));
        this.lucro = BigDecimal.valueOf(Double.parseDouble((entrada.get(10).isEmpty()? "0": entrada.get(10))));
        this.metascore = Double.parseDouble(entrada.get(11).isEmpty()? "0": entrada.get(11));
    }


    private ArrayList<String> separaNomes(String nomes){
        nomes = nomes.replaceAll("\"", "");
        String[] nomes2 = nomes.split(",");
        ArrayList<String> nomesSeparados = new ArrayList<>();
        for(String nome : nomes2){
            nome = nome.trim();
            nomesSeparados.add(nome);
        }
        return nomesSeparados;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getGenero() {
        return genero;
    }

    public void setGenero(ArrayList<String> genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public ArrayList<String> getAtores() {
        return atores;
    }

    public void setAtores(ArrayList<String> atores) {
        this.atores = atores;
    }

    public Year getAno() {
        return ano;
    }

    public void setAno(Year ano) {
        this.ano = ano;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getQuantidadeVotos() {
        return quantidadeVotos;
    }

    public void setQuantidadeVotos(long quantidadeVotos) {
        this.quantidadeVotos = quantidadeVotos;
    }

    public BigDecimal getLucro() {
        return lucro;
    }

    public void setLucro(BigDecimal lucro) {
        this.lucro = lucro;
    }

    public double getMetascore() {
        return metascore;
    }

    public void setMetascore(double metascore) {
        this.metascore = metascore;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "rank=" + rank +
                ", \ntitulo='" + titulo + '\'' +
                ", \ngenero='" + genero + '\'' +
                ", \ndescricao='" + descricao + '\'' +
                ", \ndiretor='" + diretor + '\'' +
                ", \natores=" + atores +
                ", \nano=" + ano +
                ", \nduracao=" + duracao +
                ", \nrating=" + rating +
                ", \nquantidadeVotos=" + quantidadeVotos +
                ", \nlucro=" + lucro +
                ", \nmetascore=" + metascore +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Filme)) return false;
        Filme filme = (Filme) o;
        return getTitulo().equals(filme.getTitulo()) && getDiretor().equals(filme.getDiretor()) && getAno().equals(filme.getAno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getDiretor(), getAno());
    }
}

// Rank
// Title
// Genre
// Description
// Director
// Actors
// Year
// Runtime (Minutes)
// Rating
// Votes
// Revenue (Millions)
// Metascore

//Duration P6H3M