package aux_proj;

public class DoubleLinkedList<T> {
    private node<T> head, tail;
    private int size;

    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Add to head
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

    //Add to tail
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

    //Add to index
    public void insert(int index, T data) throws Exception{
        if(index < 0 || index > size - 1){
            throw new Exception("Index out of bounds");
        }
        
        if(index == 0){
            push(data);
            return;
        }

        node<T> node = new node<T>(data);

        //Verify if is closer to head or tail
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
            //closer to tail
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

    //Delete head
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

    //Delete tail
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

    //Delete by index
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

        //Verify if is closer to head or tail
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
            //closer to tail
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

    //Return by Index
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

        //Verify if is closer to head or tail
        if(index < size / 2){
            node<T> current = head;

            for(int i = 0; i < index; i++){
                current = current.next;
            }

            return current.data;
        }else{
            //closer to tail
            node<T> current = tail;

            //How many times need to loop?
            int times = size - index - 1;

            for(int i = 0; i < times; i++){
                current = current.prev;
            }

            return current.data;
        }
    }

    //Print as an array
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

    //Reverse the list
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