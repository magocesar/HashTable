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

        boolean flag = false;

        while(arr[index] != null){

            if(arr[index].getId() == -1){
                flag = true;
                break;
            }

            index = (index + expoente * expoente) % tamanho_hash;
            expoente++;
        }
        
        arr[index] = Aluno;
        
        if(!flag){
            quant_itens++;
        }

        if(verificarRehashing()){
            rehashing();
        }
    }

    @Override
    protected void sobreescrever(Aluno Aluno){
            
        int index = Hash(Aluno.getId());
        int expoente = 1;

        while(arr[index] != null){

            if(arr[index].getId() == Aluno.getId()){
                arr[index] = Aluno;
                return;
            }

            index = (index + expoente * expoente) % tamanho_hash;
            expoente++;
        }
    }

    @Override
    public Aluno buscar(int num){

        int index = Hash(num);
        int expoente = 1;

        while(arr[index] != null){

            if(arr[index].getId() == num){
                return arr[index];
            }

            index = (index + expoente * expoente) % tamanho_hash;
            expoente++;
        }

        return null;
    }

    @Override
    public Aluno remover(int num){

        int index = Hash(num);
        int expoente = 1;

        while(arr[index] != null){

            if(arr[index].getId() == num){
                Aluno rem = arr[index];
                arr[index] = new Aluno(-1, "*Removido*");
                return rem;
            }

            index = (index + expoente * expoente) % tamanho_hash;
            expoente++;
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

                if(arr[i].getId() == -1){
                    quant_itens--;
                    continue;
                }

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