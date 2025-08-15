public abstract class Pessoa {
   protected String nome;
   protected String nacionalidade;
   protected String idade;
   protected String redeSocial;

    public Pessoa(){

    }
    // manipular as variaveis protegidas
    public Pessoa(String nome, String nacionalidade, String idade, String redeSocial){
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.redeSocial = redeSocial;
    }
// atribuir valores as variaveis
    public String getNome() { return nome;}
    public void setNome(String nome) { this.nome = nome;}

    public String getNacionalidade() { return nacionalidade;}
    public void setNacionalidade(String nacionalidade) {this.nacionalidade = nacionalidade;}

    public String getIdade() { return idade;}
    public void setIdade(String idade) {this.idade = idade;}

    public String getRedeSocial() { return redeSocial;}
    public void setRedeSocial(String redeSocial) {this.redeSocial = redeSocial;}

    @Override
    public String toString() {
        // formatação da exibição
        return "Nome:" + nome + '\n'+
                "Nacionalidade: " + nacionalidade + '\n'+
                "Idade: " + idade + '\n'+
                "Rede Social: " + redeSocial;
    }
}
