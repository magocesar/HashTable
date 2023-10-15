package Hash;
import Aluno.Aluno;

public class QuadraticProbingHash extends AbstractHashTable{
    public QuadraticProbingHash(int tamanho_hash, double fator_carga){
        super(tamanho_hash, fator_carga);
    }

    @Override
    public void inserir(Aluno Aluno){
        int index = Hash(Aluno.getId());
        int expoente = 1;

        iteracoes++;
        while(arr[index] != null){
            index = (index + expoente * expoente) % tamanho_hash;
            expoente++;
            iteracoes++;
        }
        
        arr[index] = Aluno;
        quant_itens++;

        if(verificarRehashing()){
            System.out.println("Rehashing...");
            rehashing();
        }
    }

    @Override
    public Aluno buscar(int num){
        int index = Hash(num);
        int expoente = 1;

        iteracoes++;
        while(arr[index] != null){
            if(arr[index].getId() == num){
                return arr[index];
            }
            index = (index + expoente * expoente) % tamanho_hash;
            expoente++;
            iteracoes++;
        }
        return null;
    }

    @Override
    public Aluno remover(int num){
        int index = Hash(num);
        int expoente = 1;

        iteracoes++;
        while(arr[index] != null){
            if(arr[index].getId() == num){
                Aluno rem = arr[index];
                arr[index] = null;
                quant_itens--;
                return rem;
            }
            index = (index + expoente * expoente) % tamanho_hash;
            expoente++;
            iteracoes++;
        }
        System.out.println("Aluno não encontrado");
        return null;
    }
}
