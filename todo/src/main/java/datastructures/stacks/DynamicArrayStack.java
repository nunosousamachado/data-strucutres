package datastructures.stacks;


import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class DynamicArrayStack<E> implements Stack<E> {

    private E[] stackArray;
    private int size;

    public DynamicArrayStack() {
        this.stackArray = (E[]) new Object[4];
        this.size = 0;
    }


    public void push (E item) {
        if(item == null) {
            throw new IllegalArgumentException("Item can not be null");
        }

        stackArray[size] = item;
        size++;

        if(size == stackArray.length) {
            grow();
        }
    }

    public E pop () {
        if(this.isEmpty()) {
            throw new EmptyStackException();
        }

        E element = stackArray[size-1];
        stackArray[size-1] = null;
        size--;

        if(size <= (stackArray.length / 4)) {
            shrink();
        }
        return element;
    }

    public E peek () {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        E element = stackArray[size-1];

        return element;
    }

    public boolean contains (E item) {
        if(item == null) {
            throw new IllegalArgumentException("Item can not be null!");
        }

        for(int i = 0; i < size; i++) {
            if(stackArray[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty () {

        return this.size == 0;
    }

    public int size () {

        return this.size;
    }

    private void grow() {

        E[] stackTemp = (E[]) new Object[stackArray.length * 2];

        for(int i = 0; i < stackArray.length; i++) {
            stackTemp[i] =  stackArray[i];
        }

        stackArray = stackTemp;
    }

    private void shrink() {

        E[] stackTemp = (E[]) new Object[stackArray.length / 2];

        for(int i = 0; i < stackTemp.length; i++) {
            stackTemp[i] = stackArray[i];
        }

        stackArray = stackTemp;
    }

    public Iterator<E> iterator () {

        DynamicArrayStackIterator iterator = new DynamicArrayStackIterator();

        return iterator;
    }


    private class DynamicArrayStackIterator implements Iterator {

        private int index;

        public DynamicArrayStackIterator() {

            this.index = 0;
        }

        @Override
        public boolean hasNext() {

            return index < DynamicArrayStack.this.size;
        }

        @Override
        public E next() {
            if(!hasNext()) {

              throw new NoSuchElementException("There are no more elements!");
            }

            E element = stackArray[index];

            index++;

            return element;
        }

        @Override
        public void remove() {

            throw new UnsupportedOperationException("Not able to remove elements!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DynamicArrayStack)) return false;

        DynamicArrayStack<?> that = (DynamicArrayStack<?>) o;

        if (size != that.size) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(stackArray, that.stackArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(stackArray);
        result = 31 * result + size;
        return result;
    }

}