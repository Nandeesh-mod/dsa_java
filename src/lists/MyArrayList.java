package lists;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private T[] items;

    public int Size(){
        return size;
    }
    public MyArrayList(){
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public boolean isEmpty(){
       return  Size() == 0;
    }


    public void ensureCapacity(int newCapacity){
        if(newCapacity < size){
            return;
        }

        T[] old = items;
        items = (T[]) new Object[newCapacity];
        for(int i = 0; i < Size(); i++){
            items[i] = old[i];
        }
    }

    public void add(int idx, T x){
        if(items.length == Size()) {
            ensureCapacity(Size() * 2 + 1);
        }
        for(int i = size ; i > idx; i++){
            items[i] = items[i -1];
        }
        items[idx] = x;
        size++;
    }

    public boolean Add(T x){
        add(Size(), x);
        return true;
    }

    public T remove(int idx){
        T removedItem = items[idx];
        for(int i = idx; i < Size() -1; i++){
            items[i] = items[i +1];
        }
        size --;
        return removedItem;
    }

    public T set(int idx, T newVal){
        if(idx < 0 || idx > Size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = items[idx];
        items[idx] = newVal;
        return old;
    }

    public T get(int idx){
        if(idx < 0 || idx > Size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[idx];
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>{
        private int current = 0;
        @Override
        public boolean hasNext() {
            return current < Size();
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            return items[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
