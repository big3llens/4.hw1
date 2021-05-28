package hw2;

import java.util.Arrays;

public class ArrayListImpl<E> implements ArrayList<E>{

    private E[] data;
    private int size;

    public ArrayListImpl(int initSize){
        this.data = (E[]) new Object[initSize];
        this.size = 0;
    }

    @Override
    public void add(E value) {

        if (data.length == size){
            data = Arrays.copyOf(data, (int) (size * 1.5));
        }
        data[size++] = value;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return index != -1 && remove(index) != null;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedValue = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);

        data[--size] = null;
        return removedValue;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(value)) return i;
        }
        return -1;
    }

    public void checkIndex(int index){
        if (index < 0 || index >= size){
            String errorMsg = String.format("Incorrect 'index': %d; max value is %d",
                    index, size - 1);
            throw new IndexOutOfBoundsException(errorMsg);
        }
    }

    @Override
    public boolean contains(E value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(value)) return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "ArrayListImpl{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
