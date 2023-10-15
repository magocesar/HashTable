package aux_proj;

public class DoubleLinkedList<T> {
    private node<T> head, tail;
    private int size;

    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Adiciona no fim
    public void push(T data){
        size++;
        node<T> node = new node<T>(data);

        if(head == null){
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    //Adiciona no comeco
    public void append(T data){
        size++;
        node<T> node = new node<T>(data);
        if(tail == null){
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    //Adiciona ao index 
    public void insert(int index, T data) throws Exception{
        if(index < 0 || index > size - 1){
            throw new Exception("Index out of bounds");
        }
        
        if(index == 0){
            push(data);
            return;
        }

        node<T> node = new node<T>(data);

        //Verifica se esta proximo do fim ou do comeco 
        if(index < size / 2){
            //closer to head
            node<T> current = head;

            for(int i = 0; i < index; i++){
                current = current.next;
            }

            node.next = current;
            node.prev = current.prev;
            current.prev.next = node;
            current.prev = node;
        }else{
            //proximo ao comeco 
            node<T> current = tail;

            //How many times need to loop?
            int times = size - index - 1;

            for(int i = 0; i < times; i++){
                current = current.prev;
            }

            node.next = current;
            node.prev = current.prev;
            current.prev.next = node;
            current.prev = node;
        }

        size++;
    }

    //Deleta o fim 
    public void HeadDel() throws Exception{
        if(head == null){
            throw new Exception("Empty list");
        }

        size--;


        if(head == tail){
            head = null;
            tail = null;
            return;
        }

        node<T> aux = head;
        head = head.next;
        head.prev = null;
        aux.next = null;
    }

    //Deleta o comeco 
    public void TailDel() throws Exception{
        if(tail == null){
            throw new Exception("Empty list");
        }

        size--;

        if(head == tail){
            head = null;
            tail = null;
            return;
        }

        node<T> aux = tail;
        tail = tail.prev;
        tail.next = null;
        aux.prev = null;
    }

    //Deleta por index 
    public void pop(int index) throws Exception{
        if(head == null){
            throw new Exception("Empty list");
        }

        if(index == 0){
            HeadDel();
            return;
        }

        if(index == size - 1){
            TailDel();
            return;
        }

        if(index < 0 || index > size - 1){
            throw new Exception("Index out of bounds");
        }

        //Verifica se esta mais proximo do comeco ou do fim 
        if(index < size / 2){
            node<T> current = head;

            for(int i = 0; i < index; i++){
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.prev = null;
            current.next = null;
        }else{
            //Mais proximo do comeco
            node<T> current = tail;

            //How many times need to loop?
            int times = size - index - 1;

            for(int i = 0; i < times; i++){
                current = current.prev;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.prev = null;
            current.next = null;
        }
        size--;
    }

    //Get size
    public int count(){
        return size;
    }

    //Retorna o index 
    public T get(int index){
        if(index < 0 || index > size - 1){
            return null;
        }

        if(index == 0){
            return head.data;
        }

        if(index == size - 1){
            return tail.data;
        }

        //Verifica se esta proximo do comeco ou do fim
        if(index < size / 2){
            node<T> current = head;

            for(int i = 0; i < index; i++){
                current = current.next;
            }

            return current.data;
        }else{
            //cmais proximo do comeco 
            node<T> current = tail;

            //How many times need to loop?
            int times = size - index - 1;

            for(int i = 0; i < times; i++){
                current = current.prev;
            }

            return current.data;
        }
    }

    //Printa como um array 
    public void print(){
        if(head == null){
            System.out.println("[]");
        }
        else{
            node<T> current = head;
            System.out.print("[");
            while(current != null){
                System.out.print(current.data);
                if(current.next != null){
                    System.out.print(", ");
                }
                current = current.next;
            }
            System.out.println("]");
        }
    }
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public java.lang.Integer index(T data){
        node<T> current = head;
        int index = 0;
        while(current != null){
            if(current.data == data){
                return index;
            }
            index++;
            current = current.next;
        }
        return null;
    }

    //Inverte a lista 
    public void reverse(){
        node<T> current = head;
        node<T> aux = null;
        while(current != null){
            aux = current.prev;
            current.prev = current.next;
            current.next = aux;
            current = current.prev;
        }
        aux = head;
        head = tail;
        tail = aux;
    }
}

class node<T>{
    T data;
    node<T> prev, next;

    public node(T data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}