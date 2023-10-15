package Hash;
import aux_proj.Aluno;

public class QuadraticProbingHash extends AbstractHashTable{
    public QuadraticProbingHash(int tamanho_hash, double fator_carga){
        super(tamanho_hash, fator_carga);
        this.arr = new Aluno[tamanho_hash];
    }

    @Override
    public void inserir(Aluno Aluno){

        if(buscar(Aluno.getId()) != null){
            sobreescrever(Aluno);
            return;
        }

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

        return null;
    }

    @Override
    protected void rehashing(){
        int tamanho_hash_antigo = tamanho_hash;
        tamanho_hash *= 2;
        Aluno[] aux_arr = new Aluno[tamanho_hash];

        for(int i = 0; i < tamanho_hash_antigo; i++){

            if(arr[i] != null){

                int index = Hash(arr[i].getId());
                int expoente = 1;

                while(aux_arr[index] != null){
                    index = (index + expoente * expoente) % tamanho_hash;
                    expoente++;
                }
                
                aux_arr[index] = arr[i];
            }
        }
        arr = aux_arr;
    }
}