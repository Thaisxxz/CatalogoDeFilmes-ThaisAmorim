import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Filme {

    private String nomeDoFilme;
    private LocalDate dataLancamento;
    private String descricao;
    //opção de usar o bigDecimal para o orçamento
    private String orcamento;
    private Diretores diretor;
    private List<Atores> atores;
    public Filme(){
        //padrão
    }
    public Filme (String nomeDoFilme, LocalDate dataLancamento, String descricao, String orcamento){
        this.nomeDoFilme = nomeDoFilme;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.orcamento = orcamento;
    }

    public String getNomeDoFilme() {return nomeDoFilme;}
    public void setNomeDoFilme(String nomeDoFilme) {this.nomeDoFilme = nomeDoFilme;}

    public LocalDate getDataLancamento() {return dataLancamento;}
    public void setDataLancamento(LocalDate dataLancamento) {this.dataLancamento = dataLancamento;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getOrcamento() {return orcamento;}
    public void setOrcamento(String orcamento) {this.orcamento = orcamento;}

    public Diretores getDiretor(){return diretor;}
    public void setDiretor(Diretores diretor){ this.diretor=diretor;}

    public List<Atores> getAtores() {return atores;}
    public void adicionarAtor(Atores ator){ this.atores.add(ator);}

    //pesquisar ignorando maiusculas e minusculas
    public boolean contemNome(String termo){
        return nomeDoFilme!=null && nomeDoFilme.toLowerCase().contains(termo.toLowerCase());
    }

    public void informacoesFilme(){
        System.out.println ("Nome:"+nomeDoFilme + '\n'+
                            "Data de lançamento:"+ dataLancamento + '\n' +
                            "orçamento" + orcamento);
        System.out.println("Atores:");
        if (atores.isEmpty()) {
            System.out.println ("No momento, não existem atores associados."  + '\n');
        }
        else {
            for(Atores ator : atores){
                System.out.println("." + ator.getNome() + '\n');
            }
        }
       // System.out.println("Diretor Geral:" + (diretor != null ? diretor.getNome() : "Não definido"));
    }
}