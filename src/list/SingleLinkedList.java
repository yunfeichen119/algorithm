package list;

public class SingleLinkedList<T> {

    private SingleLinkedNode<T> header;

    public SingleLinkedList(){
        header = new SingleLinkedNode<T>(null, null);
    }

    public void addHead(T data){
        SingleLinkedNode<T> node = new SingleLinkedNode<T>(data, null);
        node.setNext(header.getNext());
        header.setNext(node);
    }

    public void addTail(T data){
        SingleLinkedNode<T> pointer = header;
        while (pointer.getNext() != null){
            pointer = pointer.getNext();
        }
        SingleLinkedNode<T> node = new SingleLinkedNode<T>(data, null);
        pointer.setNext(node);
    }

    public SingleLinkedNode<T> delete(T data){
        SingleLinkedNode<T> prev = header;
        while (prev.getNext() != null){
            if(data.equals(prev.getNext().getData())){
                SingleLinkedNode<T> node = prev.getNext();
                prev.setNext(node.getNext());
                return node;
            }else{
                prev = prev.getNext();
            }
        }
        return null;
    }

    public static void main(String[] args){

        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();

        list.addHead(1);
        list.addHead(2);
        list.addHead(3);

        list.addTail(91);
        list.addTail(92);
        list.addTail(93);

        SingleLinkedNode<Integer> node1 = list.delete(92);
        System.out.println(node1.getData());
        SingleLinkedNode<Integer> node2 = list.delete(2);
        System.out.println(node2.getData());

    }
}
