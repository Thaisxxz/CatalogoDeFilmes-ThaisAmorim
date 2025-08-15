public class Diretores extends Pessoa {

    public Diretores(){
        //padrão
    }
    public Diretores (String nome, String nacionalidade, String idade, String redeSocial) {super(nome, nacionalidade, idade, redeSocial);}
//TODO filmografia,premios e indicações
    @Override
    public String toString() {
        return "Diretor(a):" + super.toString();
    }
}