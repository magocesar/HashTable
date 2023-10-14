package Hash;
import Aluno.Aluno;
abstract public class AbstractHashTable {
    
    protected int quant_itens;
    protected int tamanho_hash;
    protected double fator_carga;
    protected int key;
    protected Aluno[] arr;
    protected int iteracoes;
    protected int colisoes;

    public int obterTamanho(){
        return quant_itens;
    }

    public Integer Hash(Aluno Aluno){
        switch(this.key){
            case 1:
                return Aluno.getId() % tamanho_hash;
            case 2:
                return Hash_ASCII(Aluno.getNome());
            default:
                return null;
        }
    }

    private int Hash_ASCII(String nome){
        int soma = 0;
        for(int i = 0; i < nome.length(); i++){
            soma += nome.charAt(i) * (i + 1);
        }
        return soma % tamanho_hash;
    }

    public AbstractHashTable(int tamanho_hash, double fator_carga, int key){
        this.quant_itens = 0;
        this.tamanho_hash = tamanho_hash;
        this.fator_carga = fator_carga;
        this.key = key;
        this.arr = new Aluno[tamanho_hash];
        this.iteracoes = 0;
        this.colisoes = 0;
    }

    public void printHash(){
        System.out.println("------------------");
        System.out.println("Iterações: " + iteracoes);
        System.out.println("Colisões: " + colisoes);
        System.out.println("Tamanho do arr: " + tamanho_hash);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null){
                System.out.println("Index: " + i + " : " + arr[i].getId() + " | " + arr[i].getNome());
            }
        }
        System.out.println("------------------");
    }

    protected boolean verifyRehashing(){
        double aux_fator_carga = (double) quant_itens / tamanho_hash;
        if(aux_fator_carga > fator_carga){
            return true;
        }
        return false;
    }

    protected void rehashing(){
        int tamanho_hash_antigo = tamanho_hash;
        tamanho_hash *= 2;
        Aluno[] aux_arr = new Aluno[tamanho_hash];
        for(int i = 0; i < tamanho_hash_antigo; i++){
            if(arr[i] != null){
                int index = Hash(arr[i]);
                while(aux_arr[index] != null){
                    index = (index + 1) % tamanho_hash;
                }
                aux_arr[index] = arr[i];
            }
        }
        arr = aux_arr;
    }

    abstract protected void inserir(Aluno Aluno);
    abstract protected Aluno buscar(Aluno Aluno);
    abstract protected Aluno remover(Aluno Aluno);
}
