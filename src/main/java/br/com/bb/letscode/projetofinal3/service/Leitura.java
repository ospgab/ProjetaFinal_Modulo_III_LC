import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Leitura {
    public static void main(String[] args) throws IOException {

        // pega cada linha do arquivo
        List<String> dataBaseBruto = Files.lines(Paths.get("C:/Users/F3548784/IdeaProjects/ProjetoFinal_Modulo_III_LC/dados/movies1.csv"))
                .skip(1)
                .filter(line -> line.contains(" "))
                .collect(Collectors.toList());

        // Compara cada linha da tabela com o regex para separá-la em grupos
        Set<Filme> dataBaseTrabalhado = new HashSet<Filme>(){

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

        /*
        Comparator<Filme> comparator = new Comparator<Filme>() {
            @Override
                public int compare(Filme filme1, Filme filme2) {
                if(filme1.getRank()> filme2.getRank()) return 1;
                else if (filme1.getRank()< filme2.getRank()) return -1;
                return 0;
                }

        };

         */



        List<Filme> topHorror = dataBaseTrabalhado.stream()
                .filter(filme -> filme.getGenero().contains("Horror"))
                //.sorted( (filme1, filme2) -> filme1.compareTo(filme2))
                .collect(Collectors.toList());

        topHorror.stream().forEach(System.out::println);




    }
}





// 1,Guardians of the Galaxy,"Action,Adventure,Sci-Fi",A group of intergalactic criminals are forced to work together to stop a
// fanatical warrior from taking control of the universe.,James Gunn,"Chris Pratt, Vin Diesel, Bradley Cooper, Zoe Saldana",
// 2014,121,8.1,757074,333.13,76