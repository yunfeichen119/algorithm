package list;

/*
顺序表：
 */

import java.lang.reflect.Array;

public class SqList<T> {

    private T[] data;

    private int maxSize;

    private int length;

    @SuppressWarnings("unchecked")
    public SqList(Class<T> type, int maxSize){
        this.data = (T[]) Array.newInstance(type, maxSize);
        this.maxSize = maxSize;
        this.length = 0;
    }

    public T get(int index){
        if(index < 0 || index >= length){
            throw new RuntimeException("out of range");
        }
        return data[index];
    }


    public Integer locate(T item){
        for(int i = 0; i < length; i++){
            if(item.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    public void insert(int index, T item){

        if(length >= maxSize - 1){
            throw new RuntimeException("out of range");
        }
        if(index > length){
            throw new RuntimeException("out of range");
        }
        if(index == length){
            data[index] = item;
        }else{
            for(int i = length -1 ; i >= index; i--){
                data[i+1] = data[i];
            }
            data[index] = item;
        }
        length++;
    }


    public void delete(int index){
        if(index < 0 || index > length -1){
            throw new RuntimeException("out of range");
        }
        for(int i = index; i < length -1; i++){
            data[i] = data[i+1];
        }
        length--;
    }



    public static void main(String[] args){
        SqList<Integer> integerSqList = new SqList<Integer>(Integer.class, 10);

        for(int i = 5; i >= 0; i--){
            integerSqList.insert(0, i);
        }

        Integer item = integerSqList.locate(3);
        System.out.println(item);

        integerSqList.delete(3);
        System.out.println(integerSqList);
    }
}
