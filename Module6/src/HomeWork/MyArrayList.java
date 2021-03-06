package HomeWork;


import java.util.Arrays;

public class MyArrayList<E> {

    private int defaultCapacity = 10;
    private int size;
    private Object[] array;

    MyArrayList() {
        array = new Object[defaultCapacity];
    }
    MyArrayList(int capacity) {
        if (capacity > 0) array = new Object[capacity];
        else if (capacity == 0) array = new Object[] {};
        else System.out.println("Illegal capacity");
    }

    void add(E value) {
        if (size + 1 > array.length) array = Arrays.copyOf(array,array.length + defaultCapacity);
        else array[size++] = value;
    }
    void remove(int index) {
        if ((size - 1) - index < 0) System.out.println("Missing item");
        else{
            if ((size - 1) - index > 0) {
                for (int i = index; i < array.length - 1; i++) {
                    array[i] = array[i+1];
                }
            }
            array[--size] = null;
        }
    }
    void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
    int size() {
        return size;
    }
    E get(int index) {
        if (index < size) return (E) array[index];
        else {
            System.out.println("Missing item");
            return null;
        }
    }
    void show() {
        for (int i = 0; i < size; i++) {
            if (i == size - 1)
                System.out.println(array[i]);
            else
                System.out.print(array[i] + ", ");
        }
    }
}
