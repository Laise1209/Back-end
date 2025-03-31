package school.sptech.primeira_aula;

public class Filme {
    private static String nome;
    private String diretor;

    public Filme() {}

    public Filme(String nome, String diretor) {
        this.nome = nome;
        this.diretor = diretor;
    }

    public static String getNome() {
        return nome;
    }

    public String getCuriosidade(){ //campo calculado ou campo virtual
        return "mata nazi";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
