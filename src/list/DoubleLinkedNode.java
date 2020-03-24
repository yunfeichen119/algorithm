package list;

public class DoubleLinkedNode<T> {

    private T data;

    private DoubleLinkedNode<T> prev;

    private DoubleLinkedNode<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleLinkedNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedNode<T> prev) {
        this.prev = prev;
    }

    public DoubleLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode<T> next) {
        this.next = next;
    }

    public DoubleLinkedNode(T data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
