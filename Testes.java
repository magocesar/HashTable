import Hash.LinearProbingHash;
import Hash.QuadraticProbingHash;
import aux_proj.Aluno;

public class Testes {

    public static void main(String[] args) {
    
        Aluno cesar = new Aluno(0, "Cesar");
        Aluno ana = new Aluno(10, "Ana");
        Aluno Maria = new Aluno(20, "Maria");
        Aluno jose = new Aluno(30, "Jose");
        Aluno Joao = new Aluno(3, "Joao");

        LinearProbingHash hash = new LinearProbingHash(10, 0.75);

        hash.inserir(cesar);
        hash.inserir(ana);
        hash.print();
        hash.remover(0);
        hash.print();
        System.out.println(hash.buscar(10).getNome());
    }
    
}
