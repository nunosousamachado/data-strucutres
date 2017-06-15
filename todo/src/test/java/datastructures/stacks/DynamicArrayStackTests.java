package datastructures.stacks;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DynamicArrayStackTests extends StackTests {

    @Before
    public void setUp () throws Exception {
        this.stack = new DynamicArrayStack<String>();
        this.other = new DynamicArrayStack<String>();

    }

    @Test
    public void push_Should_add_element_and_grow_array_When_stack_is_full() {

        this.stack.push("Item1");
        this.stack.push("Item2");
        this.stack.push("Item3");
        this.stack.push("Item4");
        this.stack.push("Item5");

        Assert.assertFalse(this.stack.isEmpty());
        Assert.assertEquals(5, this.stack.size());
        Assert.assertTrue(this.stack.contains("Item1"));
        Assert.assertTrue(this.stack.contains("Item2"));
        Assert.assertTrue(this.stack.contains("Item3"));
        Assert.assertTrue(this.stack.contains("Item4"));
        Assert.assertTrue(this.stack.contains("Item5"));

    }

    @Test
    public void pop_Should_remove_element_and_shrink_When_stack_size_is_a_quarter_of_stack_length() {

        this.stack.push("Item1");
        this.stack.push("Item2");
        this.stack.push("Item3");
        this.stack.push("Item4");
        this.stack.push("Item5");
        this.stack.push("Item6");
        this.stack.push("Item7");
        this.stack.push("Item8");
        this.stack.push("Item9");
        this.stack.push("Item10");

        this.stack.pop();
        this.stack.pop();
        this.stack.pop();
        this.stack.pop();
        this.stack.pop();
        this.stack.pop();
        this.stack.pop();
        this.stack.pop();

        Assert.assertFalse(this.stack.isEmpty());
        Assert.assertEquals(2, this.stack.size());
        Assert.assertTrue(this.stack.contains("Item1"));
        Assert.assertTrue(this.stack.contains("Item2"));

    }

}
