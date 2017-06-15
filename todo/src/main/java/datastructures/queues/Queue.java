package datastructures.queues;


public interface Queue<E> extends Iterable<E> {

    /**
     * adds an item onto the end of this queue.
     *
     * @param   item   the item to be added onto this queue.
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this queue
     */
    void enqueue(E item);

    /**
     * removes and returns the item in the head of this queue.
     *
     * @return the first element in this queue.
     * @throws IllegalStateException if queue is empty.
     */
    E dequeue();

    /**
     * returns the item in the head of this queue without removing it.
     *
     * @return the first element in this queue.
     * @throws IllegalStateException if queue is empty.
     */
    E peek();

    /**
     * Returns true if this queue contains the specified element.
     *
     * @param item element whose presence in this queue is to be tested
     * @return true if this queue contains the specified element
     * @throws IllegalArgumentException if the specified element is null.
     */
    boolean contains(E item);

    /**
     * Returns true if the queue contains no elements, false otherwise.
     *
     * @return true if the queue contains no elements, false otherwise.
     */
    boolean isEmpty();

    /**
     * Return the number of elements in this queue.
     *
     * @return the number of elements in this queue.
     */
    int size();

    // Comparison and hashing
    /**
     * Compares the specified object with this queue for equality.
     * Returns true if and only if:
     * - the specified object is also a queue,
     * - both queue have the same size,
     * - and equal elements in the two queues in same order.
     *
     * @param o the object to be compared for equality with this queue
     * @return true if the specified object is equal to this queue
     */
    boolean equals(Object o);

    /**
     * Returns the hash code value for this queue. The hash code of a queue
     * is defined to be the result of the following calculation:
     * <pre>{@code
     *     int hashCode = 1;
     *     for (E e : queue)
     *         hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
     * }</pre>
     * This ensures that queue1.equals(queue2) implies that
     * queue1.hashCode()==queue2.hashCode() for any two queues,
     * queue1 and queue2, as required by the general
     * contract of {@link Object#hashCode}.
     *
     * @return the hash code value for this queue
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();
}