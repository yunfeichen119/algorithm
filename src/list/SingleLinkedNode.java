package list;

public class SingleLinkedNode<T> {

    private T   data;

    private SingleLinkedNode<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SingleLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(SingleLinkedNode<T> next) {
        this.next = next;
    }

    public SingleLinkedNode(T data, SingleLinkedNode<T> next){
        this.data = data;
        this.next = next;
    }
}
