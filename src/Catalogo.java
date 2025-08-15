import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Filme> filmes;

    public Catalogo() {
        this.filmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public List<Filme> pesquisarFilme(String nome) {
        List<Filme> resultados = new ArrayList<>();
        for (Filme f : this.filmes) {
            if(f.contemNome(nome)){
                resultados.add(f);
            }
        }
        return resultados;
    }
    public List<Filme>getFilmes() {
        return filmes;
    }
}

