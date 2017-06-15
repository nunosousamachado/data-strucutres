package datastructures.stacks;


import java.util.EmptyStackException;

public interface Stack<E> extends Iterable<E> {

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param   item   the item to be pushed onto this stack.
     * @throws IllegalArgumentException if some property of this element
     *         prevents it from being added to this stack
     */
    void push(E item);

    /**
     * Removes the object at the top of this stack and returns that
     * object.
     *
     * @return  The object at the top of this stack.
     * @throws EmptyStackException  if this stack is empty.
     */
    E pop();

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return  the object at the top of this stack.
     * @throws  EmptyStackException  if this stack is empty.
     */
    E peek();

    /**
     * Returns true if this stack contains the specified element.
     *
     * @param item element whose presence in this stack is to be tested
     * @return true if this stack contains the specified element
     * @throws IllegalArgumentException if the specified element is null.
     */
    boolean contains(E item);

    /**
     * Returns true if the stack contains no elements, false otherwise.
     *
     * @return true if the stack contains no elements, false otherwise.
     */
    boolean isEmpty();

    /**
     * Return the number of elements in this stack.
     *
     * @return the number of elements in this stack.
     */
    int size();

    // Comparison and hashing
    /**
     * Compares the specified object with this stack for equality.
     * Returns true if and only if:
     * - the specified object is also a stack,
     * - both stacks have the same size,
     * - and equal elements in the two stacks in same order.
     *
     * @param o the object to be compared for equality with this stack
     * @return true if the specified object is equal to this stack
     */
    boolean equals(Object o);

    /**
     * Returns the hash code value for this stack. The hash code of a stack
     * is defined to be the result of the following calculation:
     * <pre>{@code
     *     int hashCode = 1;
     *     for (E e : Stack)
     *         hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
     * }</pre>
     * This ensures that stack1.equals(stack2) implies that
     * stack1.hashCode()==stack2.hashCode() for any two stacks,
     * stack1 and stack2, as required by the general
     * contract of {@link Object#hashCode}.
     *
     * @return the hash code value for this stack
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();

}
