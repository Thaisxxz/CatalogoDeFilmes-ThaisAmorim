import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static Catalogo catalogoFilmes = new Catalogo();
    private static Scanner scCadastro = new Scanner(System.in);
    private static List<Atores> atoresList = new ArrayList<>();
    private static List<Diretores> diretoresList = new ArrayList<>();

    public static void main(String[] args) {
        int escolha;
        //controle das funções do catalogo de filmes
        do {
            System.out.println("\n Catálogo de Filmes");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Cadastrar ator/atriz");
            System.out.println("3. Cadastrar diretor(a)");
            System.out.println("4. Associar diretores e atores a um filme");
            System.out.println("5. Pesquisar filme");
            System.out.println("6. Listar todos os filmes");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            Scanner sc = new Scanner(System.in);
            escolha = Integer.parseInt(sc.nextLine());
            System.out.println("Opção escolhida:" + escolha);
            sc.close();

            if (escolha == 1) {
                cadastrarFilme();
            } else if (escolha == 2) {
                cadastrarAtores();
            } else if (escolha == 3) {
                cadastrarDiretores();
            } else if (escolha == 4) {
                associarFilme();
            } else if (escolha == 5) {
                pesquisarFilme();
            } else if (escolha == 6) {
                listarFilmes();
            } else if (escolha == 0) {
                System.out.println("Saindo do catálogo!");
            } else {
                System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    //cadastrarFilmes
    public static void cadastrarFilme() {
        System.out.println("\n ---Cadastro de um novo filme--- \n ---Digite os seguites dados:");
        System.out.println("Título: ");
        String nomeDoFilme = scCadastro.nextLine();

        System.out.println("Data de lançamento: Formato AAAA-MM-DD. ");
        LocalDate dataLancamento = null;
        boolean dataValida = false;
        while (!dataValida) {
            System.out.println("Data de lançamento: ");
            String dtString = scCadastro.nextLine();
            try {
                dataLancamento = LocalDate.parse(dtString);
                dataValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido! Por favor, forneça uma data no formato AAAA-MM-DD.");
            }
        }
        System.out.println("Adicione uma breve descrição:");
        String descricao = scCadastro.nextLine();

        System.out.println("Qual foi o orçamento para este filme?");
        String orcamento = scCadastro.nextLine();

        Filme novoFilme = new Filme(nomeDoFilme, dataLancamento, descricao, orcamento);
        //TODO IMPLEMENTAR CLASSE CATALOGO
        catalogoFilmes.adicionarFilme(novoFilme);
        System.out.println("Filme" + novoFilme.getNomeDoFilme() + "cadastrado  com sucesso!");
        // dataLancamento = scCadastro.nextLine();


    }

    //cadastrarAtores
    public static void cadastrarAtores() {
        System.out.println("\n ---Cadastro de um novo Ator/Atriz--- \n ---Digite os seguites dados:");
        System.out.println("Nome: ");
        String nome = scCadastro.nextLine();

        System.out.println("Nacionalidade: ");
        String nacionalidade = scCadastro.nextLine();

        System.out.println("Idade: ");
        String idade = scCadastro.nextLine();

        System.out.println("redeSocial: ");
        String redeSocial = scCadastro.nextLine();

        System.out.println("Data de Nascimento:");
        LocalDate dataDeNascimento = null;
        boolean dataNascValida = false;
        while (!dataNascValida) {
            System.out.println("Data de lançamento: ");
            String dtString = scCadastro.nextLine();
            try {
                dataDeNascimento = LocalDate.parse(dtString);
                dataNascValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido! Por favor, forneça uma data no formato AAAA-MM-DD.");
            }
        }

        //TODO IMPLEMENTAR CLASSE CATALOGO
        atoresList.add(new Atores(nome, nacionalidade, idade, redeSocial));
        System.out.println("Ator/Atriz cadastrado  com sucesso!");
    }

    //cadastrarDiretores
    public static void cadastrarDiretores() {
        System.out.println("\n ---Cadastro de um novo Diretor--- \n ---Digite os seguites dados:");
        System.out.println("Nome: ");
        String nome = scCadastro.nextLine();

        System.out.println("Nacionalidade: ");
        String nacionalidade = scCadastro.nextLine();

        System.out.println("Idade: ");
        String idade = scCadastro.nextLine();

        System.out.println("redeSocial: ");
        String redeSocial = scCadastro.nextLine();

        //TODO IMPLEMENTAR CLASSE CATALOGO
        diretoresList.add(new Diretores(nome, nacionalidade, idade, redeSocial));
        System.out.println("Diretor(a) cadastrado  com sucesso!");
    }

    public static void associarFilme() {
        listarFilmes();

        if (catalogoFilmes.getFilmes().isEmpty()) {
            System.out.println("Escolha o filme de acordo com o indice:");
            int numFilme = Integer.parseInt(scCadastro.nextLine());
            Filme novoFilme = catalogoFilmes.getFilmes().get(numFilme);
            return;
        }

        listarDiretores();
        Filme filme = null;
        if (!diretoresList.isEmpty()) {
            System.out.println("Escolha o diretor de acordo com índice");
            int numDiretor = Integer.parseInt(scCadastro.nextLine());
            filme.setDiretor(diretoresList.get(numDiretor));
        }
        listarAtores();
        if (!atoresList.isEmpty()) {
            System.out.println("Quantos atores e/ou atrizes você deseja adicionar?");
            int quantidade = Integer.parseInt(scCadastro.nextLine());
            for (int i = 0; i < quantidade; i++) {
                System.out.println("Escolha o ator de acordo com o indice:");
                int numAtor = Integer.parseInt(scCadastro.nextLine());
                filme.adicionarAtor(atoresList.get(numAtor));
            }

        }
        System.out.println("Associação efetuada!");
    }
    private static void pesquisarFilme(){
        System.out.println("Digite o nome do filme desejado:");
        String nome = scCadastro.nextLine();
        List<Filme> resultados= catalogoFilmes.pesquisarFilme(nome);
        if (resultados.isEmpty()){
            System.out.println("Nenhum filme encontrado.");
        } else{
            for (Filme filme : resultados);
            //filme.informacoesFilme();
            System.out.println("---------------------");
        }
    }
    //Implemetação dos metodos listar
    private static void listarFilmes() {
        List<Filme> filmes = catalogoFilmes.getFilmes();
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme foi cadastrado!");
            return;
        }
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println(i + "-" + filmes.get(i).getNomeDoFilme());
        }
    }

    private static void listarAtores() {
        if (atoresList.isEmpty()) {
            System.out.println("Nenhum ator/atriz foi cadastrado!");
            return;
        }
        for (int i = 0; i < atoresList.size(); i++) {
            System.out.println(i + "-" + atoresList.get(i).getNome());
        }

    }
    private static void listarDiretores() {
        if (diretoresList.isEmpty()) {
            System.out.println("Nenhum diretor(a) foi cadastrado!");
            return;
        }
        for (int i = 0; i < diretoresList.size(); i++) {
            System.out.println(i + "-" + diretoresList.get(i).getNome());
        }
    }
}
