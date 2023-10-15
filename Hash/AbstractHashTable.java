package Hash;
import aux_proj.Aluno;
abstract public class AbstractHashTable {
    
    protected int quant_itens, tamanho_hash;
    protected double fator_carga;
    protected Aluno[] arr;

    public int Hash(int num){
        return num % tamanho_hash;
    }

    //construtor da tabela hash 
    public AbstractHashTable(int tamanho_hash, double fator_carga){
        this.quant_itens = 0;
        this.tamanho_hash = tamanho_hash;
        this.fator_carga = fator_carga;
    }

    //Funcao usada para printar os valores da tabela hash 
    public void print(){
        System.out.println("------------------");
        System.out.println("Quantidade de itens: " + quant_itens);
        System.out.println("Tamanho do arr: " + tamanho_hash);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null){
                System.out.println("Index: " + i + " : " + arr[i].getId() + " | " + arr[i].getNome());
            }
        }
        System.out.println("------------------");
    }

    protected boolean verificarRehashing(){
        double aux_fator_carga = (double) quant_itens / tamanho_hash;
        if(aux_fator_carga > fator_carga){
            return true;
        }
        return false;
    }

    
    protected void sobreescrever(Aluno Aluno){
        int index = Hash(Aluno.getId());
        arr[index] = Aluno;
    }

    abstract protected void inserir(Aluno Aluno);
    abstract protected Aluno buscar(int num);
    abstract protected Aluno remover(int num);
    abstract protected void rehashing();
}