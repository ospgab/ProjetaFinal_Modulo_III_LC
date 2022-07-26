import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Leitura {
    public static void main(String[] args) throws IOException {


        List<String> db = Files.lines(Paths.get("C:/Users/F3548784/IdeaProjects/ProjetoFinal_Modulo_III_LC/dados/movies1.csv"))
                .skip(1)
                .filter(line -> line.contains(" "))
                .collect(Collectors.toList());

        Set<Filme> locadora = new HashSet<>();
        for(String entrada: db) {
            final Matcher matcher = Pattern
                    .compile("(?:,|\n|^)(\"(?:(?:\"\")*[^\"]*)*\"|[^\",\n]*|(?:\n|$))")
                    .matcher(entrada);

            ArrayList<String> nova = new ArrayList<>();
            while (matcher.find()) {
                String novaEntrada = matcher.group(1);
                //System.out.println("Group: " + matcher.group(1));
                nova.add(novaEntrada);
            }

            Filme filme = new Filme(nova.get(0), nova.get(1), nova.get(2), nova.get(3), nova.get(4), nova.get(5), nova.get(6),
                    nova.get(7), nova.get(8), nova.get(9), (nova.get(10).isEmpty()? "0": nova.get(10)), (nova.get(11).isEmpty()? "0": nova.get(11)));
            locadora.add(filme);
            //System.out.println(filme.toString());
        }


        locadora.stream()
                .filter(filme -> filme.getGenero().contains("Thriller"))
                .forEach(System.out::println);




        

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


    }
}





// 1,Guardians of the Galaxy,"Action,Adventure,Sci-Fi",A group of intergalactic criminals are forced to work together to stop a
// fanatical warrior from taking control of the universe.,James Gunn,"Chris Pratt, Vin Diesel, Bradley Cooper, Zoe Saldana",
// 2014,121,8.1,757074,333.13,76