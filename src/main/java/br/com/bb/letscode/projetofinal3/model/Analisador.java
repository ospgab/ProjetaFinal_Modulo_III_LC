package br.com.bb.letscode.projetofinal3.model;

import java.math.BigDecimal;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Analisador {

    private static Comparator<Filme> comparatorRating = new Comparator<Filme>() {
        @Override
        public int compare(Filme filme1, Filme filme2) {
            if(filme1.getRating()< filme2.getRating()) return 1;
            else if (filme1.getRating()> filme2.getRating()) return -1;
            return 0;
        }
    };

    private static Comparator<Filme> comparatorLucro = new Comparator<Filme>() {
        @Override
        public int compare(Filme filme1, Filme filme2) {
            if(filme1.getLucro().doubleValue() < filme2.getLucro().doubleValue()) return 1;
            else if (filme1.getLucro().doubleValue() > filme2.getLucro().doubleValue()) return -1;
            return 0;
        }

    };

    public static List<List<Filme>> getMelhores50Anuais(HashSet<Filme> dataBaseTrabalhado){
        HashSet<Year> anos = new HashSet<Year>();
        dataBaseTrabalhado.stream()
                .forEach(filme -> anos.add(filme.getAno()));

        System.out.println("Aqui começam os melhores filmes \n\n\n");
        List<List<Filme>> melhoresFilmes = new ArrayList<>();
        for (Year ano : anos){
            System.out.println(ano);
            List<Filme> filmesAno = dataBaseTrabalhado.stream()
                    .filter(filme -> filme.getAno().equals(ano))
                    .sorted(comparatorRating)
                    .limit(50)
                    .collect(Collectors.toList());
            melhoresFilmes.add(filmesAno);
            System.out.println("Filmes do ano " + ano);
            for(Filme filme:filmesAno){
                System.out.println(filme.getRating() + " " + filme.getTitulo() + " " + filme.getGenero());
            }
        }
        return melhoresFilmes;
    }

    public static List<Filme> getMelhores20Terror(HashSet<Filme> dataBaseTrabalhado){
        List<Filme> topHorror = dataBaseTrabalhado.stream()
                .filter(filme -> filme.getGenero().contains("Horror"))
                .sorted(comparatorRating)
                .limit(20)
                .collect(Collectors.toList());

        return topHorror;
    }

    public static List<Filme> getMaiorLucro(HashSet<Filme> dataBaseTrabalhado){
        List<Filme> maiorLucro = dataBaseTrabalhado.stream()
                .filter(filme -> filme.getLucro().compareTo(BigDecimal.valueOf(0.01))==1)
                .sorted(comparatorLucro)
                .limit(50)
                .collect(Collectors.toList());

        return maiorLucro;
    }

    public static List<Filme> getPorGenero(HashSet<Filme> dataBaseTrabalhado, String genero){
        List<Filme> topGenero = dataBaseTrabalhado.stream()
                .filter(filme -> filme.getGenero().contains(genero))
                .sorted(comparatorRating)
                .limit(20)
                .collect(Collectors.toList());

        return topGenero;
    }

    public static List<Filme> getPorDiretor(HashSet<Filme> dataBaseTrabalhado, String diretor){
        List<Filme> filmesDiretor = dataBaseTrabalhado.stream()
                .filter(filme -> filme.getDiretor().contains(diretor))
                .sorted(comparatorRating)
                .limit(20)
                .collect(Collectors.toList());

        return filmesDiretor;
    }

    public static List<Filme> getPorAtor(HashSet<Filme> dataBaseTrabalhado, String ator){
        List<Filme> filmesAtor = dataBaseTrabalhado.stream()
                .filter(filme -> filme.getAtores().contains(ator))
                .sorted(comparatorRating)
                .limit(20)
                .collect(Collectors.toList());

        return filmesAtor;
    }

    public static List<Filme> getPorAno(HashSet<Filme> dataBaseTrabalhado, String ano){
        List<Filme> filmesAno = dataBaseTrabalhado.stream()
                .filter(filme -> filme.getAno().equals(Year.parse(ano, DateTimeFormatter.ofPattern("yyyy"))))
                .sorted(comparatorRating)
                .limit(20)
                .collect(Collectors.toList());

        return filmesAno;
    }

}

