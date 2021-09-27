package peu.example.prova3b_beapedroa;

public class Aluno {
    private String nome;
    private String nota1;
    private String nota2;
    private String media;

    public Aluno ( String nome, String nota1, String nota2, String media ) {

        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public String getNota1() {
        return nota1;
    }

    public String getNota2() {
        return nota2;
    }

    public String getMedia() {
        return media;
    }
}
