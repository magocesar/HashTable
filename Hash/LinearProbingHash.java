package Hash;
import aux_proj.Aluno;

public class LinearProbingHash extends AbstractHashTable{
    public LinearProbingHash(int tamanho_hash, double fator_carga){
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

        while(arr[index] != null){
            index = (index + 1) % tamanho_hash;
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

        while(arr[index] != null){

            if(arr[index].getId() == num){
                return arr[index];
            }

            index = (index + 1) % tamanho_hash;
        }

        return null;
    }

    @Override
    public Aluno remover(int num){

        int index = Hash(num);

        while(arr[index] != null){

            if(arr[index].getId() == num){
                Aluno rem = arr[index];
                arr[index] = null;
                quant_itens--;
                return rem;
            }

            index = (index + 1) % tamanho_hash;
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

                while(aux_arr[index] != null){
                    index = (index + 1) % tamanho_hash;
                }

                aux_arr[index] = arr[i];
            }
        }
        
        arr = aux_arr;
    }
}