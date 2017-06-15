package datastructures.queues;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayQueue<E> implements Queue<E> {

    private E[] queueArray;
    private int head;
    private int tail;

    public DynamicArrayQueue() {

        this.queueArray = (E[]) new Object[4];
        this.head = 0;
        this.tail = 0;
    }

    public void enqueue (E item) {
        if(item == null) {
            throw new IllegalArgumentException("Item can not be null!");
        }

        queueArray[tail] = item;
        tail++;

        if(this.size() == queueArray.length) {
            grow();
        } else {
            adjust();
        }

    }

    public E dequeue () {
        if(this.isEmpty()) {

            throw new IllegalStateException("Queue can not be empty!");
        }

        E element = queueArray[head];
        queueArray[head] = null;
        head++;

        if(this.size() <= queueArray.length / 4) {
            adjust();
            shrink();
        }

        return element;
    }

    public E peek () {
        if(this.isEmpty()) {
            throw new IllegalStateException("Queue can not be empty!");
        }

        E element = queueArray[head];

        return element;
    }

    public boolean contains (E item) {
        if(item == null) {

            throw new IllegalArgumentException("Item can not be null!");
        }

        for(int i = head; i < tail; i++) {
            if(queueArray[i].equals(item)) {

                return true;
            }
        }

        return false;
    }

    public boolean isEmpty () {

        return this.size() == 0;
    }

    public int size () {

        return (this.tail - this.head);
    }

    private void adjust() {

        E[] queueTemp = (E[]) new Object[queueArray.length];
        int index = 0;

        for(int i = head; i < tail; i++) {
            queueTemp[index] = queueArray[i];
            index++;
        }

        tail = this.size();
        head = 0;

        queueArray = queueTemp;
    }

    private void grow() {

        E[] queueTemp = (E[]) new Object[queueArray.length * 2];

        for(int i = 0; i < queueArray.length; i++) {
            queueTemp[i] = queueArray[i];

        }
        queueArray = queueTemp;

    }

    private void shrink() {

        E[] queueTemp = (E[]) new Object[queueArray.length / 2];

        for(int i = 0; i < queueTemp.length; i++) {
            queueTemp[i] = queueArray[i];
        }
        queueArray = queueTemp;

    }

    public Iterator<E> iterator () {

        DynamicArrayQueueIterator iterator = new DynamicArrayQueueIterator();

        return iterator;
    }

    private class DynamicArrayQueueIterator implements Iterator<E> {

        private int index;

        public DynamicArrayQueueIterator() {

            this.index = head;
        }

        @Override
        public boolean hasNext() {

            return index < tail;
        }

        @Override
        public E next() {
            if(!hasNext()) {

                throw new NoSuchElementException("There are no more elements");
            }

            E element = queueArray[index];
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
        if (!(o instanceof DynamicArrayQueue)) return false;

        DynamicArrayQueue<?> that = (DynamicArrayQueue<?>) o;

        if (head != that.head) return false;
        if (tail != that.tail) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(queueArray, that.queueArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(queueArray);
        result = 31 * result + head;
        result = 31 * result + tail;
        return result;
    }

}
