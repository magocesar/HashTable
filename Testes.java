import Hash.LinearProbingHash;
import aux_proj.Aluno;

public class Testes {

    private Aluno cesar = new Aluno(0, "Cesar");
    private Aluno ana = new Aluno(2, "Ana");
    private Aluno Maria = new Aluno(1, "Maria");
    private Aluno Joao = new Aluno(3, "Joao");


    
    public static void main(String[] args) {
    
        Testes testes = new Testes(); // create an instance of Testes
        LinearProbingHash hash = new LinearProbingHash(5, 0.75);

        hash.inserir(testes.ana); // access ana through the instance
        hash.inserir(testes.cesar); // access cesar through the instance
        hash.inserir(testes.Maria);
        hash.inserir(testes.Joao);
        hash.print();
        hash.remover(0);
        hash.print();
        System.out.println(hash.buscar(3).getNome());
        
    }
    
}
