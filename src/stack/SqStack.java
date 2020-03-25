package stack;

import java.lang.reflect.Array;

public class SqStack<T> {

    private Integer MAX_SIZE = 1024;

    private T[] array;

    private Integer length;

    @SuppressWarnings("unchecked")
    public SqStack(Class<T> type){
        this.array = (T[]) Array.newInstance(type, MAX_SIZE);
        this.length = 0;
    }

    public void push(T data){
        if(length == MAX_SIZE -1){
            throw  new RuntimeException("out of range");
        }
        array[length] = data;
        length++;
    }


    public T pop(){
        if(length == 0){
            throw  new RuntimeException("empty stack");
        }
        length--;
        return array[length];
    }

    public Boolean isEmpty(){
        return length == 0;
    }

    public Boolean isFull(){
        return length == MAX_SIZE -1;
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
