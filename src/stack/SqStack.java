package stack;

import java.lang.reflect.Array;

public class SqStack<T> {

    private Integer MAX_SIZE = 1024;

    private T[] array;

    private Integer length;

    @SuppressWarnings("unchecked")
    public SqStack(Class<T> type){
        this.array = (T[]) Array.newInstance(type, MAX_SIZE);
        this.length = -1;
    }

    public void push(T data){
        if(length == MAX_SIZE -1){
            throw  new RuntimeException("out of range");
        }
        length++;
        array[length] = data;

    }


    public T pop(){
        if(length == -1){
            throw  new RuntimeException("empty stack");
        }
        length--;
        return array[length+1];

    }

    public T top(){
        if(length == -1){
            throw  new RuntimeException("empty stack");
        }
        return array[length];
    }

    public Boolean isEmpty(){
        return length == -1;
    }

    public Boolean isFull(){
        return length == MAX_SIZE -1;
    }

    public Integer len() {
        return length+1;
    }

    public T index(int i){
        if(i > length){
            throw  new RuntimeException("invalid index");
        }
        return array[i];
    }

    public static void main(String[] args){

        SqStack<Integer> stack = new SqStack<Integer>(Integer.class);

        Boolean isEmpty1 = stack.isEmpty();
        System.out.println(isEmpty1);

        for(int i = 1; i <= 10; i++){
            stack.push(i);
        }

        Integer d1 = stack.pop();
        System.out.println(d1);
        Integer d2 = stack.pop();
        System.out.println(d2);
        Integer d3 = stack.pop();
        System.out.println(d3);

        Boolean isEmpty2 = stack.isEmpty();
        System.out.println(isEmpty2);

    }

}
