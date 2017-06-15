package datastructures.stacks;


import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;

public abstract class StackTests {

    protected Stack<String> stack;
    protected Stack<String> other;

    @Test(expected = IllegalArgumentException.class)
    public void push_Should_throw_an_exception_When_element_is_null () throws Exception {
        this.stack.push(null);
    }

    @Test
    public void push_Should_add_new_element_When_element_is_valid () throws Exception {
        this.stack.push("item");

        Assert.assertEquals(1, this.stack.size());
        Assert.assertFalse(this.stack.isEmpty());
        Assert.assertTrue(this.stack.contains("item"));
    }

    @Test
    public void push_Should_add_several_elements () throws Exception {
        this.stack.push("item 1");
        this.stack.push("item 2");
        this.stack.push("item 3");
        this.stack.push("item 4");
        this.stack.push("item 5");

        Assert.assertEquals(5, this.stack.size());
        Assert.assertFalse(this.stack.isEmpty());
        Assert.assertTrue(this.stack.contains("item 1"));
        Assert.assertTrue(this.stack.contains("item 2"));
        Assert.assertTrue(this.stack.contains("item 3"));
        Assert.assertTrue(this.stack.contains("item 4"));
        Assert.assertTrue(this.stack.contains("item 5"));
    }

    @Test(expected = EmptyStackException.class)
    public void peek_Should_throw_an_exception_When_stack_is_empty () throws Exception {
        this.stack.peek();
    }

    @Test
    public void peek_Should_return_last_element_pushed_but_not_remove_it () throws Exception {
        this.stack.push("item 1");
        this.stack.push("item 2");

        String element = this.stack.peek();

        Assert.assertEquals(2, this.stack.size());
        Assert.assertEquals("item 2", element);
    }

    @Test(expected = EmptyStackException.class)
    public void pop_Should_throw_an_exception_When_stack_is_empty () throws Exception {
        this.stack.pop();
    }

    @Test
    public void pop_Should_return_last_element_pushed_and_remove_it () throws Exception {
        this.stack.push("item 1");
        this.stack.push("item 2");

        String element = this.stack.pop();

        Assert.assertEquals(1, this.stack.size());
        Assert.assertEquals("item 2", element);
    }

    @Test
    public void equals_Should_return_false_When_other_is_not_a_stack () throws Exception {

        boolean result = this.stack.equals(new Object());

        Assert.assertFalse(result);
    }

    @Test
    public void equals_Should_return_false_When_stacks_have_different_sizes () throws Exception {
        this.stack.push("a");

        boolean result = this.stack.equals(this.other);

        Assert.assertFalse(result);
        Assert.assertNotEquals(this.stack.hashCode(), this.other.hashCode());
    }

    @Test
    public void equals_Should_return_false_When_stacks_have_same_size_but_different_elements () throws Exception {
        this.stack.push("a");
        this.other.push("b");

        boolean result = this.stack.equals(this.other);

        Assert.assertFalse(result);
        Assert.assertNotEquals(this.stack.hashCode(), this.other.hashCode());
    }

    @Test
    public void equals_Should_return_false_When_stacks_have_same_elements_but_in_different_order () throws Exception {
        this.stack.push("a");
        this.stack.push("b");
        this.other.push("b");
        this.other.push("a");

        boolean result = this.stack.equals(this.other);

        Assert.assertFalse(result);
        Assert.assertNotEquals(this.stack.hashCode(), this.other.hashCode());
    }

    @Test
    public void equals_Should_return_true_When_stacks_have_same_elements_in_same_order () throws Exception {
        this.stack.push("a");
        this.stack.push("b");
        this.other.push("a");
        this.other.push("b");

        boolean result = this.stack.equals(this.other);

        Assert.assertTrue(result);
        Assert.assertEquals(this.stack.hashCode(), this.other.hashCode());
    }
}