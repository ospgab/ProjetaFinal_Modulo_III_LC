package br.com.bb.letscode.projetofinal3.model;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analisador {

    private static Comparator<Filme> comparator = new Comparator<Filme>() {
        @Override
        public int compare(Filme filme1, Filme filme2) {
            if(filme1.getRating()< filme2.getRating()) return 1;
            else if (filme1.getRating()> filme2.getRating()) return -1;
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
                    .sorted(comparator)
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
                .sorted(comparator)
                .limit(20)
                .collect(Collectors.toList());

        return topHorror;
    }
}
