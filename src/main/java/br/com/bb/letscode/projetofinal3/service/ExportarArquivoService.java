package br.com.bb.letscode.projetofinal3.service;

import br.com.bb.letscode.projetofinal3.model.Filme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExportarArquivoService {

    private Path caminho;

    private List<String> linhas;

    public ExportarArquivoService(String caminho, List<Filme> filmes) {
        List<String> linhas = new ArrayList<>();

        setCaminho(Path.of(caminho));

        for (Filme filme: filmes) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(filme.getRank() + ",");
            stringBuilder.append(filme.getTitulo() + ",");
            stringBuilder.append(filme.getGenero() + ",");
            stringBuilder.append(filme.getDescricao() + ",");
            stringBuilder.append(filme.getDiretor() + ",");
            stringBuilder.append(filme.getAtores() + ",");
            stringBuilder.append(filme.getAno() + ",");
            stringBuilder.append(filme.getDuracao() + ",");
            stringBuilder.append(filme.getRating() + ",");
            stringBuilder.append(filme.getQuantidadeVotos() + ",");
            stringBuilder.append(filme.getLucro() + ",");
            stringBuilder.append(filme.getMetascore());

            linhas.add(stringBuilder.toString());
        }

        setLinhas(linhas);
    }

    public ExportarArquivoService() {
        setCaminho(null);
        setCaminho(null);
    }

    public Path getCaminho() {
        return caminho;
    }

    public void setCaminho(Path caminho) {
        this.caminho = caminho;
    }

    public List<String> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<String> linhas) {
        this.linhas = linhas;
    }

    public void salvar() throws IOException {
        Files.write(caminho, linhas);
    }

}
