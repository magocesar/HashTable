package Hash;
import aux_proj.Aluno;
import aux_proj.DoubleLinkedList;

public class DllHash extends AbstractHashTable{

    protected DoubleLinkedList<Aluno>[] arr;
    private int quant_dll;

    public DllHash(int tamanho_hash, double fator_carga){
        super(tamanho_hash, fator_carga);
        this.arr = new DoubleLinkedList[tamanho_hash];
        this.quant_dll = 0;
    }

    @Override
    public void inserir(Aluno Aluno){

        if(buscar(Aluno.getId()) != null){
            sobreescrever(Aluno);
            return;
        }

        int index = Hash(Aluno.getId());
        
        if(arr[index] == null){
            arr[index] = new DoubleLinkedList<Aluno>();
            quant_dll++;
        }

        arr[index].append(Aluno);
        quant_itens++;
        iteracoes++;

        if(verificarRehashing()){
            rehashing();
        }
    }

    @Override
    protected void sobreescrever(Aluno Aluno){
        int index = Hash(Aluno.getId());

        for(int i = 0; i < arr[index].count(); i++){
            iteracoes++;

            if(arr[index].get(i).getId() == Aluno.getId()){

                try{
                    arr[index].pop(i);
                }catch(Exception e){
                    System.out.println(e);
                }

                arr[index].append(Aluno);
                return;
            }
        }
    }

    @Override
    public Aluno buscar(int num){
        int index = Hash(num);

        if(arr[index] == null){
            iteracoes++;
            return null;
        }

        for(int i = 0; i < arr[index].count(); i++){
            iteracoes++;
            if(arr[index].get(i).getId() == num){
                return arr[index].get(i);
            }
        }

        return null;
    }

    @Override
    public Aluno remover(int num){

        int index = Hash(num);
        
        if(arr[index] == null){
            iteracoes++;
            return null;
        }

        for(int i = 0; i < arr[index].count(); i++){
            iteracoes++;

            if(arr[index].get(i).getId() == num){
                Aluno rem = arr[index].get(i);

                try{
                    arr[index].pop(i);
                }catch(Exception e){
                    System.out.println(e);
                }

                quant_itens--;

                if(arr[index].count() == 0){
                    arr[index] = null;
                    quant_dll--;
                }

                return rem;

            }
        }

        return null;
    }

    @Override
    protected boolean verificarRehashing(){
        double aux_fator_carga = (double) quant_dll / tamanho_hash;
        if(aux_fator_carga > fator_carga){
            return true;
        }
        return false;
    }

    @Override
    protected void rehashing(){
        int tamanho_hash_antigo = tamanho_hash;
        tamanho_hash *= 2;
        DoubleLinkedList<Aluno>[] aux_arr = new DoubleLinkedList[tamanho_hash];

        //Itera sobre o array compostos de DLLs
        for(int i = 0; i < tamanho_hash_antigo; i++){

            //Se o array de DLLs na posição i não for nulo
            if(arr[i] != null){
                
                //Itera sobre a DLL
                for(int j = 0; j < arr[i].count(); j++){

                    //Calcula o index de acordo com o id do aluno
                    int index = Hash(arr[i].get(j).getId());
                    
                    //Se não houver uma DLL na posição index, cria uma
                    if(aux_arr[index] == null){
                        aux_arr[index] = new DoubleLinkedList<Aluno>();
                    }

                    //Adiciona o aluno na DLL
                    aux_arr[index].append(arr[i].get(j));
                }
            }
        }

        //Atualiza o array de DLLs
        arr = aux_arr;
    }

    @Override
    public void print(){
        System.out.println("------------------");
        System.out.println("Iterações: " + iteracoes);
        System.out.println("Quantidade de itens: " + quant_itens);
        System.out.println("Tamanho do arr: " + tamanho_hash);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null){
                for(int j = 0; j < arr[i].count(); j++){
                    System.out.println("Index: " + i + " : " + arr[i].get(j).getId() + " | " + arr[i].get(j).getNome());
                }
            }
        }
        System.out.println("------------------");
    }
}