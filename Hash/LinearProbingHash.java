package Hash;
import Aluno.Aluno;

public class LinearProbingHash extends AbstractHashTable{
    
    public LinearProbingHash(int tamanho_hash, double fator_carga){
        super(tamanho_hash, fator_carga);
    }

    @Override
    public void inserir(Aluno Aluno){
        int index = Hash(Aluno.getId());
        iteracoes++;
        while(arr[index] != null){
            iteracoes++;
            index = (index + 1) % tamanho_hash;
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
        iteracoes++;
        while(arr[index] != null){
            if(arr[index].getId() == num){
                return arr[index];
            }
            iteracoes++;
            index = (index + 1) % tamanho_hash;
        }
        return null;
    }

    @Override
    public Aluno remover(int num){
        int index = Hash(num);
        iteracoes++;
        while(arr[index] != null){
            if(arr[index].getId() == num){
                Aluno rem = arr[index];
                arr[index] = null;
                quant_itens--;
                return rem;
            }
            iteracoes++;
            index = (index + 1) % tamanho_hash;
        }
        return null;
    }
}