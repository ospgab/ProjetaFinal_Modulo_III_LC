import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Leitura {
    public static void main(String[] args) throws IOException {


        Files.lines(Paths.get("C:/Users/F3548784/IdeaProjects/ProjetoFinal_Modulo_III_LC/dados/movies1.csv"))
                .skip(1)
                .filter(line -> line.contains("Golden"))
                .forEach(System.out::println);

        final Matcher matcher = Pattern
                .compile("(?:,|\n|^)(\"(?:(?:\"\")*[^\"]*)*\"|[^\",\n]*|(?:\n|$))")
                .matcher("1,Guardians of the Galaxy,\"Action,Adventure,Sci-Fi\",A group of intergalactic criminals are forced to work together to stop a fanatical warrior from taking control of the universe.,James Gunn,\"Chris Pratt, Vin Diesel, Bradley Cooper, Zoe Saldana\",2014,121,8.1,757074,333.13,76");

        while (matcher.find()){
            String entrada = matcher.group();
            System.out.println("Group: " + matcher.group());
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


    }
}





// 1,Guardians of the Galaxy,"Action,Adventure,Sci-Fi",A group of intergalactic criminals are forced to work together to stop a
// fanatical warrior from taking control of the universe.,James Gunn,"Chris Pratt, Vin Diesel, Bradley Cooper, Zoe Saldana",
// 2014,121,8.1,757074,333.13,76