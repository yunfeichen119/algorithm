package list;

public class DoubleLinkedList<T> {

    private DoubleLinkedNode<T> header;

    private DoubleLinkedNode<T> tail;

    public DoubleLinkedList(){
        header = new DoubleLinkedNode<T>(null);
        tail = header;
    }

    public DoubleLinkedList(T[] itemArray){
        header = new DoubleLinkedNode<T>(null);
        tail = header;

        for (T item : itemArray) {
            DoubleLinkedNode<T> node = new DoubleLinkedNode<T>(item);
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }

    }

    public DoubleLinkedNode<T> findNode(T data){
        DoubleLinkedNode<T> p = header.getNext();
        while (p != null){
            if(p.getData().equals(data)){
                return p;
            }else{
                p = p.getNext();
            }
        }
        return null;
    }

    public int insert(int index, T data){
        int j = 0;
        DoubleLinkedNode<T> p = header.getNext();
        while(j < index -1 && p != null){
            j++;
            p = p.getNext();
        }
        if(p == null){
            return 0;
        }

        DoubleLinkedNode<T> node = new DoubleLinkedNode<T>(data);
        node.setNext(p.getNext());
        node.setPrev(p);
        if(p.getNext() != null){
            p.getNext().setPrev(node);
        }
        p.setNext(node);
        return 1;
    }


    public DoubleLinkedNode<T> delete(int index){
        int j = 0;
        DoubleLinkedNode<T> p = header.getNext();
        while(j < index -1 && p != null){
            j++;
            p = p.getNext();
        }
        if(p == null){
            return null;
        }
        if(p.getNext() == null){
            return null;
        }
        DoubleLinkedNode<T> node = p.getNext();
        if(node.getNext() != null){
            node.getNext().setPrev(p);
        }
        p.setNext(node.getNext());
        return node;
    }


    public static void main(String[] args){

        Integer[] arr = {1, 2, 3, 4, 5, 6};

        DoubleLinkedList<Integer> list = new  DoubleLinkedList<Integer>(arr);

        list.insert(2, 11);

        list.delete(4);


    }

}
