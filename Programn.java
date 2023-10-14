import Aluno.Aluno;
import Hash.LinearProbingHash;
import Hash.QuadraticProbingHash;

public class Programn {
    public static void main(String[] args) {
        Aluno cesar = new Aluno(1, "Cesar");
        Aluno joao = new Aluno(1, "Joao");
        Aluno maria = new Aluno(1, "Maria");
        Aluno pedro = new Aluno(1, "Pedro");
        Aluno rodrigo = new Aluno(1, "Rodrigo");

        QuadraticProbingHash hash = new QuadraticProbingHash(16, 0.75);

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
        hash.remover(rodrigo);
        hash.printHash();
    }
}
