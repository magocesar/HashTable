package Hash;
import Aluno.Aluno;

public class LinearProbingHash extends AbstractHashTable{
    
    public LinearProbingHash(int tamanho_hash, double fator_carga){
        super(tamanho_hash, fator_carga);
    }

    @Override
    public void inserir(Aluno Aluno){
        int index = Hash(Aluno);
        int aux_colisao = 0;

        iteracoes++;
        while(arr[index] != null){
            if(aux_colisao == 0){
                aux_colisao = 1;
            }
            iteracoes++;
            index = (index + 1) % tamanho_hash;
        }
        arr[index] = Aluno;
        quant_itens++;

        if(aux_colisao == 1){
            colisoes++;
        }

        if(verificarRehashing()){
            System.out.println("Rehashing...");
            rehashing();
        }
    }

    @Override
    public Aluno buscar(Aluno Aluno){
        int index = Hash(Aluno);
        iteracoes++;
        while(arr[index] != null){
            if(arr[index].getId() == Aluno.getId()){
                return arr[index];
            }
            iteracoes++;
            index = (index + 1) % tamanho_hash;
        }
        return null;
    }

    @Override
    public Aluno remover(Aluno Aluno){
        int index = Hash(Aluno);
        iteracoes++;
        while(arr[index] != null){
            if(arr[index].getId() == Aluno.getId()){
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