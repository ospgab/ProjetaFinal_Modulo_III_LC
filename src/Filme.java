import java.math.BigDecimal;
import java.time.Duration;
import java.time.Year;
import java.util.ArrayList;

public class Filme {
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

    public Filme(String rank, String titulo, String genero, String descricao,
                 String diretor, String atores, String ano, String duracao, String rating,
                 String quantidadeVotos, String lucro, String metascore) {
        this.rank = Integer.parseInt(rank);
        this.titulo = titulo;
        this.genero = separaNomes(genero);
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = separaNomes(atores);
        this.ano = Year.parse(ano);
        this.duracao = Duration.parse("PT"+duracao+"M");
        this.rating = Double.parseDouble(rating);
        this.quantidadeVotos = Long.parseLong(quantidadeVotos);
        this.lucro = BigDecimal.valueOf(Double.parseDouble(lucro));
        this.metascore = Double.parseDouble(metascore);
    }



    public Filme(String rank, String titulo, String genero, String descricao,
                 String diretor, String atores, String ano, String duracao, String rating,
                 String quantidadeVotos) {
        // Sem Lucro e Metascore
        this.rank = Integer.parseInt(rank);
        this.titulo = titulo;
        this.genero = separaNomes(genero);
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = separaNomes(atores);
        this.ano = Year.parse(ano);
        this.duracao = Duration.parse("PT"+duracao+"M");
        this.rating = Double.parseDouble(rating);
        this.quantidadeVotos = Long.parseLong(quantidadeVotos);
    }

    public Filme(String rank, String titulo, String genero, String descricao,
                 String diretor, String atores, String ano, String duracao, String rating,
                 String quantidadeVotos, String metascore) {
        // Sem Lucro
        this.rank = Integer.parseInt(rank);
        this.titulo = titulo;
        this.genero = separaNomes(genero);
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = separaNomes(atores);
        this.ano = Year.parse(ano);
        this.duracao = Duration.parse("PT"+duracao+"M");
        this.rating = Double.parseDouble(rating);
        this.quantidadeVotos = Long.parseLong(quantidadeVotos);
        this.metascore = Double.parseDouble(metascore);
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