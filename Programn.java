import Aluno.Aluno;
import Hash.LinearProbingHash;


public class Programn {
    public static void main(String[] args) {
        Aluno cesar = new Aluno(1, "Cesar");
        Aluno joao = new Aluno(2, "Joao");
        Aluno maria = new Aluno(3, "Maria");
        Aluno pedro = new Aluno(4, "Pedro");
        Aluno rodrigo = new Aluno(5, "Rodrigo");

        LinearProbingHash hash = new LinearProbingHash(16, 0.75, 2);

        hash.inserir(cesar);
        hash.printHash();
        hash.inserir(joao);
        hash.printHash();
        hash.inserir(maria);
        hash.printHash();
        hash.inserir(pedro);
        hash.printHash();
        hash.inserir(rodrigo);
        hash.printHash();
    }
}
