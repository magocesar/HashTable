package Hash;
import Aluno.Aluno;

public class QuadraticProbingHash extends AbstractHashTable{
    public QuadraticProbingHash(int tamanho_hash, double fator_carga){
        super(tamanho_hash, fator_carga);
    }

    @Override
    public void inserir(Aluno aluno){
        int index = Hash(aluno);
        int expoente = 1;
        int aux_colisao = 0;

        iteracoes++;
        while(arr[index] != null){
            if(aux_colisao == 0){
                aux_colisao = 1;
            }
            index = (index + expoente * expoente) % tamanho_hash;
            expoente++;
            iteracoes++;
        }
        
        arr[index] = aluno;
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
    public Aluno buscar(Aluno aluno){
        int index = Hash(aluno);
        int expoente = 1;

        iteracoes++;
        while(arr[index] != null){
            if(arr[index].getId() == aluno.getId()){
                return arr[index];
            }
            index = (index + expoente * expoente) % tamanho_hash;
            expoente++;
            iteracoes++;
        }
        return null;
    }

    @Override
    public Aluno remover(Aluno aluno){
        int index = Hash(aluno);
        int expoente = 1;

        iteracoes++;
        while(arr[index] != null){
            if(arr[index].getId() == aluno.getId()){
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
