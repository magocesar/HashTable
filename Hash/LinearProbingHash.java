package Hash;
import aux_proj.Aluno;

public class LinearProbingHash extends AbstractHashTable{
    public LinearProbingHash(int tamanho_hash, double fator_carga){
        super(tamanho_hash, fator_carga);
        this.arr = new Aluno[tamanho_hash];
    }

    //Metodo para inserir valores na tabela hash 
    @Override
    public void inserir(Aluno Aluno){

        //Caso a key ja exista na tabela hash entao o valor sera sobrescrito
        if(buscar(Aluno.getId()) != null){
            sobreescrever(Aluno);
            return;
        }

        int index = Hash(Aluno.getId());

        boolean flag = false;

        //Enquanto a posicao index do array nao for nula ele continuara buscando a proxima posicao disponivel 
        //para alocar o dado 
        while(arr[index] != null){

            if(arr[index].getId() == -1){
                flag = true;
                break;
            }

            index = (index + 1) % tamanho_hash;
        }

        //Quando achar uma posicao disponivel o dado sera alocado 
        //e a quantidade de itens alocados sera acrescida 
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

        while(arr[index] != null){
    
            if(arr[index].getId() == Aluno.getId()){
                arr[index] = Aluno;
                return;
            }

            index = (index + 1) % tamanho_hash;
        }
    }


    //Metodo usado para buscar um valor dado dentro da tabela hash 
    @Override
    public Aluno buscar(int num){
        
        //Index = valor que sera buscado 
        int index = Hash(num);

        //Enquanto a posicao index do array nao estiver vazia 
        while(arr[index] != null){

            //Caso a posicao index do array for igual ao valor fornecido entao o valor foi encontrado 
            if(arr[index].getId() == num){
                return arr[index];
            }

            //Caso contrario ele continua a busca para o proximo valor da tabela 
            index = (index + 1) % tamanho_hash;
        }

        return null;
    }

    //Metodo usado para remover um valor da tabela hash 
    @Override
    public Aluno remover(int num){

        int index = Hash(num);

        //Enquanto a posicao index do array for diferente de nulo 
        while(arr[index] != null){

            //Caso o aray na posicao index seja igual ao valor desejado 
            //Instacia-se um objeto Aluno com nome rem que possui o valor do array na posicao index  
            //Declara a posicao index do array como nula e diminuimos 1 item da quantidade de itens 
            if(arr[index].getId() == num){
                Aluno rem = arr[index];
                arr[index] = new Aluno(-1, "*Removido*");
                return rem;
            }

            index = (index + 1) % tamanho_hash;
        }

        return null;
    }

    //Metodo usado para aumentar o numero de posicoes diponiveis na tabela hash 
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

                while(aux_arr[index] != null){
                    index = (index + 1) % tamanho_hash;
                }

                aux_arr[index] = arr[i];
            }
        }
        
        arr = aux_arr;
    }
}