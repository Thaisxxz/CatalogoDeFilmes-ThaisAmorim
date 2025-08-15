import java.time.LocalDate;

public class Atores extends Pessoa {

    //datadenascimento
    protected LocalDate dataDeNascimento;

    public Atores() {
        //padrão, para que o sistema possa iniciar mesmo sem todos os atributos
    }

    public Atores(String nome, String nacionalidade, String idade, String redeSocial) {super(nome, nacionalidade, idade, redeSocial);}

    public LocalDate getDataDeNascimento(){ return dataDeNascimento;}
    public void setDataDeNascimento(LocalDate dataDeNascimento){this.dataDeNascimento = dataDeNascimento;}

    @Override
    public String toString() {
        return "Ator/Atriz:" + super.toString() + "\nData de Nascimento: " + dataDeNascimento;}
    }
