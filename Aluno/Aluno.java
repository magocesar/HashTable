package Aluno;

public class Aluno{
    private int id;
    private String nome;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aluno(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
}