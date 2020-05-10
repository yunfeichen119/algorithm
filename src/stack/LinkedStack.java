package stack;

public class LinkedStack<T> {

    private StackNode<T>    header;

    public LinkedStack(){
        header = new StackNode<T>();
    }

    public void push(T data){
        StackNode<T> node = new StackNode<>(data);
        node.setNext(header.getNext());
        header.setNext(node);
    }

    public T pop(){
        if(header.getNext()  == null){
            throw new RuntimeException("empty stack");
        }
        StackNode<T> node = header.getNext();
        header.setNext(node.getNext());
        return node.getData();
    }


    public T top(){
        if(header.getNext()  == null){
            throw new RuntimeException("empty stack");
        }
        StackNode<T> node = header.getNext();
        return node.getData();
    }


    public boolean isEmpty(){
        if(header.getNext() == null){
            return true;
        }
        return false;
    }


    public static void main(String[] args){
        LinkedStack<Integer> stack = new LinkedStack<>();
        Boolean isEmpty = stack.isEmpty();
        System.out.println(isEmpty);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Integer pop = stack.pop();
        System.out.println(pop);

        pop = stack.pop();
        System.out.println(pop);

        pop = stack.pop();
        System.out.println(pop);

        pop = stack.pop();
        System.out.println(pop);

    }

}
