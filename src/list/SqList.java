package list;

/*
顺序表：
 */

import java.lang.reflect.Array;

public class SqList<T> {

    //public static final Integer MAX = 1024;

    private T[] data;

    private Integer size;

    @SuppressWarnings("unchecked")
    public SqList(Class<T> type, int size){
        this.data = (T[]) Array.newInstance(type, size);
        this.size = size;
    }

    public void put(int index, T item){
        data[index] = item;
    }

    public T get(int index){
        return data[index];
    }

    public T[] getAll(){
        return data;
    }


    public static void main(String[] args){
        SqList<Integer> integerSqList = new SqList<Integer>(Integer.class, 1024);

        integerSqList.put(0, 99);

        Integer[] arr =  integerSqList.getAll();
        System.out.println(arr);
    }
}
