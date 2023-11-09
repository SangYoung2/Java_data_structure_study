package Chapter3.section5;

import java.util.Arrays;

public class MyArrayList<E> {
    /*
        list
        여러 개의 데이터를 저장하고, 임의의 위치에 새로운 데이터를 추가하거나 데이터의 삭제가 가능하고
        임의의 위치의 데이터를 읽을 수 있고, 용량에 제한이 없음
     */

    private static final int INIT_CAPACITY = 10;
    private E [] theData;
    private int size;
    private int capacity = INIT_CAPACITY;


    public MyArrayList() {
        theData = (E []) new Object [INIT_CAPACITY];
        size = 0;

    }

    public void add(int index, E anEntry){ // 지정한 위치에 add
        if(index < 0 || index > size) { // error or exception
            throw new ArrayIndexOutOfBoundsException(index); // 오류 발생
        }
        if(size >= capacity) {
            reallocate();
        }
        for (int i = size-1; i >= index; i--) {
            theData[i+1] = theData[i];
        }
        theData[index] = anEntry;
    }

    private void reallocate() {
        capacity *= 2;
        theData = Arrays.copyOf(theData, capacity); // 자바에서 제공해주는 Arrays의 기능 (배열이 가득 찼을 때 새로운 배열로 이동시켜줌)
    }

    public void add(E enEntry){ // 맨 뒤에 add
        add(size, enEntry);
    }

    public int size() {
        return size;
    }

    public int indexOf(E anEntry) {
        for (int i = 0; i < size; i++) {
            if(theData[i].equals(anEntry)){ // 어떠한 타입의 데이터가 들어 올지 모르기에 "=="이 아닌 equals를 사용하여 확인한다.
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    public E set(int index, E newValue) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    public E remove (int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        for (int i = index+1; i < size; i++) {
            theData[i-1] = theData[i];
        }
        size--;
        return returnValue;
    }

    public static void main(String[] args) {
        MyArrayList<String> test = new MyArrayList<>();
        test.add(1,"Hello");
    }
}
