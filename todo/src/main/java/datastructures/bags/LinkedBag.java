package datastructures.bags;


import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<E> implements Bag<E> {

    private Node<E> head;
    private int size;

    private class Node<T> {

        private T data;
        private Node next;

        public Node (T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            if (!data.equals(node.data)) return false;
            return next != null ? next.equals(node.next) : node.next == null;
        }

        @Override
        public int hashCode() {
            int result = data.hashCode();
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }

    }

    public LinkedBag () {
        this.head = null;
        this.size = 0;

    }

    public void add (E item) {
        if(item == null) {
            throw new IllegalArgumentException("Item can not be null!");
        }

        Node<E> node = new Node<>(item);
        node.next = this.head;
        this.head = node;
        size++;

    }

    public void addAll (Collection<E> c) {
        if(c == null) {
            throw new IllegalArgumentException("Collection can not be null!");
        }

        if(c.contains(null)) {
            throw new IllegalArgumentException("Collection can not contain null elements!");
        }

        for(E item : c){
            add(item);
        }

    }

    public boolean contains (E item) {
        if(item == null) {
            throw new IllegalArgumentException ("Item can not be null!");
        }

        for (E element : this) {

            if(item.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty () {

        return this.head == null;
    }

    public int size () {

        return this.size;
    }

    public Iterator<E> iterator () {

        LinkedBagIterator iterator = new LinkedBagIterator();

        return iterator;
    }

    private class LinkedBagIterator implements Iterator<E> {

        private Node<E> currentNode;

        public LinkedBagIterator() {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {

           return currentNode != null;
        }

        @Override
        public E next() {
           if(!hasNext()) {
               throw new NoSuchElementException("There are no more nodes!");
           }

           E element = currentNode.data;
           currentNode = currentNode.next;

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
        if (!(o instanceof LinkedBag)) return false;

        LinkedBag<?> linkedBag = (LinkedBag<?>) o;

        if (size != linkedBag.size) return false;
        return head != null ? head.equals(linkedBag.head) : linkedBag.head == null;
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }

}
