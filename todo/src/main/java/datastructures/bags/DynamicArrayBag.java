package datastructures.bags;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class DynamicArrayBag<E> implements Bag<E> {

    private E[] bagArray;
    private int size;

    public DynamicArrayBag() {
        this.bagArray = (E[]) new Object[4];
        this.size = 0;
    }


    public void add (E item) {
        if(item==null) {
            throw new IllegalArgumentException("Item can not be null!");
        }

        bagArray[size]=item;
        size++;

        if(size==bagArray.length) {
            grow();
        }

    }

    public void addAll (Collection<E> c) {
        if(c == null) {
            throw new IllegalArgumentException("Collection can not be null!");
        }

        if(c.contains(null)) {
            throw new IllegalArgumentException("Collection can not have null elements!");
        }

        for(E item : c) {
            this.add(item);
        }
    }

    public boolean contains(E item) {
        if(item==null) {
            throw new IllegalArgumentException("Item can not be null!");
        }

        for(E element : this) {

            if(element.equals(item)) {
                return true;
            }
        }

        /*for(int i = 0; i < size; i++) {
            if(bagArray[i].equals(item)) {
                return true;
            }
        }*/
        return false;
    }

    public boolean isEmpty () {

        return this.size == 0;
    }

    public int size() {

        return this.size;
    }

    private void grow() {

        E[] bagTemp = (E[]) new Object[bagArray.length * 2];

        for(int i=0; i<bagArray.length; i++) {
            bagTemp[i] =  bagArray[i];
        }

        this.bagArray = bagTemp;
    }

    public Iterator<E> iterator () {

        DynamicArrayBagIterator iterator = new DynamicArrayBagIterator();

        return iterator;
    }

    private class DynamicArrayBagIterator implements Iterator<E> {

        private int index;

        public DynamicArrayBagIterator() {

            this.index = 0;
        }

        @Override
        public boolean hasNext() {

            return index < DynamicArrayBag.this.size;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException("There are no more elements!");
            }

            E element = bagArray[index];

            this.index++;

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
        if (!(o instanceof DynamicArrayBag)) return false;

        DynamicArrayBag<?> that = (DynamicArrayBag<?>) o;

        if (size != that.size) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(bagArray, that.bagArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(bagArray);
        result = 31 * result + size;
        return result;
    }
}
