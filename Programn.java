import Aluno.Aluno;
import Hash.LinearProbingHash;
import Hash.QuadraticProbingHash;

public class Programn {
    public static void main(String[] args) {
        Aluno cesar = new Aluno(1, "Cesar");
        Aluno joao = new Aluno(2, "Joao");
        Aluno maria = new Aluno(11, "Maria");
        Aluno pedro = new Aluno(3, "Pedro");
        Aluno rodrigo = new Aluno(5, "Rodrigo");

        QuadraticProbingHash hash = new QuadraticProbingHash(10, 0.75);

        hash.inserir(maria);
        hash.printHash();
        hash.inserir(cesar);
        hash.printHash();
    }
}
