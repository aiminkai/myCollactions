package org.trashy;

public class LikeArrayList<T> {

    private T[] array;
    private int index;
    private int size = 2;

    public LikeArrayList() {
        this.array = (T[]) new Object[size];
    }

    public void add(T value) {
        if (index == size) {
            size = size * 2;
            arrayCopy((T[]) new Object[size]);
        }
        array[index] = value;
        index++;
    }

    public T get(int index) throws Exception {
        if (index > this.index) {
            throw new Exception("индекс больше размера коллекции");
        }
        return array[index];
    }

    private void arrayCopy(T[] newArray) {
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < index; i++) {
            result.append("[").append(array[i].toString()).append("]");
            if(i != index-1) {
                result.append(",");
            }
        }
        return result.toString();
    }
}
