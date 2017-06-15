package datastructures.bags;

import java.util.Collection;

public interface Bag<E> extends Iterable<E> {

    /**
     * Adds the specified element to the bag
     *
     * @param item element to be appended to this bag
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this bag
     */
    void add(E item);

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator (optional operation).  The behavior of this
     * operation is undefined if the specified collection is modified while
     * the operation is in progress.  (Note that this will occur if the
     * specified collection is this list, and it's nonempty.)
     *
     * @param c collection containing elements to be added to this bag
     * @throws IllegalArgumentException if some property of an element of the
     *         specified collection prevents it from being added to this list
     * @see #add(E)
     */
    void addAll(Collection<E> c);

    /**
     * Returns true if this bag contains the specified element.
     *
     * @param item element whose presence in this bag is to be tested
     * @return true if this bag contains the specified element
     * @throws IllegalArgumentException if the specified element is null.
     */
    boolean contains(E item);

    /**
     * Returns true if the bag contains no elements, false otherwise.
     *
     * @return true if the bag contains no elements, false otherwise.
     */
    boolean isEmpty();

    /**
     * Return the number of elements in this bag.
     *
     * @return the number of elements in this bag.
     */
    int size();

    // Comparison and hashing
    /**
     * Compares the specified object with this bag for equality.
     * Returns true if and only if:
     * - the specified object is also a bag,
     * - both bags have the same size,
     * - and equal elements in the two bags in same order.
     *
     * @param o the object to be compared for equality with this bag
     * @return true if the specified object is equal to this bag
     */
    boolean equals(Object o);

    /**
     * Returns the hash code value for this bag. The hash code of a bag
     * is defined to be the result of the following calculation:
     * <pre>{@code
     *     int hashCode = 1;
     *     for (E e : bag)
     *         hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
     * }</pre>
     * This ensures that <tt>bag1.equals(bag2)</tt> implies that
     * <tt>bag1.hashCode()==bag2.hashCode()</tt> for any two bags,
     * <tt>bag1</tt> and <tt>bag2</tt>, as required by the general
     * contract of {@link Object#hashCode}.
     *
     * @return the hash code value for this bag
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();

}
