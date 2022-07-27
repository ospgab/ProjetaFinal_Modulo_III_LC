package br.com.bb.letscode.projetofinal3.service;

import br.com.bb.letscode.projetofinal3.model.Analisador;
import br.com.bb.letscode.projetofinal3.model.Filme;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Year;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Leitura {
    public static void main(String[] args) throws IOException {

        // pega cada linha do arquivo
        List<String> dataBaseBruto = Files.lines(Paths.get("src\\main\\resources\\dados\\movies1.csv"))
                .skip(1)
                .filter(line -> line.contains(" "))
                .collect(Collectors.toList());

        // Compara cada linha da tabela com o regex para separá-la em grupos
        HashSet<Filme> dataBaseTrabalhado = new HashSet<Filme>(){

        };
        for(String entrada: dataBaseBruto) {
            final Matcher matcher = Pattern
                    .compile("(?:,|\n|^)(\"(?:(?:\"\")*[^\"]*)*\"|[^\",\n]*|(?:\n|$))")
                    .matcher(entrada);

            //instanciar um filme a partir dos campos do regex
            ArrayList<String> filmeSeparado = new ArrayList<>();
            while (matcher.find()) {
                String novaEntrada = matcher.group(1);
                //System.out.println("Group: " + matcher.group(1));
                filmeSeparado.add(novaEntrada);
            }

            // adicionar os objetos filmes numa collection
            Filme filme = new Filme(filmeSeparado);
            dataBaseTrabalhado.add(filme);
            //System.out.println(filme.toString());
        }







        List<Filme> topHorror = Analisador.getMelhores20Terror(dataBaseTrabalhado);

        topHorror.stream()
                .forEach(filme -> System.out.println(filme.getRating() + " " + filme.getTitulo()));


        List<List<Filme>> aaaa = Analisador.getMelhores50Anuais(dataBaseTrabalhado);

        // /*
        new ExportarArquivoService("relatorios/topHorror.csv", topHorror).salvar();

        for (List<Filme> filmes : aaaa) {
            new ExportarArquivoService("relatorios/melhores_de_" + filmes.get(0).getAno().toString(), filmes).salvar();
        } //*/

//        List<Filme> bbb = Analisador.getMaiorLucro(dataBaseTrabalhado);
//
//        for(Filme filme:bbb){
//            System.out.println(filme.getLucro() + " " + filme.getTitulo());
//        }
//
//        List<Filme> ccc = Analisador.getPorGenero(dataBaseTrabalhado, "Drama");
//        for(Filme filme:ccc){
//            System.out.println(filme.getRating() + " " + filme.getTitulo() + " " + filme.getGenero());
//        }

        List<Filme> ddd = Analisador.getPorDiretor(dataBaseTrabalhado, "James");
        for(Filme filme:ddd){
            System.out.println(filme.getRating() + " " + filme.getTitulo() + " " + filme.getDiretor());
        }

        List<Filme> eee = Analisador.getPorAtor(dataBaseTrabalhado, "Chris Pratt");
        for(Filme filme:eee){
            System.out.println(filme.getRating() + " " + filme.getTitulo() + " " + filme.getAtores());
        }

        List<Filme> fff = Analisador.getPorAno(dataBaseTrabalhado, "2015");
        for(Filme filme:fff){
            System.out.println(filme.getRating() + " " + filme.getTitulo() + " " + filme.getAno());
        }


    }
}





// 1,Guardians of the Galaxy,"Action,Adventure,Sci-Fi",A group of intergalactic criminals are forced to work together to stop a
// fanatical warrior from taking control of the universe.,James Gunn,"Chris Pratt, Vin Diesel, Bradley Cooper, Zoe Saldana",
// 2014,121,8.1,757074,333.13,76